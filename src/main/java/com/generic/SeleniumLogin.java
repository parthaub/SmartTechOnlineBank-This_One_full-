package com.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SeleniumLogin {

    public void getOpenBrowser() {

        

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///Users/parthadebnath/Desktop/Batch%2044/Automation%20/App/qa_online%20Banking%20monthly_yearly%20statement%20-bug%20fixed.html");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Batch44");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("student123@");

        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        boolean login_Status = driver.findElement(By.xpath("//*[@id=\"logoutButton\"]")).isDisplayed();
        System.out.println("Print logoutButton there: " + login_Status);

        
        Assert.assertTrue(login_Status); // hard Assert
        SoftAssert sa = new SoftAssert(); // spftAssert
        sa.assertTrue(login_Status);

        sa.assertAll();
        driver.quit();
    }
    
    

    public static void main(String[] args) {
        SeleniumLogin obj = new SeleniumLogin();
        obj.getOpenBrowser();
    }
}




