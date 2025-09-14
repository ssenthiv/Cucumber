/* This is Page class for Testing Form */

package com.cucumber.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import com.cucumber.utils.Base;

public class SuiteLoginPage {
	String methodName;
	private Base base;
	
	static {
		 Base.Add_Log.info("\tExecuting - Static block -"+ SuiteLoginPage.class.getName());

	 }
	
	public SuiteLoginPage(Base base){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		base.Add_Log.info("\tExecuting SuiteLoginPage constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		this.base=base;
		PageFactory.initElements(base.driver, this);
		
	}
	
	//Object repositories
	/*
	@FindBy(id="firstname")
	WebElement TestingForm_FirstName;
	*/
		
	
	
	public void submitLoginPage(){	
		base.Add_Log.info(base.TestCaseName + ":- Submitted Login Page ");
		
				
	}
	public SuiteModule1Page navigateToModule(String url){
		
		base.driver.get(url);
		//driver.get(url);
		base.Add_Log.info(base.TestCaseName + ":- navigated to url : "+ url);
		return new SuiteModule1Page(base);		
	}
	
	
	
	
	
	

}
