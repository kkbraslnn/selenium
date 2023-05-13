package com.myfirstproject;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest {
     /*
    Pick a file on your desktop
    And verify if that file exist on your computer or not
     */

    @Test
    public void isExist(){
//        Pick a file on your desktop
        //To make the path dynamic we need to create home directory:
        String userHome = System.getProperty("user.home");
        //System.out.println(userHome);
        String pathOfFile = userHome+"/Desktop/flower.jpeg";
        //System.out.println("pathOfFile = " + pathOfFile);

//        And verify if that file exist on your computer or not
        assertTrue(Files.exists(Paths.get(pathOfFile)));

    }
}