package com.basic.springsecurity.config;

import com.basic.springsecurity.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class MyUserDetails implements UserDetails {

    private final UserEntity userEntity;


    public UserEntity getUserEntity(){
        return userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userEntity.getRole());
        return List.of(authority);
    }

    @Override
    public String getPassword() {
      return  this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
       return this.userEntity.getUsername();

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isEnabled();
    }
}
