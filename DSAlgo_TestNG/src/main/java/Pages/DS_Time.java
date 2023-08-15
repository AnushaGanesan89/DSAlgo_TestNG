package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class DS_Time extends BaseClass {

	
	@FindBy (xpath="/html/body/div[2]/div/div[2]/a") WebElement Tryhere;
	
	public DS_Time()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	
	public String DS_Time_Title()
	{
		//dr.get(HomeUrl);
		return dr.getTitle();
		
	}
	
	public Try_Editor tryhere_click()
	{
		Tryhere.click();
		return new Try_Editor();
		
	}
	
	
	
}
