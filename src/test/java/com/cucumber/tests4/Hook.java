package com.cucumber.tests4;

import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

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
		 this.base=base;
	 }
	@Before({"~@LoadBrowser", "~@CloseBrowser"})
	 public void setup(Scenario sc){
		Add_Log.info("*********** Before : " +sc.getName() + " Started ***********");
		TestCaseName=sc.getName();
		
		if ( base.driver ==null){
		System.out.println("driver ="+ driver);
		//loadBrowser(TestCaseName);
		base.loadBrowser(TestCaseName);
		Add_Log.info("*********** Before : " +sc.getName() + " Ended ***********");	
		}
		
		//base.module1=new SuiteModule1Page(base);
		base.login=new SuiteLoginPage(base);
	}
	@After({"~@LoadBrowser", "~@CloseBrowser"})
	public void tearDown(Scenario sc){
	
		Add_Log.info("*********** After : " +sc.getName() + " started  ***********");
		System.out.println(" Scenario status : " +sc.getStatus());
		System.out.println(" Scenario isFailed : " +sc.isFailed());
		
		try {
	        byte[] screenshot =  ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
	        sc.embed(screenshot, "image/png");
	    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
	        //System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	    	sc.write(somePlatformsDontSupportScreenshots.getMessage());

	    }

		
		closeWebBrowser();
		System.gc();
		Add_Log.info("*********** After : " +sc.getName() + " Ended  ***********");
	}
	
}
