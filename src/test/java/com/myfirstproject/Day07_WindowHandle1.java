package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class Day07_WindowHandle1 extends TestBase {
        /*
        Given user is on the https://the-internet.herokuapp.com/windows
        Then user verifies the text : “Opening a new window”
        Then user verifies the title of the page is “The Internet”
        When user clicks on the “Click Here” button
        Then user verifies the new window title is “New Window”
        Then user verifies the text: “New Window”
        When user goes back to the previous window and then verifies the title : “The Internet”
        */

    @Test
    public void windowHandleTest() throws InterruptedException {
//        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

//        Then user verifies the text : “Opening a new window”
        String page1Header = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("Opening a new window", page1Header);

//        Then user verifies the title of the page is “The Internet”
        String page1Title = driver.getTitle();
        assertEquals("The Internet", page1Title);

//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

//        Then user verifies the new window title is “New Window”
        String window1Handle = driver.getWindowHandle();//This will take current windows handle(1st window)
        System.out.println("window1Handle = " + window1Handle);
        Set<String> allWindowHandles = driver.getWindowHandles();//This will take all windows handle in a Set
        System.out.println("allWindowHandles = " + allWindowHandles);

        for (String w : allWindowHandles) {
            if (!w.equals(window1Handle)) {
                driver.switchTo().window(w);//This will switch driver to window 2
                break;
            }
        }

//        Then user verifies the text: “New Window”
        assertEquals("New Window", driver.getTitle());
        String window2Handle = driver.getWindowHandle();


//        When user goes back to the previous window and then verifies the title : “The Internet”
        Thread.sleep(2000);
        driver.switchTo().window(window1Handle);//Driver is on 2nd window. Now this will take it to window 1
        assertEquals("The Internet", driver.getTitle());

        //Switch back to Window 2
        Thread.sleep(2000);
        driver.switchTo().window(window2Handle);

        //Switch back to Window 1
        Thread.sleep(2000);
        driver.switchTo().window(window1Handle);

        //Switch back to Window 2
        Thread.sleep(2000);
        driver.switchTo().window(window2Handle);

        //Switch back to Window 1
        Thread.sleep(2000);
        driver.switchTo().window(window1Handle);

    }
}