package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Alert;



import TestBase.BaseClass;

public class Try_Editor extends BaseClass{
	
	@FindBy (xpath="//pre[@role='presentation']") WebElement CodeTxtEditor;
	@FindBy (xpath="//*[@id=\"answer_form\"]/button") WebElement runclick;
	@FindBy (xpath="//*[@id=\"output\"]") WebElement runresult;
	
	public Try_Editor()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	
	public String Try_Editor_Title()
	{
		//dr.get(HomeUrl);
		return dr.getTitle();
		
	}
	
	public void enter_phyton_code(String code)

	{
		Actions act=new Actions(dr);
		//CodeTxtEditor.click();
		act.moveToElement(CodeTxtEditor).doubleClick().click().sendKeys(Keys.BACK_SPACE).build().perform();

		act.sendKeys(CodeTxtEditor,code).build().perform();
		//CodeTxtEditor.sendKeys(code);
	}
	public void run_click()
	{
		try {

		    runclick.click();
		    String result=runresult.getText();
			System.out.println("The run result is:"+result);

		} catch(UnhandledAlertException f) {

		    try {
		Alert alert = dr.switchTo().alert();
		String alertMessage= dr.switchTo().alert().getText();
		 System.out.println(alertMessage);
		 alert.accept();
		    } catch (NoAlertPresentException e) {

		        e.printStackTrace();

		    }
		}
		
	}
//	public void run_result()
//	{
//		String result=runresult.getText();
//		System.out.println("The run result is:"+result);
//		
//		
//		//CodeTxtEditor.clear();
//		
//	}
}
