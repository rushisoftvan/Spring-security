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



     */
}
