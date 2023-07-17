package com.basic.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    public static final String[] PUBLIC_URL = {"/home", "/about", "/contect-us"};
    public static final String[] CUSTOMER_ROLE_URL = {"/checkbalance", "/accountInfo"};

    //this for Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("abc").password("$2a$10$utJiiLVM32Gfvw9SeETZiOOZi4PcioFOiJbXW7GXqiAeL9wD10zlK").authorities("ROLE_ADMIN")//abc123
                .and().withUser("def").password("$2a$10$gFohvIQXlvNnFlkyev6xH.A7FChD5wElgr2Y/E2FZqFXr4p91BUrm").authorities("ROLE_CUSTOMER")//def123
                .and().passwordEncoder(passwordEncoder());
    }

    //this for authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //this method use for role managment who are access which url
        http.authorizeRequests()
                /*
                   ant matcher method is use for to macthc(compare) to request url(path) to with controller method url path
                   if they are matched ant is technic to compare string. if they are matched it s connecting authority  type permitall, autonticated,hasautority


                   if two method with same name like
                   /regiter with get or post at time use we have  to use antMatcher(HttpMethod.get,"/register")
                   and antMatchers(HttpMethod.post,"//register")

                   anyRequest(): It indicates non configuried which are in appliaction(controller path)
                   consider In project 5 url at controller method level
                   mostly us autonticated use in any request In real time project

                 */
                .antMatchers(PUBLIC_URL).permitAll()//every one can access

                // hasAutority means authenticated and Role also match
                .antMatchers("/banksetting").hasAuthority("ROLE_ADMIN")//has authority for Role// logine + role-ROLE_ADMIN
                .antMatchers(CUSTOMER_ROLE_URL).hasAuthority("ROLE_CUSTOMER")//logine + role -ROLE_Customer
                .antMatchers("/common").hasAnyAuthority("ROLE_ADMIN","ROLE_CUSTOMER")//we can give multipale role to acces common url poth caan acees(any 0ne - Customer or admin)
                .anyRequest().authenticated()//autonticated people can access
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .formLogin() // for browser
                .and()
                .httpBasic();//for rest api
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance(); // Not  Recommended
        return new BCryptPasswordEncoder(); // It is Recommended
    }

    /*
      protected void configure(HttpSecurity http) throws Exception
      {

         //url acees type

            /this method use for role managment who are access which url
        http.authorizeRequests()

         //Login Form details

         //Locaout Details
          .and().logout().
          logoutRequestMatcher(new AntPatchRequestMatcher"/logoutMacher")

         //ExceptionDetails
         and().exceptionHandling().
         accessDenigPage("/domain")
      }

     */

}
