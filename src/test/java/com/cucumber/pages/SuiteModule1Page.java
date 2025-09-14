/* This is Page class for Testing Form */

package com.cucumber.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


//import org.testng.SkipException;
//import org.testng.annotations.BeforeSuite;
//import com.company1.TestSuiteBase.SuiteBase;
//import com.company1.utility.Read_XLS;
//import com.company1.utility.SuiteUtility;
import com.cucumber.utils.Base;

public class SuiteModule1Page  {
	String methodName;
	private Base base;
	
	static {
		 Base.Add_Log.info("\tExecuting - Static block -"+ SuiteModule1Page.class.getName());

	 }
	
	//public SuiteModule1Page(){
	public SuiteModule1Page(Base base){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		base.Add_Log.info("\tExecuting SuiteModule1Page constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		this.base=base;
		PageFactory.initElements(base.driver, this);
		//driver=ldriver;
	}
	
	//Object repositories
	@FindBy(id="firstname")
	WebElement TestingForm_FirstName;
	
	@FindBy(id="lastname")
	WebElement TestingForm_LastName;

	
	/*@FindBy(id="state")
	WebElement TestingForm_State;
*/

	
	@FindBy(id="postcode")
	WebElement TestingForm_PostCode;

	@FindBy(id="dob")
	WebElement TestingForm_Dob;

	@FindBy(id="terms-1")
	WebElement TestingForm_TermsAndCondition;

	
	@FindBy(id="subm")
	WebElement TestingForm_SubmitButton;

	@FindBy(id="mobile")
	WebElement TestingForm_MobileNo;

	
	// By Name
	
	@FindBy(name="customer.STATE_1")
	WebElement TestingForm_State;
	@FindBy(name="customer.ADDRESS1")
	WebElement TestingForm_Address;
	
	@FindBy(name="customer.SUBURBTOWN")
	WebElement TestingForm_Suburb;
	
	// By xpath
	
	@FindBy(xpath=".//*[@id='main-form-area']/div[3]/div/input")
	WebElement TestingForm_Email;

	@FindBy(xpath=".//*[@id='the-form']/div[2]/div[1]/div/h2")
	WebElement TestingForm_ThankU;

	
	
	public void sendKeysToFirstName(String element){
		
		//waitUntilElementToBeClickable(TestingForm_FirstName, 10);
		TestingForm_FirstName.clear();
		TestingForm_FirstName.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'FirstName' : "+ element);
	}
	
	public void sendKeysToLastName(String element){
		
			//waitUntilElementToBeClickable(TestingForm_LastName, 10);
			TestingForm_LastName.clear();
			TestingForm_LastName.sendKeys(element);
			base.Add_Log.info(base.TestCaseName + ":- Entered  'LastName' : "+ element);
		}
	
	public void sendKeysToEmail(String element){
		
		//waitUntilElementToBeClickable(TestingForm_Email, 10);
		TestingForm_Email.clear();
		TestingForm_Email.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'Email' : "+ element);
	}
	
	public void sendKeysToMobileNo(String element){
		
		//waitUntilElementToBeClickable(TestingForm_MobileNo, 10);
		TestingForm_MobileNo.clear();
		TestingForm_MobileNo.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'MobileNo' : "+ element);
	}
	
	
	public void sendKeysToAddress(String element){
		
		//waitUntilElementToBeClickable(TestingForm_Address, 10);
		TestingForm_Address.clear();
		TestingForm_Address.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'Address' : "+ element);
	}
	
	
	public void sendKeysToSuburb(String element){
		
		//waitUntilElementToBeClickable(TestingForm_Suburb, 10);
		TestingForm_Suburb.clear();
		TestingForm_Suburb.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'Suburb' : "+ element);
	}
	
	
	
	
	public void selectState(String element){
	//waitUntilElementToBeClickable(TestingForm_State, 10);
	Select selectState = new Select(TestingForm_State);
	selectState.selectByVisibleText(element);

	base.Add_Log.info(base.TestCaseName + ":- Entered  'State' : "+ element);
	}
	
	public void sendKeysToPostCode(String element){
		
		//waitUntilElementToBeClickable(TestingForm_PostCode, 10);
		TestingForm_PostCode.clear();
		TestingForm_PostCode.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'Post Code' : "+ element);

	}
	
	public void sendKeysToDob(String element){
		
		//waitUntilElementToBeClickable(TestingForm_Dob, 10);
		TestingForm_Dob.clear();
		TestingForm_Dob.sendKeys(element);
		base.Add_Log.info(base.TestCaseName + ":- Entered  'Date of Birth' : "+ element);

	}
	
	public void clickOnTermsAndCondition(String element){
	//waitUntilElementToBeClickable(TestingForm_TermsAndCondition, 10);
	System.out.println(" Is Terms & Condition = " + TestingForm_TermsAndCondition.isSelected());
	if ((element.equals("Y")) && (!TestingForm_TermsAndCondition.isSelected())) {

		TestingForm_TermsAndCondition.click();

		base.Add_Log.info(base.TestCaseName + ":- Clicked on  'Terms and Condition' : "+ element);
	}
	}
	
	
	public void clickOnSubmit(String element){
	if (element.equals("Y")) {
		//waitUntilElementToBeClickable(TestingForm_SubmitButton, 10);
		TestingForm_SubmitButton.click();
		base.Add_Log.info(base.TestCaseName + ":- Clicked on  'Submit Button' : "+ element);
	}
	}
	

	public void verifyTestingFormSubmission() throws InterruptedException {
		try {
			// Wait for Submit Button
			if (!TestingForm_SubmitButton.isDisplayed()){
				base.reportFailures("SubmtForm" + ":- Testing Form is unexpectedly submitted");
			}
			
			base.Add_Log.info(base.TestCaseName + ":- Testing Form is not submitted as it is negative scenario  ");

		} catch (Exception e) {

			// This function is to file captured failures in the reports.
			base.reportFailures("SubmtForm" + ":- Testing Form is unexpectedly submitted");

		}
		base.Add_Log.info(base.TestCaseName + ":- Verified Testing Form Status  ");
	}
	

	/**
	 * 
	 * @param ExpectedResult
	 *            : Expected Text to verify @ Description : This is to verify
	 * whether intended message displayed or not after an action.
	 */
	
	public void verifyTestingFormConfirmation(String ExpectedResult) throws InterruptedException {
		try {
			// Wait for Confirmation Message display.
			//waitUntilElementToBeVisible(TestingForm_ThankU, 5);

			// Check for Thank You Message

			String actualMsg = TestingForm_ThankU.getText();
			if (actualMsg.equalsIgnoreCase(ExpectedResult)) {
				base.Add_Log.info(base.TestCaseName + ":- Testing Form confirmation  actual: '" + actualMsg
						+ "' matched with expected '" + ExpectedResult + "'");

			} else {
				// This function is to file captured failures in the reports.
				base.reportFailures("SubmtForm" + ":- Testing Form confirmation Message actual: '" + actualMsg
						+ "' is not matched with expected '" + ExpectedResult + "'");
			}

		} catch (Exception e) {
			base.Add_Log.info(base.TestCaseName + ":- Excpetion thrown during Verification of Testing Form confirmation Message");
		}
		finally{

			base.Add_Log.info(base.TestCaseName + ":- Verified Text  'TestingForm_ThankU'");

		}
	}

	

	
	
	
	/*
	
	//@BeforeSuite
	public void checkSuiteToRun() throws IOException {
		// Called init() function from SuiteBase class to Initialize .xls Files
		init();
		initPageTestingForm();
		
		
		// To set TestSuiteList.xls file's path In FilePath Variable.
		FilePath = TestSuiteListExcel;
		SheetName = "SuitesList";
		SuiteName = "SuiteTestingForm";
		ToRunColumnName = "SuiteToRun";

		// If SuiteToRun !== "y" then SuiteTwo will be skipped from execution.
		if (!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName)) {
			// To report SuiteTwo as 'Skipped' In SuitesList sheet of
			// TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Skipped");
			// It will throw SkipException to skip test suite's execution and
			// suite will be marked as skipped In testng report.
			throw new SkipException(
					SuiteName + "'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of " + SuiteName);
		}
		// To report SuiteTwo as 'Executed' In SuitesList sheet of
		// TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Executed");
	}
	
	*/
	

}
