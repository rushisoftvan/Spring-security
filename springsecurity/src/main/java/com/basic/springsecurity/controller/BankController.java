package com.basic.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/home")
    public String home() {
        return "welcome to xyz bank";
    }

    @GetMapping("/about")
    public String about() {
        return "Information about xyz bank";
    }

    @GetMapping("/contect-us")
     public String contectUs() {
        return "xyz bank contect form";
    }

    @GetMapping("/accountInfo")
    public String accountInfo() {
        return "Your Account informmation below";
    }

    @GetMapping("/checkbalance")
    public String checkBalance() {

        return "Your Account balance is 500";
    }

    @GetMapping("/banksetting")
    public String bankSetting() {
        return "only admin can to the bank setting";
    }

    @GetMapping("/common")

    public String common(){
        return "this is for commom";
    }

    @GetMapping("/logout")
    public String logout(){
      return "Account is logout";
    }

    @GetMapping("/test")
   // @PreAuthorize(value="hasAuthority('ADMIN')")
   // @PreAuthorize(value="hasRole(ROLE_CUSTOMER')")
    public String getPreAutorized(){
       return "getPreAutorized";
    }

}

