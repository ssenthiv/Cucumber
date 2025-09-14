package com.cucumber.tests4;


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
	private Base base;
	 static {
	 	
		//Add_Log.debug("**** "+this.getClass().getSimpleName() + " Started **** " );
		//Add_Log.debug("**** static block: tests2.SubmitFormDefinitionAdvanced  **** " );
		 Add_Log.debug("**** static block: " + SubmitFormDefinitionAdvanced.class.getName()+"  **** " );
	 }
	 
	 public SubmitFormDefinitionAdvanced(Base base) {
			
		 methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 Add_Log.info("\tExecuting SubmitFormDefinitionAdvanced constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		 this.base=base;
		 System.out.println("Driver ="+ base.driver);
	 }
	 
	
	@Given("^User (?:launches|opens|navigates) http://integr(\\d+)a\\.trclient\\.com Page$")
	public void user_launches_http_integr_a_trclient_com_Page(int arg1) throws Throwable {

	    Add_Log.info("^User (?:launches|opens|navigates) http://integr(\\d+)a\\.trclient\\.com Page$");
	    //base.driver.get(param.getProperty("URL"));
	    base.module1=base.login.navigateToModule(param.getProperty("URL"));
	}

	
	@When("^User fills the form with correct data$")
	public void user_fills_the_form_with_data(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		Add_Log.info("^User fills the form with correct data");

		
		Map<String,String> dataTableMap = dataTable.asMap(String.class,String.class);
		
		base.module1.sendKeysToFirstName(dataTableMap.get("FirstName"));
		base.module1.sendKeysToLastName(dataTableMap.get("LastName"));
		base.module1.sendKeysToEmail(dataTableMap.get("Email"));
		base.module1.sendKeysToMobileNo(dataTableMap.get("MobileNo"));
		base.module1.sendKeysToAddress(dataTableMap.get("Address"));
		base.module1.sendKeysToSuburb(dataTableMap.get("Suburb"));
		base.module1.selectState(dataTableMap.get("State"));
		base.module1.sendKeysToPostCode(dataTableMap.get("PostCode"));
		base.module1.sendKeysToDob(dataTableMap.get("Dob"));
		base.module1.clickOnTermsAndCondition(dataTableMap.get("TermsAndCondition"));
		base.module1.clickOnSubmit(dataTableMap.get("Submit"));
		
		
		
	    
	}

	@Then("^I verify the Form not submitted$")
	public void i_verify_the_Form_not_submitted() throws Throwable {
	   
	   Add_Log.info("^I verify the Form not submitted$");
	   base.module1.verifyTestingFormSubmission(); 
	   //module1.verifyTestingFormConfirmation("Negative");
	}

	
	@When("^User submit the form with multiple correct data and verify form$")
	public void user_submit_the_form_with_multiple_incorrect_data(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    
		Add_Log.info("^User submit the form with multiple correct data and verify form$");
		for (Map<String,String> dataTableMap : dataTable.asMaps(String.class, String.class)){
			
			
			//module1=new SuiteModule1Page();
			base.module1.sendKeysToFirstName(dataTableMap.get("FirstName"));
			base.module1.sendKeysToLastName(dataTableMap.get("LastName"));
			base.module1.sendKeysToEmail(dataTableMap.get("Email"));
			base.module1.sendKeysToMobileNo(dataTableMap.get("MobileNo"));
			base.module1.sendKeysToAddress(dataTableMap.get("Address"));
			base.module1.sendKeysToSuburb(dataTableMap.get("Suburb"));
			base.module1.selectState(dataTableMap.get("State"));
			base.module1.sendKeysToPostCode(dataTableMap.get("PostCode"));
			base.module1.sendKeysToDob(dataTableMap.get("Dob"));
			base.module1.clickOnTermsAndCondition(dataTableMap.get("TermsAndCondition"));
			base.module1.clickOnSubmit(dataTableMap.get("Submit"));
			base.module1.verifyTestingFormSubmission(); 
			
			
		}
	}
		
		@When("^User Enters data for Scenario Template FirstName (.*)  LastName (.*) Email  (.*) MobileNo  (.*)   Address  (.*) Suburb  (.*) State  (.*) PostCode  (.*) Dob  (.*) TermsAndCondition (.*) Submitn  (.*) button$")
		public void user_submit_the_form_with_multiple_data_withScenarioTemplate(String FirstName , String LastName, String Email, String MobileNo, String Address, String Suburb,String State,String PostCode,String Dob,String TermsAndCondition,String Submit) throws Throwable {
		
			
			Add_Log.info("^User Enters data for Scenario Template FirstName(.*) ... $");
			//module1=new SuiteModule1Page();
			base.module1.sendKeysToFirstName(FirstName);
			base.module1.sendKeysToLastName(LastName);
			base.module1.sendKeysToEmail(Email);
			base.module1.sendKeysToMobileNo(MobileNo);
			base.module1.sendKeysToAddress(Address);
			base.module1.sendKeysToSuburb(Suburb);
			base.module1.selectState(State);
			base.module1.sendKeysToPostCode(PostCode);
			base.module1.sendKeysToDob(Dob);
			base.module1.clickOnTermsAndCondition(TermsAndCondition.trim());
			base.module1.clickOnSubmit(Submit);
		}
		
	
}
