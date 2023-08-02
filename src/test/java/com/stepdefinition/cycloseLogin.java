package com.stepdefinition;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cycloseLogin extends baseclass {
	WebDriver driver;

	@Given("Launch the browser")
	public void launch_the_browser() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getProperties("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Provide Username and Password")
	public void provide_username_and_password() throws IOException, InterruptedException {
		WebElement Username = driver.findElement(By.xpath("//input[@type='text']"));
		Username.sendKeys(getProperties("USERNAME"));
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys(getProperties("PASSWORD"));
	}

	@When("Click on submit Button")
	public void click_on_submit_button() {
		WebElement BtnSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
		BtnSubmit.click();
	}

	@Then("user is going to verify {string}")
	public void user_is_going_to_verify(String Text) throws InterruptedException {

		Thread.sleep(5000);
		WebElement VerifyTxt = driver.findElement(By.xpath("//div[text()='Banking']"));
		String Txt = VerifyTxt.getText();
		Assert.assertEquals(Text, Txt);
		driver.quit();

	}

//	@Given("Launch Browser")
//	public void launch_browser() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Given("Launch window pop-up")
//	public void launch_window_pop_up() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@When("Provide invalid username and password")
	public void provide_invalid_username_and_password() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebElement Username = driver.findElement(By.xpath("//input[@type='text']"));
		Username.sendKeys(getProperties("username"));
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys(getProperties("password"));

	}

//	@When("Click submit button")
//	public void click_submit_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@Then("user move to page by {string}")
	public void user_move_to_page_by(String ErrorMsg) throws InterruptedException {
		Thread.sleep(5000);
		WebElement ErrorTxt = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
		String locatorTXt = ErrorTxt.getText();
		Assert.assertEquals(ErrorMsg, locatorTXt);
	}


}
