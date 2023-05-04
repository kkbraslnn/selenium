package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Navigations {
    public static void main(String[] args) {
        //1.Set Up
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver_mac64-2/chromedriver");
        //2.Create the driver object
       // WebDriver driver = new ChromeDriver();
        //3.Now that we have our driver instance,we can START CREATING OUT TEST SCRIPT
        //Create chrome driver
        WebDriver driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");
        driver.navigate().to("https://www.amazon.com/");
        //Navigate back to google
        driver.navigate().back();
        //Navigate forward to amazon
        driver.navigate().forward();
        //Refresh the page
        driver.navigate().refresh();
        //Close/Quit the browser
       // driver.close();
        //driver.quit();
        //we should NOT use both.

        /*
        ******What is the difference between get and navigate to functions?******
        * Similarities:both let you go to a page
        * get is more common that navigate to
        * get accepts ONLY string as url,naviagte to accepts both string and url
        * navigate has more options such as to(),back(),forward(),refresh()
        *
        * ***What is the difference between close and quit?
        * close closed ONLY the last active window
        * quit closes ALL ACTIVE windows
        * recommendation is use quit at the end of the last test case
         */

    }
}
