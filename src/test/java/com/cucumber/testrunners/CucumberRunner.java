package com.cucumber.testrunners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions( 
		//plugin = {"pretty", "html:target/cucumber-reports"},
		plugin = { "pretty", "html:target/cucumber-reports","com.cucumber.listener.ExtentCucumberFormatter:target/extent-reports/report.html"},
		// format = {"json:target/cucumber.json","html:target/cucumber-reports-pretty"},
		//features = {"Features1","Features2","Features3"}, 
		features = {"Features2"}, 
		//glue = {"com.cucumber.tests", "com.cucumber.tests2" },
		//glue = {"com.cucumber.tests"},
		glue = {"com.cucumber.tests3"},
		//glue = {"com.cucumber.tests4"},
		dryRun =false,
		monochrome=true,
		strict=true,
	//	tags=""
	//	tags = "@LoginTest"
	//	tags = {"@LoginTest1 , @LoginTest2"}
	//	tags = "~@ValidFormTest"
	//	tags = {"@LoadBrowser,@CloseBrowser,@LoginTest1,@ValidFormTest2, @InValidFormTest1"}
	//	tags = {"@ValidFormTest1, @ValidFormTest2"}
	//	tags = {"@InValidFormTest1, @ValidFormTest1, @LoginTest2,@LoadBrowser,@CloseBrowser"  }
	    tags = {"@ValidFormTest1"}
	//	tags = {"@ValidFormTest1,@ValidFormTest2,@ValidFormTest3"}
	//	tags = "@LoginTest1"

		
		)

public class CucumberRunner {
	//@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    
    }
    

//public class CucumberRunner extends AbstractTestNGCucumberTests{

}
