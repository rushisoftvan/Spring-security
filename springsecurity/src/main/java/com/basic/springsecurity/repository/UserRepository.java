package com.basic.springsecurity.repository;

import com.basic.springsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    public UserEntity getUserByUsername(@Param("username") String username);
}
