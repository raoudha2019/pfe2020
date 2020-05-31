package com.telnet.qcm;

import com.telnet.qcm.dao.UserRepository;
import com.telnet.qcm.service.PermissionService;
import com.telnet.qcm.service.RoleService;
import com.telnet.qcm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@ConfigurationProperties
@PropertySource("file:./application.properties")
public class CreateFiles {

    @Value("${qcm.folder}")
    @Autowired
    RoleService roleservice;
    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\Raoudha\\IdeaProjects\\qcm1.php");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Raoudha\\IdeaProjects\\qcm1.php");
            myWriter.write("<?php \n");
            myWriter.write("return array( \n ");
            myWriter.write("'meta' => array( \n" );
            myWriter.write("'title' =>', Qcmj  \n" );
            myWriter.write("'max_nb_questions' => 0,   \n" );
            myWriter.write("'status' => 'hidden' ), \n");
            myWriter.write("'questions' => array(  \n array( \n");
            myWriter.write("  \" Dans quel balise HTML plaçons-nous le code JavaScript? \" \n  ");
            myWriter.write("  array(\n" +
                    "                \"La balise <code>js</code>\" => false,\n" +
                    "                \"La balise <code>javascript</code>\" => false,\n" +
                    "                \"La balise <code>script</code>\" => true,\n" +
                    "                \"La balise <code>rel</code>\" => false\n" +
                    "            )\n" +
                    "        ),");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("C:\\Users\\Raoudha\\IdeaProjects\\qcm1.php");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}