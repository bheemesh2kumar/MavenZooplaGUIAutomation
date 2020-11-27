package com.zoopla.regressiontests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zoopla.pagerepository.UKNewHomesforSalepage;
import com.zoopla.pagerepository.UKPropertiesforsalepage;
import com.zoopla.pagerepository.ZooplaCommercialpageOR;
import com.zoopla.pagerepository.ZooplaLoginpage;
import com.zoopla.pagerepository.Zooplahomepage;
import com.zoopla.pagerepository.ZooplahowmuchismyhomeworthpageOR;
import com.zoopla.utilities.Browserutility;
import com.zoopla.utilities.Commanutilities;
import com.zoopla.utilities.ReadPropertyfile;

public class BaseTest extends Browserutility {
	public WebDriver driver;
	public ReadPropertyfile ReadPropertyfileref;
	public ZooplaLoginpage ZooplaLoginpageref;
	public Zooplahomepage Zooplahomepageref;
	public Logger logger;
	UKPropertiesforsalepage UKPropertiesforsalepageref;

	public ExtentHtmlReporter ExtentHtmlReporterref;
	public ExtentReports ExtentReportsref;
	public ExtentTest ExtentTestref;
	public UKNewHomesforSalepage UKNewHomesforSalepageref;
	public Commanutilities Commanutilitiesref;
	public ZooplaCommercialpageOR ZooplaCommercialpageORref;
	ZooplahowmuchismyhomeworthpageOR ZooplahowmuchismyhomeworthpageORref;

	@BeforeTest
	public void setExtent() {
		ExtentHtmlReporterref = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\myreport.html");
		ExtentHtmlReporterref.config().setDocumentTitle("Auotmationreport");
		ExtentHtmlReporterref.config().setReportName("Funtional report");
		ExtentHtmlReporterref.config().setTheme(Theme.DARK);

		ExtentReportsref = new ExtentReports();
		ExtentReportsref.attachReporter(ExtentHtmlReporterref);

		ExtentReportsref.setSystemInfo("Hostname", "Localhost");
		ExtentReportsref.setSystemInfo("OS", "windows");
		ExtentReportsref.setSystemInfo("Tester", "Bheeemsh");
		ExtentReportsref.setSystemInfo("Environment", "SIT");

	}

	@AfterTest
	public void endreport() {
		ExtentReportsref.flush();
	}

	@BeforeMethod
	public void setup() throws FileNotFoundException {

		ReadPropertyfileref = new ReadPropertyfile();
		driver = initializebrowser(ReadPropertyfileref.getbrowser());
		ZooplaLoginpageref = new ZooplaLoginpage(driver);
		Zooplahomepageref = new Zooplahomepage(driver);
		UKPropertiesforsalepageref = new UKPropertiesforsalepage(driver);
		UKNewHomesforSalepageref = new UKNewHomesforSalepage(driver);

		logger = Logger.getLogger("Zooplaproject");
		PropertyConfigurator.configure("Log4j.properties");

		ZooplaLoginpageref.Acceptallcookiesbutton.click();

		ZooplaLoginpageref.logintozoopla(ZooplaLoginpageref.Signfirstbutton, ZooplaLoginpageref.loginusernameinputbox,
				ReadPropertyfileref.getusername(), ZooplaLoginpageref.loginpwdinputbox, ReadPropertyfileref.getpwd(),
				ZooplaLoginpageref.Signsecondbutton);

		Commanutilitiesref = new Commanutilities();

		ZooplaCommercialpageORref = new ZooplaCommercialpageOR(driver);

		ZooplahowmuchismyhomeworthpageORref = new ZooplahowmuchismyhomeworthpageOR(driver);

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException

	{

		/*
		 * if (result.getStatus() == ITestResult.FAILURE) {
		 * ExtentTestref.log(Status.FAIL, "Testcase failed is" + result.getName());
		 * ExtentTestref.log(Status.FAIL, "Testcase failed is" + result.getThrowable());
		 * String screenshotpath = Commanutilitiesref.takescreenshot(driver,
		 * result.getName()); ExtentTestref.addScreenCaptureFromPath(screenshotpath);
		 * 
		 * }
		 * 
		 * else if (result.getStatus() == ITestResult.SKIP) {
		 * ExtentTestref.log(Status.SKIP, "Testcase skipped is" + result.getName()); }
		 * 
		 * else if (result.getStatus() == ITestResult.SUCCESS) {
		 * 
		 * ExtentTestref.log(Status.PASS, "Testcase passed is" + result.getName()); }
		 */

		driver.quit();

	}

}
