package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_Title {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();//setup
        WebDriver driver = new ChromeDriver();//create crome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicit wait
        driver.manage().window().maximize();//maximize windows

        // Create a new class: VerifyTitleTest 
        // Navigate to techproeducation homepage 
        // Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

        driver.get("https://www.techproeducation.com");
        String actualTitle = driver.getTitle();//returns the Title of the page as string

        if (actualTitle.equals("Techpro Education | Online It Courses & Bootcamps")) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("EXPECTED TITLE:Techpro Education | Online It Courses & Bootcamps");
            System.out.println("ACTUAL TITLE: " + actualTitle);
        }
        driver.quit();
    }
}
