package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class LaunchPage extends BaseClass {
	
	@FindBy (xpath="//*[@class='btn']") WebElement GetStart;
	
	public LaunchPage()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	public String Get_LaunchTitle()
	{
		return dr.getTitle();
	}
	
	public HomePage click_GetStarted()
	{
		GetStart.click();
		return new HomePage();
	}

}
