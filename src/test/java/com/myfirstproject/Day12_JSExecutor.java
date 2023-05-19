package com.myfirstproject;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Day12_JSExecutor extends TestBase {

    /*
    Go to https://www.amazon.com
    Scroll into footer
    Assert if that footer exists on the page
    Take a screenshot of the page
    Scroll into search box
    Verify the search box is displayed
    Take a screenshot of the page
     */
    @Test
    public void scrollIntoViewTest() throws InterruptedException, IOException {
//        Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

//        Scroll into footer
        WebElement footer = driver.findElement(By.xpath("//div[@class='navFooterLine navFooterLogoLine']"));
        Thread.sleep(3000);
        scrollIntoViewJS(footer);

//        Assert if that footer exists on the page
        assertTrue(footer.isDisplayed());

//        Take a screenshot of the page
        takeScreenshotOfTheEntirePage();

//        Scroll into search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);
        scrollIntoViewJS(searchBox);

//        Verify the search box is displayed
        assertTrue(searchBox.isDisplayed());

//        Take a screenshot of the page
        takeScreenshotOfTheEntirePage();

    }

    public static void scrollIntoViewJS(WebElement footer) {
    }


    /*
     Go to https://www.amazon.com
     Scroll all the way down and take a screenshot of the page
     Scroll all the way up and take a screenshot of the page
  */
    @Test
    public void scrollAllTheWayDownUpTest() throws InterruptedException, IOException {
//        Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

//        Scroll all the way down and take a screenshot of the page
        Thread.sleep(2000);
        scrollAllTheWayDownJS();
        takeScreenshotOfTheEntirePage();

//        Scroll all the way up and take a screenshot of the page
        Thread.sleep(2000);
        scrollAllTheWayUpJS();
        takeScreenshotOfTheEntirePage();

    }

    public void scrollAllTheWayDownJS() {
    }

    public void scrollAllTheWayUpJS() {
    }

    /*
    Go to https://www.amazon.com
    Type porcelain tea set in search box
    Take a screenshot of the page
    Click on search button
    Take a screenshot of the page
     */
    @Test
    public void clickByJSTest() throws IOException {
//        Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

//        Type porcelain tea set in search box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain tea set");

//        Take a screenshot of the page
        takeScreenshotOfTheEntirePage();

//        Click on search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        //searchButton.click(); ==> This is selenium click
        //We will use JS click
        clickByJS(searchButton);

//        Take a screenshot of the page
        takeScreenshotOfTheEntirePage();

    }

    public static void clickByJS(WebElement searchButton) {
    }


    /*
    Go to https://www.amazon.com
    Type porcelain tea set in search box
    Click on search button
     */
    @Test
    public void locateElementByJSTest(){

//        Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

//        Type porcelain tea set in search box
        WebElement searchBox = locateElementByJS("twotabsearchtextbox");
        searchBox.sendKeys("porcelain tea set");

//        Click on search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchButton);

    }

    public static WebElement locateElementByJS(String twotabsearchtextbox) {
        return null;
    }

    /*
    Go to https://www.amazon.com
    Type porcelain tea set in search box
    Click on search button
     */

    @Test
    public void typeWithJS(){

//        Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

//        Type porcelain tea set in search box
        WebElement searchBox = locateElementByJS("twotabsearchtextbox");
        //searchBox.sendKeys(); --> This is regular typing method in selenium. We will create a method that will type by using JavaScriptExecutor
        setValueByJS(searchBox,"porcelain tea set");

//        Click on search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchButton);

    }

    public static void setValueByJS(WebElement searchBox, String porcelain_tea_set) {
    }

    /*
    Go to http://www.uitestpractice.com/Students/Form
    Fill the form
    Click on submit
     */

    @Test
    public void studentFormTest(){
//        Go to http://www.uitestpractice.com/Students/Form
        driver.get("http://www.uitestpractice.com/Students/Form");

//        Fill the form
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElements(By.xpath("//input[@type='checkbox']")).forEach(WebElement::click);
        new Select(driver.findElement(By.id("sel1"))).selectByVisibleText("Canada");
        driver.findElement(By.id("datepicker")).sendKeys("01/01/2000");
        driver.findElement(By.id("phonenumber")).sendKeys(Faker.instance().phoneNumber().cellPhone());
        driver.findElement(By.id("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());
        driver.findElement(By.id("comment")).sendKeys("Hello i am an SDET");
        driver.findElement(By.id("pwd")).sendKeys("1234");

//        Click on submit
        //driver.findElement(By.xpath("//button[@type='submit']")).click();//Selenium click did not work. We will try js click
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickByJS(submitButton);

    }

}
