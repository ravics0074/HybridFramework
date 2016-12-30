package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//span[text()='Hello. Sign in']") 
	WebElement signInLink;

	@FindBy(xpath="//span[text()='Try']")
	WebElement tryLink;
	
	@FindBy(xpath="//span[text()='Your']")
	WebElement yourLink;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cartLink;
	
	public void clickOnSignInLink()
	{
		signInLink.click();
	}
	
	public void clickOnTryLink()
	{
		tryLink.click();
	}
	
	public void clickOnYourLink()
	{
		yourLink.click();
	}
	
	public void clickOnCartLink()
	{
		cartLink.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
}
