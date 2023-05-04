package com.myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day03_Annotations {

    /*
    There are 6 JUnit annotations
    1. @Test ==> Used to create test case
    Test methods must have @Test annotation. They must be public and void because they are created to do assertions.
    2. @Before and @After ==> Used to run before and after EACH @Test method
    3. @BeforeClass and @AfterClass ==> Used to run before and after EACH Class only ONCE. These methods must be static

     */

    @Before
    public void setUp(){
        System.out.println("This is BEFORE method. This RUNS before EACH @Test method");
        //Pre-conditions are put in this @Before method such as SET UP, create driver, maximize window, implicit wait...
    }

    @After
    public void tearDown(){
        System.out.println("This is AFTER method. This RUNS after EACH @Test method");
        //After-conditions are put in this @After method such as quit and close driver, reports ...
    }

    @BeforeClass
    public static void setUpClass(){

    }



    @Test
    public void test01(){
        System.out.println("This is test case 1");
    }

    @Test
    public void test02(){
        System.out.println("This is test case 2");
    }

    @Test
    public void test03(){
        System.out.println("This is test case 3");
    }

    @Test
    public void test04(){
        System.out.println("This is test case 4");
    }

    @Test
    public void test05(){
        System.out.println("This is test case 5");
    }

    @Test
    public void test06(){
        System.out.println("This is test case 6");
    }




}
