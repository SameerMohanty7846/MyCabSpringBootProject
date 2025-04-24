package in.myorg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.myorg.dao.AdminRepository;
import in.myorg.entity.Admin;

@Service
public class AdminCredentialsServiceImpl implements AdminCredentialsService {
	@Autowired
	private AdminRepository repo;

	@Autowired
	private PasswordEncoder encoder;// It will not be automatically injected we have to make a bean of it in config

	@Override
	public String checkAdminCredentials(String oldusername, String oldpassword) {
		Optional<Admin> byUsername = repo.findByUsername(oldusername);
		if (byUsername.isPresent()) {
			Admin admin = byUsername.get();
			boolean matches = encoder.matches(oldpassword, admin.getPassword());
			if (matches) {
				return "SUCCESS";
			} else {
				return "WRONG OLD CREDENTIALS";
			}
		} else {
			return "WRONG OLD CREDENTIALS";
		}

	}

	@Override
	public String updateAdminCredentials(String newusername, String newpassword, String oldusername) {
		int result = repo.updateCredentials(newusername, encoder.encode(newpassword), oldusername);
		if (result == 1) {
			return "CREDENTIALS UPDATED SUCCESSFULLY";
		} else {
			return "FAILED TO UPDATE CREDENTIALS";

		}
	}

}
