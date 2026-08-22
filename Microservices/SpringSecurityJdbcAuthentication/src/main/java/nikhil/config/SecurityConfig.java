package nikhil.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//1. Authorization
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				request->request.requestMatchers("/home","/").permitAll()
								.requestMatchers("/admin").hasAuthority("ADMIN")
								.requestMatchers("/customer").hasAuthority("CUSTOMER")
								.requestMatchers("/hello").authenticated()
								.anyRequest().permitAll()
				).formLogin(form->form.loginPage("/login").permitAll())
				.logout(logout->logout.permitAll()).build();
	}
	
	
	//2. Authentication
	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		//jdbc storage and authentication using "predefined filter"
		UserDetails user1 = User.withUsername("Nikhil")
				.password(passwordEncoder.encode("12345678"))
				.authorities("CUSTOMER")	
				.build();
		UserDetails user2 = User.withUsername("Sachin")
				//qwertyuiop
				.password(
						"$2a$12$SY2wRm60j8Yqmz8T/SosJem8CZL4aSWbm2B9OhDcLmRJrdXRx8b.i"
						).authorities("ADMIN")	
				.build();
		
		 JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		 userDetailsManager.createUser(user1);
		 userDetailsManager.createUser(user2);
		 return userDetailsManager;
	}

}
