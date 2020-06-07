package com.telnet.qcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

//import org.springframework.beans.factory.annotation.Autowired;
//impot com.telnet.qcm.dao.UserRepository;


@SpringBootApplication
public class TelnetQcmApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(com.telnet.qcm.TelnetQcmApplication.class, args);
       /* File myObj = new File("C:\\Users\\Raoudha\\IdeaProjects\\test.php");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        }
        else
        {
            System.out.println("File already exists.");
        }*/
    }

   @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
   }



}
