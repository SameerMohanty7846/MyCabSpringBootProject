package in.myorg.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.myorg.dao.AdminRepository;
import in.myorg.entity.Admin;
import jakarta.annotation.PostConstruct;

@Service
//We have to register this class as a bean class so that IOC will control it's lifecycle
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository repo;

	@Autowired
	private PasswordEncoder encoder;// It will not be automatically injected we have to make a bean of it in config

	@PostConstruct
	public void init() {
		// This is a bean lifecycle method which is automatically executed no need to
		// call
		// This is unnecessary we do this just for if no username and password is set
		// this username and password
		// is set for some default username and password
		if (repo.count() == 0) {// check if data exist or not in the repo
			Admin admin = new Admin();
			admin.setUsername("admin");
			admin.setPassword(encoder.encode("admin123"));// we have to encrypt the password

			repo.save(admin);//

		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// select * from admin
		Optional<Admin> byUsername = repo.findByUsername(username);
		// When you entered the information in the login page the data came here for
		// checking if exist or not

		// if we don't get the data throw an Exception
		Admin admin = byUsername.orElseThrow(() -> new UsernameNotFoundException("ADMIN DOESNOT EXIST"));
		// lambda to throw Exception if User does not exist
		// We can give message inside the Constructor of Exception
		// If the data exist we will get the Object otherwise it will throw the
		// Exception
		// If a value is present, returns the value, otherwise throws an
		// exceptionproduced
		// by the exception supplying function.
		// We could have the same thing using if-else

		return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();
		// It will check with the username and password which will be automatically
		// coming to it
		// with the data coming from the database if wrong raise
		// UsernameNotFoundException
		// else build the UserDetails
		// It's the last phase where the whole checking happens with database

	}

}
