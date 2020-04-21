package com.telnet.qcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import org.springframework.beans.factory.annotation.Autowired;
//impot com.telnet.qcm.dao.UserRepository;

@SpringBootApplication
public class TelnetQcmApplication {


    public static void main(String[] args) {
        SpringApplication.run(com.telnet.qcm.TelnetQcmApplication.class, args);
    }

   @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
   }
}
