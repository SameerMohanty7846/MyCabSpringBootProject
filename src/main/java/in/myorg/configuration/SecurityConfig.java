package in.myorg.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomLogoutHandler logoutHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();//it's an interface
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(authorize->authorize
				
		.requestMatchers("/admin/**").authenticated()//for which request to be not allowed
		.requestMatchers("/**").permitAll()//for which request to be allowed
		
		)
		.formLogin(form->form
				.loginPage("/login")
				
				.permitAll()//which type of login is required for the page which requires authentication
				
		)
		.logout(logout->logout
				.addLogoutHandler(logoutHandler)
				.logoutUrl("/dologout"));
		
		
		
		
		
		return httpSecurity.build();
	}
}
