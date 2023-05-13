package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class Day09_AutoComplete extends TestBase {
   /*
    Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
    When user type “uni” in the search box
    And select the ‘United Kingdom’ from the suggestions
    And click on submit button
    Then verify the result contains ‘United Kingdom’
     */

    @Test
    public void autoCompleteTest() throws InterruptedException {
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

//        When user type “uni” in the search box
        Thread.sleep(3000);
        driver.findElement(By.id("myCountry")).sendKeys("uni");

//        And select the ‘United Kingdom’ from the suggestions
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[.='United Kingdom']")).click();

//        And click on submit button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

//        Then verify the result contains ‘United Kingdom’
        String resultText = driver.findElement(By.id("result")).getText();
        assertTrue(resultText.contains("United Kingdom"));

    }
}