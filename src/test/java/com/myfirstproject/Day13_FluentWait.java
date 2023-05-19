package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Day13_FluentWait extends TestBase {
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
//    When user clicks on the Start button
//    Then verify the ‘Hello World!’ Shows up on the screen

    @Test
    public void fluentWaitTest(){
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        driver.findElement(By.xpath("//button")).click();

        //Using Fluent Wait:
        //1st: Create wait object
        Wait<WebDriver> wait = new FluentWait<>(driver)//This is other type of Explicit Wait
                .withTimeout(Duration.ofSeconds(20))//Total wait--> After 20 seconds TimeoutException will be thrown
                .pollingEvery(Duration.ofSeconds(3))//Time period driver checks the element
                .withMessage("NoSuchElementException ignored")//Message in failure case
                .ignoring(NoSuchElementException.class);//Ignoring the exception

        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));

//    Then verify the ‘Hello World!’ Shows up on the screen
        assertEquals("Hello World!",helloWorld.getText());

    }

    @Test
    public void fluentWaitTest2(){
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        driver.findElement(By.xpath("//button")).click();

        WebElement helloWorld = fluentWait("//h4[.='Hello World!']",20,2);

//    Then verify the ‘Hello World!’ Shows up on the screen
        assertEquals("Hello World!",helloWorld.getText());

    }

}