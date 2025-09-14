package com.cucumber.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.SkipException;
//import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.SkipException;

import com.cucumber.pages.SuiteModule1Page;
import com.cucumber.pages.SuiteLoginPage;

import junit.framework.Assert;



public class Base {
	private String methodName;
	// Read_XLS globalModulesExcel;
	// Read_XLS moudle1Excel;
	 String[] TestDataToRun;
	 int dataSet=-1;
	 static boolean testFail=false;
	 boolean testSkip=false;
	 boolean testCaseStatus=true;
	 //static SoftAssert softAssert;
	 @SuppressWarnings("deprecation")
	 static Assert softAssert;
	 //public static WebDriver driver;
	 public  WebDriver driver;
	 public static Logger Add_Log=null;
	 //public  Logger Add_Log=null;
	 public static String TestCaseName;
	 public static Properties param;
	 //public  Properties param;
	 public static SuiteModule1Page module1;
	 //public  SuiteModule1Page module1;
	 public static SuiteLoginPage login;
	 //public  SuiteLoginPage login;
	 static {
		 System.out.println("\tExecuting - Static block -"+ Base.class.getName());
		init();
		//loadBrowser(TestCaseName);
		
	 }
	 public Base(){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		//System.out.println("\tExecuting Base constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		Add_Log.info("\tExecuting Base constructor- "+ this.getClass().getSimpleName()+"."+methodName);
	 }
	public static void init(){
		//methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		//System.out.println("\tExecuting - "+ this.getClass().getSuperclass().getSimpleName()+"."+methodName);
		System.out.println("\tExecuting - "+ Base.class.getName()+".init()");
		Date date=Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		
		System.setProperty("logfile.name",
				System.getProperty("user.dir") + "\\resources\\Logging\\applog_" + sdf.format(date));
		PropertyConfigurator.configure("src\\test\\java\\com\\cucumber\\config\\log4j.properties");
		
		Add_Log = Logger.getLogger("rootLogger");
		
		param=new Properties();
		FileInputStream fis;
		try {
			 fis=new FileInputStream(System.getProperty("user.dir")+ 
					"\\src\\test\\java\\com\\cucumber\\config\\Param.properties");
			param.load(fis);
			fis.close();
		} catch (FileNotFoundException  e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		//System.out.println("Browser : "+ param.getProperty("testBrowser"));
		//globalModulesExcel=new Read_XLS(
			//	System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\Global.xls");
	}
	
	void initModule1ReadXLS(){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Add_Log.info("\tExecuting - "+ this.getClass().getSuperclass().getSuperclass().getSimpleName()+"."+methodName);
		//moudle1Excel=new Read_XLS(
				//System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\Module1.xls");

	}
	
	//public static void loadBrowser(String TestCase){
	public  void loadBrowser(String TestCase){
	//	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	//	Add_Log.info("\tExecuting - "+ this.getClass().getSuperclass().getSimpleName()+"."+methodName);
		/*
		if (!moudle1Excel.retrieveToRunFlag("TestCasesList", "CaseToRun", TestCase).equalsIgnoreCase("y")){
			
			System.out.println("ToRun for" + TestCase +" = N ");
			moudle1Excel.writeResult("TestCasesList", "Pass/Fail/Skip", TestCase , "Skipped");
			throw new SkipException(
					TestCase + "'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of " + "Method1");
		}
		*/
		//TestDataToRun=moudle1Excel.retrieveToRunFlagTestData(TestCase, "DataToRun");
		System.out.println("\tExecuting - " +TestCase +"-> "+ Base.class.getName()+".loadBrowser()");
		String browser= param.getProperty("testBrowser");
		switch(browser) {
		
		case "Chrome" : 
	
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			options.addArguments("chrome.switches", "--disable-extensions");
			// options.addArguments("--headless");
			new DesiredCapabilities();
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(caps);
			// driver=new ChromeDriver();
			
			break;
			
		case "IE" :
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//BrowserDrivers//IEDriverServer.exe");
			/*
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, param.getProperty("URL"));
			DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
			cap.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setJavascriptEnabled(true);
			cap.setCapability("requireWindowFocus", true);
			cap.setCapability("enablePersistentHover", false);
			driver = new InternetExplorerDriver(cap);
			*/
			driver =new InternetExplorerDriver();
			break;
		case "Mozilla" :
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//BrowserDrivers//geckodriver.exe");

			driver = new FirefoxDriver();
			break;
		default :
			Add_Log.error("No such Browser " + browser);
			//reportFailures("No such Browser " + browser);
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
	}
	
	public void reportFailures(String msg) {
		testFail = true;
		Add_Log.info(this.getClass().getSimpleName() + ":- " + msg);
		//System.out.println(msg);
		softAssert.fail("\n" + msg);
	}
	/*
	public void testClosure(String testCase) {
		try {
			//Add_Log.info("******************************** End of Execution for :- " + TestCaseName
				//	+ " *************************************");

			if (testCaseStatus) {
				moudle1Excel.writeResult("TestCasesList", "Pass/Fail/Skip", testCase, "PASS");
				
			} else {
				moudle1Excel.writeResult("TestCasesList", "Pass/Fail/Skip", testCase, "FAIL");
			}
		} catch (Exception e) {
			System.out.println("Do Nothing");
		} finally {
			// Reset all flags and counters to default value.
			dataSet = -1;
			softAssert = null;
			testCaseStatus = true;
			//step_Number = 1;
			testFail = false;

			// To Close the web browser at the end of test.
			System.out.println("/tClosing Browser");;
		}
	}
	*/
		// Call this function to close the browser
		public void closeWebBrowser() {
			methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
			Add_Log.info("\tExecuting - "+ this.getClass().getSuperclass().getSimpleName()+"."+methodName);
			try {
				try {
					driver.close();
				} catch (Exception e) {
					Add_Log.info("Exception in Close browser code. ");
					Add_Log.info("Details of failure are:- " + e.getLocalizedMessage());
				} finally {
					//browserLoaded = false;
					driver=null;
				}

				// To kill the browser processes
				try {
					// To close the browser instance.
					if (param.getProperty("testBrowser").equals("Chrome")) {
						Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
					} else if (param.getProperty("testBrowser").equals("IE")) {
						Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
					} else if (param.getProperty("testBrowser").equals("Mozilla")) {
						Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
					}
					Thread.sleep(5000);
				} catch (Throwable e) {
					Add_Log.info("Exception in Kill browser code. ");
					Add_Log.info("Details of failure are:- " + e.getLocalizedMessage());
				}

			} catch (Throwable e) {
				Add_Log.info("Exception in closeWebBrowser function ");
				Add_Log.info("Details of failure are:- " + e.getLocalizedMessage());
			} finally {
				// null browser Instance when close.
				//ExistingchromeBrowser = null;
				//ExistingmozillaBrowser = null;
				//ExistingIEBrowser = null;
				driver=null;
			}
		}
}
