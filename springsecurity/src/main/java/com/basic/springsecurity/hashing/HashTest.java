package com.basic.springsecurity.hashing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Slf4j
public class HashTest {
   public void main(String[] arg){
       List<String> passwords = List.of("abc123", "def123");
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       for(String password : passwords){
           log.info("password { }",password);
       }
   }
}
