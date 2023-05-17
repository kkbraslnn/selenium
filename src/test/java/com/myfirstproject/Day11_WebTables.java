package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day11_WebTables extends TestBase {

        /*
        Go to: https://the-internet.herokuapp.com/tables
        Task 1 : Print the entire table
        Task 2 : Print All Rows
        Task 3 : Print Last row data only
        Task 4 : Print column 5 data in the table body
        Task 5 : Write a method that accepts 2 parameters
        Parameter 1 = row number
        Parameter 2 = column number
        printData(2,3); => prints data in 2nd row 3rd column
         */

    //Task 1 : Print the entire table
    @Test
    public void printEntireTable() {

        driver.get("https://the-internet.herokuapp.com/tables");
        String entireTable = driver.findElement(By.id("table1")).getText();
        System.out.println("entireTable = " + entireTable);

        //Alternatively
        //Print each rows
        System.out.println("\n===Print each rows===\n");
        List<WebElement> allRows = driver.findElements(By.xpath("(//table)[1]//tr"));

        for (WebElement w : allRows) {
            System.out.println(w.getText());
        }

        //Print each data
        System.out.println("\n===Print each data===\n");
        List<WebElement> allData = driver.findElements(By.xpath("(//table)[1]//td"));
        allData.forEach(t -> System.out.println(t.getText()));

    }

    //Task 2 : Print All Rows
    @Test
    public void printAllRows() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("\n===Print All Rows===\n");
        List<WebElement> allRows = driver.findElements(By.xpath("(//tbody)[1]//tr"));//tbody tag covers onlt table body. we will not get header part
        int rowNumber = 1;
        for (WebElement w : allRows) {
            System.out.println(rowNumber + ". row: " + w.getText());
            rowNumber++;
        }
        //Print 2nd row
        System.out.println("\n===Print 2nd row===\n");
        System.out.println(allRows.get(1).getText());

    }

    //Task 3 : Print Last row data only
    @Test
    public void printLastRow() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("\n===Print Last Row===\n");
        List<WebElement> allRows = driver.findElements(By.xpath("(//table)[1]//tr"));
        System.out.println(allRows.get(allRows.size() - 1).getText());//(allRows.size()-1) --> last index

        //We can use alternatively this xpath to get last element: (//tbody)[1]//tr[last()]
        System.out.println("\n===//tr[last()]===\n");
        WebElement lastRow = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        System.out.println(lastRow.getText());

    }

    // Task 4 : Print column 5 data in the table body
    @Test
    public void printColumn5() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("\n===Print Column 5===\n");
        List<WebElement> column5Data = driver.findElements(By.xpath("(//table)[1]//td[4]"));

        //column5Data.forEach(t-> System.out.println(t.getText()));
        int rowNumber = 1;
        for (WebElement w : column5Data) {
            System.out.println(rowNumber + ". row: " + w.getText());
            rowNumber++;
        }

    }

        //    Task 5 : Write a method that accepts 2 parameters
        //    Parameter 1 = row number
        //    Parameter 2 = column number
        //    printData(2,3); => prints data in 2nd row 3rd column

    public String printCell(int rowNumber, int columnNumber) {

        String cellValue = driver.findElement(By.xpath("(//table)[1]//tr[" + rowNumber + "]//td[" + columnNumber + "]")).getText();

        return cellValue;

    }

    @Test
    public void getCellValueTest() {

        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("\n===Print Cell Value Parameterized===\n");
        System.out.println(printCell(4, 1));

    }

}