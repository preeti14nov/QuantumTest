package QuantumTest.Generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import QuantumTest.Pageobject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseLib {
	public WebDriver driver;
	String browsername = GetPropertyValues.getPropertyValue("browser");
	protected HomePage homePage;
	public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter reporter;
    public ExtentTest test;


	@BeforeMethod(alwaysRun = false, groups = { "Regression" })
	@Parameters({ "browser" })
	public void preConditionWeb(String browsername) {
		final Logger logger = LogManager.getLogger(BaseLib.class);
		logger.trace("entering into application");
		
		

		if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			   FirefoxOptions options = new FirefoxOptions();
			  options.addPreference("dom.webnotifications.enabled", false);
			  options.addPreference("geo.enabled", false); 
			  options.addArguments("--headless");
			  driver = new FirefoxDriver(options);
			Reporter.log("Firefox Browser launches");
		} else if (browsername.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-geolocation");
			options.addArguments("--disable-notifications");
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			Reporter.log("Chrome Browser launches");
		} 
		else if (browsername.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
			 EdgeOptions options = new EdgeOptions();
			options.addArguments("headless");
			driver = new EdgeDriver(options);
			Reporter.log("Edge Browser launches");
		} 
		driver.manage().window().maximize();
		driver.get(GetPropertyValues.getPropertyValue("URL"));
		Reporter.log("Navigate to the URL", true);
		

		homePage = PageFactory.initElements(driver, HomePage.class);
	}
	

	@BeforeSuite(alwaysRun = true)

	public void deleteOutputDirectory() {

		String filepath = ".\\test-output";
		try {
			FileUtils.deleteDirectory(new File(filepath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		String path = ".\\reports\\index.html";

        reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Quantum Automation Report");
        reporter.config().setReportName("Test Report");
        reporter.config().setTimeStampFormat("MM-dd-yyyy, hh:mm:ss");
        reporter.config().setTheme(Theme.STANDARD);


	}
	@AfterSuite (alwaysRun =true)
	public void flushReport() {
		extent.attachReporter(reporter);
        extent.flush();
	}

	@AfterMethod(alwaysRun = false, groups = { "Regression" })
	public void postCondition(ITestResult result) {
		if (result.isSuccess()) {
			Reporter.log("Script passed", true);
			test.log(Status.PASS, result.getTestName());
		
		} else {
			test.log(Status.FAIL, result.getThrowable());
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase().toString();
			String filename = result.getMethod().getMethodName();
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
			Date date = new Date();
			String browserFolder = ".\\Screenshot\\" + browserName + "\\" + formatter.format(date);
			File file1 = new File(browserFolder);
			if (!file1.exists()) {
				file1.mkdir();
			}
			ScreenShotLib sLib = new ScreenShotLib();
			sLib.getScreenShot(driver, filename, browserName, browserFolder);
			Reporter.log(filename + " has beeen failed and Screenshot has been taken", true);
		}
		driver.quit();
		Reporter.log("Browser closed", true);
	}

}
