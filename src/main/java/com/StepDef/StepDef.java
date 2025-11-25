package com.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

    WebDriver driver;

    @Given("Open any browser")
    public void Open_any_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Pass URL")
    public void Pass_URL() {
        driver.navigate().to("file:///Users/parthadebnath/Desktop/Batch%2044/Automation%20/App/qa_online%20Banking%20monthly_yearly%20statement%20-bug%20fixed.html");
    }

    @When("Enter valid username")
    public void Enter_valid_username() {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Batch44");
    }

    @When("Enter valid password")
    public void Enter_valid_password() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("student123@");
    }

    @When("Click login button")
    public void Click_login_button() {
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
    }

    @Then("Login should be successful and see logout button")
    public void Login_should_be_successful_and_see_logout_button() {
        boolean Login_status = driver.findElement(By.xpath("//*[@id=\"logoutButton\"]")).isDisplayed();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(Login_status, "Logout button should be displayed for successful login.");
        sa.assertAll();
        System.out.println("Check login status : " + Login_status);
    }

    @When("Enter invalid username")
    public void Enter_invalid_username() {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tch44");
    }

    @When("Enter invalid password")
    public void Enter_invalid_password() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("stunt123@");
    }

    @When("Enter empty username")
    public void Enter_empty_username() {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
    }

    @When("Enter empty password")
    public void Enter_empty_password() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
    }

    @Then("Login should fail and stay on login page")
    public void Login_should_fail_and_stay_on_login_page() {
        boolean Login_status;
        try {
            Login_status = driver.findElement(By.xpath("//*[@id=\"logoutButton\"]")).isDisplayed();
        } catch (Exception e) {
            Login_status = false; // If logout button not present, fail login
        }
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(Login_status, "Logout button should NOT be displayed after failed login.");
        sa.assertAll();
        System.out.println("Check login status : " + Login_status);
    }
        
        
        // -- Add your new parameterized steps --
        @When("Enter {string} in username field")
        public void enter_username_in_field (String username) {
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        }

        @When("Enter {string} in password field")
        public void enter_password_in_field(String password) {
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        
    }
}
