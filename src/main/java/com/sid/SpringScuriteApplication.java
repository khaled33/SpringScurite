package com.sid;

import com.sid.Service.AccountService;
import com.sid.entity.Role;
import com.sid.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringScuriteApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(SpringScuriteApplication.class, args);
	}
@Bean
	public BCryptPasswordEncoder geBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new Users(null,"Admin","123",null));
		accountService.saveUser(new Users(null,"User","1234",null));
		accountService.saveRole(new Role(null,"ADMIN"));
		accountService.saveRole(new Role(null,"USER"));

		accountService.addRoleToUser("Admin","ADMIN");
		accountService.addRoleToUser("Admin","USER");
		accountService.addRoleToUser("User","USER");

	}
}

