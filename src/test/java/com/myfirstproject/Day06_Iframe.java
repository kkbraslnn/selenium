package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;

public class Day06_Iframe extends TestBase {
//    https://testcenter.techproeducation.com/index.php?page=iframe
//    click on the Back to TechProEducation.com

    @Test
    public void iframeTest() throws InterruptedException {
//        going to the page
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

//        the element is INSIDE THE IFRAME SO SWITCH THE FRAME FIRST
        /*
        NOTE: I have to switch to the frame otherwise I will get no such element exception when
        I try to locate button
        When I switch to the frame I will locate the element and wil not get no such element exception
         */
        //There are 3 ways to switch to iframe : by index, id/class, or webelement
        //driver.switchTo().frame(0);//by index ==> index starts from 0
        // driver.switchTo().frame("id or name attribute");
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@src='/index.php']"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
//        location the element inside the frame and trying to click
        WebElement techProLink = driver.findElement(By.xpath("//a[@type='button']"));
        Thread.sleep(2000);


//        NOTE: NORMAL CLICK DIDN'T WORK I USED JS EXECUTOR YOU WILL LEARN THIS LATER
//        element.click(); UNFORTUNATELLY DIDN'T WORK

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", techProLink);
        techProLink.sendKeys(Keys.ENTER);

        //Assert that if h3 element's text equals to "iframe"
        //Driver is still inside iframe. We need to take it back to parent page where h3 element belongs to.
        //driver.switchTo().parentFrame();//This will take driver one step back to parent page.
        driver.switchTo().defaultContent();//This will take driver to  back to main/most upper page.
        String h3Text = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("h3Text = " + h3Text);
        assertEquals("iframe", h3Text);

        System.out.println(driver.findElements(By.xpath("//iframe")).size());//1 ==> number of iframes in this page

    }
}