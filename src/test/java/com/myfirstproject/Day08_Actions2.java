package com.myfirstproject;


import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Day08_Actions2 extends TestBase {

        /*
        Given user is on the https://www.amazon.com/
        When use click on “Account” link
        Then verify the page title contains “Your Account”
         */

    @Test
    public void hoverOverTest() {
        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //When use click on “Account” link
        /*
        To click on “Account” link we need to hover over on menu first.
        Because the “Account” link is hidden under menu.
        After hover over we will see the “Account” link  and click on in.
        If we do not hover over menu we can not see the “Account” link  and click on in.
         */

        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        //Hover over on menu
        //To do hover over we need to use Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();//This will take the mouse on menu

        //Now we can click on “Account” link
        driver.findElement(By.linkText("Account")).click();

        //Then verify the page title contains “Your Account”
        assertTrue(driver.getTitle().contains("Your Account"));

    }
}