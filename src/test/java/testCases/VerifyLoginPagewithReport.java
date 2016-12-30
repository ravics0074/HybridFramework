package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPagewithReport 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report =new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger=report.startTest("Verify Test Login");
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		logger.log(LogStatus.INFO, "Application is Up and Running");
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		String title=home.getApplicationTitle();
		Assert.assertTrue(title.contains("More - Amazon.in"));
		logger.log(LogStatus.PASS, "Home Pages Loaded Successfully and verified");
		home.clickOnSignInLink();
		logger.log(LogStatus.INFO, "Click on SignIn Link");
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1) );
		logger.log(LogStatus.INFO, "Login To Application");
		login.verifySignIn();
		logger.log(LogStatus.PASS, "Ravi User is logged in");
	}
	
	@AfterMethod
	void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
