package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.BaseClass;

public class DataStructures extends BaseClass{
	
	@FindBy (xpath="/html/body/div[2]/ul/a") WebElement timecomplink;
	@FindBy (xpath="/html/body/div[2]/div/div[2]/a") WebElement Tryhere;
	@FindBy (xpath="//pre[@role='presentation']") WebElement CodeTxtEditor;
	@FindBy (xpath="//*[@id=\"answer_form\"]/button") WebElement runclick;
	@FindBy (xpath="//*[@id=\"output\"]") WebElement runresult;
	
	public DataStructures()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	public String DS_Title()
	{
		//dr.get(HomeUrl);
		return dr.getTitle();
		
	}
	
	public DS_Time time_complex_click()
	{
		timecomplink.click();
		return new DS_Time();
	}
	
	

}
