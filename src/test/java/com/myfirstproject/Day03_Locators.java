package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Day03_Locators {
    /*
    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    And enter username
    And enter password
    And click on submit button
    Then verify the login is successful
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() throws InterruptedException {
//        When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        And enter username
        WebElement userNameBox = driver.findElement(By.name("username"));//Identify the element
        userNameBox.sendKeys("Admin");//Perform the action
        Thread.sleep(3000);//This is hard wait(Java wait). This waits in any condition. This will keep execution for 3 seconds.

//        And enter password
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("admin123");
        Thread.sleep(3000);

//        And click on submit button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

//        Then verify the login is successful
        String url = driver.getCurrentUrl();
        assertEquals("Url did not match","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",url);
        Thread.sleep(3000);

    }

    @After
    public void tearDown(){
        driver.close();
    }

}