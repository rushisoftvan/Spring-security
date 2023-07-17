package com.basic.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringsecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringsecurityApplication.class, args);

//			List<String> passwords = List.of("abc123", "def123");
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//			for(String password : passwords) {
//				String encode = encoder.encode(password);
//				log.info("password {}", encode);
//			}
	}

}
