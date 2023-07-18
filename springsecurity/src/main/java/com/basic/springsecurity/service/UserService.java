package com.basic.springsecurity.service;

import com.basic.springsecurity.config.MyUserDetails;
import com.basic.springsecurity.entity.UserEntity;
import com.basic.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.getUserByUsername(username);
       // UserEntity userByUsername = this.userRepository.getUserByUsername(username);
        UserDetails userDetails = new MyUserDetails(userEntity);


        if (userDetails == null){
            throw new UsernameNotFoundException("User does not exists with username " + username);
        }

        return userDetails;
    }
}
