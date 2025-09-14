package com.cucumber.tests;

import org.junit.BeforeClass;

import com.cucumber.pages.SuiteLoginPage;
import com.cucumber.pages.SuiteModule1Page;
import com.cucumber.utils.Base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends Base{
	String methodName;
	private Base base;
	static {
		 Add_Log.info("\tExecuting - Static block -"+ Hook.class.getName());
		 
		
	 }
	 public Hook(Base base){
		 methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 Add_Log.info("\tExecuting Hook constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		 //this.base=base;
	 }
	
	 @Before(value={"@LoadBrowser"}, order=0)
	 //@Before(order=0)
	 public void setup(Scenario sc){
		
		if (driver == null)
		loadBrowser("SubmitFormDefinition");

		login=new SuiteLoginPage(base);
	
	
			
	}
	@Before(order=1)
	public void setup1(Scenario sc){
		Add_Log.info("*********** Before : " +sc.getName() + " Started ***********");	
		TestCaseName=sc.getName();
		System.out.println("Driver ="+base.driver);
	
		Add_Log.info("*********** Before : " +sc.getName() + " Ended ***********");	
	}
	
	@After(value={"@CloseBrowser"}, order=0)
	public void tearDown(Scenario sc){
		
		Add_Log.info("*********** After : " +sc.getName() + " Started  ***********");
		
		closeWebBrowser();
		Add_Log.info("*********** After : " +sc.getName() + " Ended  ***********");
	}
	
	
}
