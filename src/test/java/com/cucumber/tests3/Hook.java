package com.cucumber.tests3;

import org.junit.BeforeClass;

import com.cucumber.pages.SuiteLoginPage;
import com.cucumber.pages.SuiteModule1Page;

import com.cucumber.utils.Base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	String methodName;
	Base base;
	static {
		 Base.Add_Log.info("\tExecuting - Static block -"+ Hook.class.getName());
		 
		
	 }
	 public Hook(Base base){
		 methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 base.Add_Log.info("\tExecuting Hook constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		 this.base=base;
	 }
	
	 
	 //@Before(value="@LoadBrowser", order=0)
	 @Before(order=0)
	 public void setup(Scenario sc){
		
		
		if ( base.driver ==null){
		System.out.println("driver ="+ base.driver);
		base.loadBrowser(base.TestCaseName);
		
		}
		
		//module1=new SuiteModule1Page(base);
		base.login=new SuiteLoginPage(base);
			
	}
	 @Before(order=1)
	 public void setup1(Scenario sc){
			base.Add_Log.info("*********** Before : " +sc.getName() + " Started ***********");
			base.TestCaseName=sc.getName();
		
			base.Add_Log.info("*********** Before : " +sc.getName() + " Ended ***********");	
		}
	 
	//@After(value="@CloseBrowser", order=10)
	 @After(order=10)
	 public void tearDown(Scenario sc){
		 base.Add_Log.info("*********** After : " +sc.getName() + " Started ***********");	
		 base.closeWebBrowser();
		 base.Add_Log.info("*********** After : " +sc.getName() + " Ended ***********");	
	}
	
	
}
