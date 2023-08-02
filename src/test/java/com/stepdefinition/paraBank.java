package com.stepdefinition;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.baseclass;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class paraBank extends baseclass {
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getProperties("URI"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	@When("User should click on Register")
	public void user_should_click_on_register()
	{
		WebElement BtnSubmit = driver.findElement(By.xpath("//a[text()='Register']"));
		BtnSubmit.click();
	}

	


	@When("User should enter {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} ,{string} and {string}")
	public void user_should_enter_and(String FirstName, String LastName, String Address, String City, String State, String SSN, String UserName, String Password, String ConfirmPassword, String ZipCode) throws IOException {
	
		WebElement firstName = driver.findElement(By.xpath("//input[@id='customer.firstName']"));
		firstName.sendKeys(getProperties("FirstName"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
		lastName.sendKeys(getProperties("LastName"));
		WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
		address.sendKeys(getProperties("Address"));
		WebElement city = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
		city.sendKeys(getProperties("City"));
		WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
		state.sendKeys(getProperties("State"));
		WebElement postcalcode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
		postcalcode.sendKeys(getProperties("ZipCode"));
		WebElement Ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
		Ssn.sendKeys(getProperties("SSN"));
		WebElement Username = driver.findElement(By.xpath("//input[@id='customer.username']"));
		Username.sendKeys(getProperties("UserName"));
		WebElement pswd = driver.findElement(By.xpath("//input[@id='customer.password']"));
		pswd.sendKeys(getProperties("Password"));
		WebElement ConfirmPswd = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
		ConfirmPswd.sendKeys(getProperties("ConfirmPassword"));
		
		
	}
	@When("User should click on registeration")
	public void user_should_click_on_registeration()
	{
		WebElement BtnSubmit = driver.findElement(By.xpath("//input[@value='Register']"));
		BtnSubmit.click();
	}
	@Then("User should Verify Success Message {string}")
	public void user_should_verify_success_message(String SuccessMessage) throws InterruptedException 
	{
			Thread.sleep(5000);
			WebElement ErrorTxt = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
			String locatorTXt = ErrorTxt.getText();
			Assert.assertEquals(SuccessMessage, locatorTXt);
		}
	}




