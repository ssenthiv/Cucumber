package com.cucumber.tests2;


import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;

//import org.junit.Before;
//import org.junit.After;
import com.cucumber.pages.SuiteModule1Page;
import com.cucumber.utils.Base;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubmitFormDefinitionAdvanced extends Base {
	String methodName; 
	
	//@Before("@ValidFormTest1")
	//@Before(value="10")
	//@Before(order=10)
	//@Before
	//public void startTestCase(){
	 static {
		 Add_Log.info("\tExecuting - Static block -"+ SubmitFormDefinitionAdvanced.class.getName());
		 
	 }
	 
	 public SubmitFormDefinitionAdvanced() {
		
		 methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 Add_Log.info("\tExecuting SubmitFormDefinitionAdvanced constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		 
	 }
	//@Before(order=1)
	public void setup(Scenario sc){
		TestCaseName=sc.getName();
		Add_Log.info("*********** Before : " +sc.getName() + " Started ***********");	
	}
	//@After(order=1)
	public void tearDown(Scenario sc){
		
		Add_Log.info("*********** After : " +sc.getName() + " Completed  ***********");
		System.out.println(sc.getStatus());
		System.out.println(sc.isFailed());
		//closeWebBrowser();
	}
	/*
	@Given("^User (?:launches|opens|navigates) http://integr(\\d+)a\\.trclient\\.com Page$")
	public void user_launches_http_integr_a_trclient_com_Page(int arg1) throws Throwable {
	    
	    
	    //loadBrowser("SubmitForm");
	    
		//System.out.println("Launching http://integr8a.trclient.com/testing");
	    Add_Log.info("^User (?:launches|opens|navigates) http://integr(\\d+)a\\.trclient\\.com Page$");
	    driver.get(param.getProperty("URL"));
	    module1=new SuiteModule1Page();
	   
	}
*/
	
	@When("^User fills the form with correct data$")
	public void user_fills_the_form_with_data(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		Add_Log.info("^User fills the form with correct data");
		
		
		Map<String,String> dataTableMap = dataTable.asMap(String.class,String.class);
		
		module1.sendKeysToFirstName(dataTableMap.get("FirstName"));
		module1.sendKeysToLastName(dataTableMap.get("LastName"));
		module1.sendKeysToEmail(dataTableMap.get("Email"));
		module1.sendKeysToMobileNo(dataTableMap.get("MobileNo"));
		module1.sendKeysToAddress(dataTableMap.get("Address"));
		module1.sendKeysToSuburb(dataTableMap.get("Suburb"));
		module1.selectState(dataTableMap.get("State"));
		module1.sendKeysToPostCode(dataTableMap.get("PostCode"));
		module1.sendKeysToDob(dataTableMap.get("Dob"));
		module1.clickOnTermsAndCondition(dataTableMap.get("TermsAndCondition"));
		module1.clickOnSubmit(dataTableMap.get("Submit"));
		
		
		
	    
	}
/*
	@Then("^I verify the Form not submitted$")
	public void i_verify_the_Form_not_submitted() throws Throwable {
	   System.out.println("Form is not submitted");
	   module1.verifyTestingFormSubmission(); 
	   //module1.verifyTestingFormConfirmation("Negative");
	}
*/
	
	@When("^User submit the form with multiple correct data and verify form$")
	public void user_submit_the_form_with_multiple_incorrect_data(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    
		for (Map<String,String> dataTableMap : dataTable.asMaps(String.class, String.class)){
			
			
			
			Add_Log.info("^User submit the form with multiple correct data and verify form$");
			
			module1.sendKeysToFirstName(dataTableMap.get("FirstName"));
			module1.sendKeysToLastName(dataTableMap.get("LastName"));
			module1.sendKeysToEmail(dataTableMap.get("Email"));
			module1.sendKeysToMobileNo(dataTableMap.get("MobileNo"));
			module1.sendKeysToAddress(dataTableMap.get("Address"));
			module1.sendKeysToSuburb(dataTableMap.get("Suburb"));
			module1.selectState(dataTableMap.get("State"));
			module1.sendKeysToPostCode(dataTableMap.get("PostCode"));
			module1.sendKeysToDob(dataTableMap.get("Dob"));
			module1.clickOnTermsAndCondition(dataTableMap.get("TermsAndCondition"));
			module1.clickOnSubmit(dataTableMap.get("Submit"));
			module1.verifyTestingFormSubmission(); 
			
			
		}
	}
		
		@When("^User Enters data for Scenario Template FirstName (.*)  LastName (.*) Email  (.*) MobileNo  (.*)   Address  (.*) Suburb  (.*) State  (.*) PostCode  (.*) Dob  (.*) TermsAndCondition (.*) Submitn  (.*) button$")
		public void user_submit_the_form_with_multiple_data_withScenarioTemplate(String FirstName , String LastName, String Email, String MobileNo, String Address, String Suburb,String State,String PostCode,String Dob,String TermsAndCondition,String Submit) throws Throwable {
		
			Add_Log.info("^User Enters data for Scenario Template FirstName..$");
			
			//module1=new SuiteModule1Page();
			module1.sendKeysToFirstName(FirstName);
			module1.sendKeysToLastName(LastName);
			module1.sendKeysToEmail(Email);
			module1.sendKeysToMobileNo(MobileNo);
			module1.sendKeysToAddress(Address);
			module1.sendKeysToSuburb(Suburb);
			module1.selectState(State);
			module1.sendKeysToPostCode(PostCode);
			module1.sendKeysToDob(Dob);
			module1.clickOnTermsAndCondition(TermsAndCondition.trim());
			module1.clickOnSubmit(Submit);
		}
		
	
}
