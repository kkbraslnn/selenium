package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_WebDriverManager {
    public static void main(String[] args) {
        //without webdriver manager

        //testing on chrome
       // System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver_mac64-2/chromedriver");
        // WebDriver chrome = new ChromeDriver();

        //testing on firefox
       // System.setProperty("webdriver.firefox.driver","./driver/firefoxdriver");
        // WebDriver firefox = new FirefoxDriver();

        //testing on edge
      //  System.setProperty("webdriver.edge.driver","./driver/edgedriver");
      //  WebDriver edge = new EdgeDriver();

        //    *****with webdriver manager*****
        WebDriverManager.chromedriver().setup();//chrome setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

       // WebDriverManager.firefoxdriver().setup();
       // WebDriver driver = new FirefoxDriver();
       // driver.manage().window().maximize();
       // driver.get("https://www.techproeducation.com");


    }
}
