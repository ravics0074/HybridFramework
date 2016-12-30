package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath=".//*[@id='ap_email']")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signIn_Button;

	By verifyRavi=By.xpath("//span[text()='Hello, RAVI']");
	
	public void loginApplication(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		signIn_Button.click();
	}
	
	public void verifySignIn()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(verifyRavi));
		String text=ele.getText();
		Assert.assertEquals(text, "Hello, RAVI","User Ravi is not Verified");
	}
	
}
