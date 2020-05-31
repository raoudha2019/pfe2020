package com.telnet.qcm.controller;

import java.io.File;
import java.io.IOException;
public class CreateFile {

        public CreateFile() {
            try {
                File myObj = new File("C:\\Users\\Raoudha\\IdeaProjects");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                    System.out.println("Absolute path: " + myObj.getAbsolutePath());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

  }

