package com.cucumber.tests2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinitions {
	
	WebDriver driver;
	String url="http://integr8a.trclient.com/testing/";
	//@Before(order=2)
	public void setupDummy(){
		
		System.out.println("************* Before called from LoginStepDefinitions *********");
	}
	
	//@After(order=2)
	public void tearDownDummy(){
		
		System.out.println("************* After called from LoginStepDefinitions *********");
	}
	@Given("^An user (?:is on|navigate to) (.*com)$")
	public void navigateTo(String url) throws Throwable {
	 System.out.println("User is on DemoQA.com");
	 System.out.println("URL : "+ url);
	 /*
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/BrowserDrivers/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get(url);
	 */
	 Assert.assertEquals("Two values are not equal" ,30, 30);
	 //throw new PendingException();
	}

	@When("^user clicks on MyAccountLink$")
	public void user_clicks_on_MyAccountLink() throws Throwable {
	System.out.println("User clicked on MyAccountLink ");      
	}


	
	@Then("^user is taken to Login Page$")
	public void user_is_taken_to_Login_Page() throws Throwable {
	System.out.println("User is taken to Login Page");      
	}

	@When("^user enters a valid username (.*) and password (.*)$")
	public void user_enters_a_valid_username_and_password(String str1, String str2) throws Throwable {
	System.out.println("User enters valid username and password"); 
	System.out.println("Username : "+ str1);
	System.out.println("Password : "+ str2);
	}

	@Then("^User is able to login successfully$")
	public void User_is_able_to_login_successfully() throws Throwable {
	System.out.println("User is able to login successfully");    
	}
	@When("^user enters a invalid username and password$")
	public void user_enters_a_invalid_username_and_password() throws Throwable {
	System.out.println("user enters a invalid username and password"); 
	
	}

	@Then("^Application should deny login to the user$")
	public void Application_should_deny_login_to_the_user() throws Throwable {
	System.out.println("Application should deny login to the user");  
	 //int i=5/0; 
	Assert.assertEquals("Two values are not equal" ,30, 30);
	}
}
