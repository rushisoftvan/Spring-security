package com.basic.springsecurity.config;

public class Note {

    /*
         Raghu part 4

         Spring jdbc database
      *) Spring security using jdbcauthentication
      In this case we have to store  userdata inside database tables.
      Data like username,password,role,enabled.
        step -1 : create one database table for users data.
        step -2 : Insert row(un,passwoed,role,enabled).
        step 3  : define two sqls query (used in security)
                  sql1: fecth un,password,enabled,using username
                  sql2 : fetch un,role using username
        step 4 :  add extra dependnecies :  spring jdbc , database (mysql_connecter/oracale jdbc)
        step 5 : provide datasourse in application properties
        step 6 : provide Configuration for authentication manager by providing sql1 for user data , sql2 for userRole,datasource and password encoder

                 auth.jdbcAuthentication()
                     .datasource(datasourcereference)
                     .userByUserNameQuery(sql1)
                     .authoritiesByusernameQuery(sql2)
                     .passwordEncoder(method which define in your config class for encode password  )

     =================================== Full code=======================================================
      two query which is required
      select username,password,enabled from user where username=?';
      sql 2 fetch username, role based on username
      select username,role from users where username=?";

     =====================================full code =====================================================
      PasswordEncoder(Interface)= it used  to convert password readable to unreadable format(encode).

 =============================================================session 5 ==================================================================================
                                            MR.RAGU      spring security
                                      ---------------------
                        Spring Security by orm framwork[DATA JPA] (USERDetailservice)
 * multiple step in big application

 1. User Register
 2.user login process
    .passwordEncoder
 3.Email Notification
 4.custom login page
 5.session management
 6.CROS or  CSRF Token
 ====================================================================
                                   1.User Register
 *)Define one register page withe required input(email,pwd,role)
   we can even  add extra input like gender ,address,Mobile,
 *)this data(Form data) must be converted to one model class object(User class)
 *)same object (User object) must be store in db table

application.properties
database information
spring.jpa.show-sql=true
Note Dialect is class which convert our database operation(save,delete,merge,periset) to the database  query

     */

}
