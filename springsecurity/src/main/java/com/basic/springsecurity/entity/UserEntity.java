package com.basic.springsecurity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

      @Entity
      @Getter
      @Setter
    public class UserEntity {
        @Id
        @Column(name = "user_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String password;
        private String role;
        private boolean enabled;
    }

