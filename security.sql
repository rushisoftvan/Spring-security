


create database springsecuritytest;
use springsecuritytest;


create table

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);



-- For NoOpsPasswordEncoder
INSERT INTO `springsecuritytest`.`users` (`username`, `password`, `role`, `enabled`) VALUES ('abc', 'abc123', 'CUSTOMER', '1');
INSERT INTO `springsecuritytest`.`users` (`username`, `password`, `role`, `enabled`) VALUES ('def', 'def123', 'ADMIN', '1');
