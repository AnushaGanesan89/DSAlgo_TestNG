package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class SignIn extends BaseClass {
	
	@FindBy (xpath=" //*[contains (text(), 'Register!')]") WebElement Register;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[2]/ul/a[3]") WebElement Signinlnk;
	@FindBy (xpath="//*[@id=\"id_username\"]") WebElement Uname;
	@FindBy (xpath="//*[@id=\"id_password\"]") WebElement Pass;
	@FindBy (xpath="/html/body/div[2]/div/div[2]/form/input[4]") WebElement loginbutton;
	@FindBy (xpath="/html/body/div[3]") WebElement errormess;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[2]/ul/a[3]") WebElement signout;
	@FindBy (xpath="/html/body/div[2]") WebElement signoutmess;
	
	
	
	
	
	public SignIn()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	
	public Register register_click()
	{
		Register.click();
		return new Register();
	}
	
	public String launch_register()
	{
	return dr.getTitle();	
	}
	
	public SignIn signin_click()
	{
		Signinlnk.click();
		return new SignIn();
	}
	
	public String signin_title()
	{
		return dr.getTitle();
		
	}
	
	public void invalid_sign_in(String user1,String pass1)
	{
		Uname.sendKeys(user1);
		Pass.sendKeys(pass1);
		loginbutton.click();
		String mess=errormess.getText();
		System.out.println("The error:"+mess);
	}
	
	public HomePage signin_common(String user2,String pass2)
	{
		Uname.sendKeys(user2);
		Pass.sendKeys(pass2);
		loginbutton.click();
		return new HomePage();
	}
	
	public String validate_password()
	{
		String message1=Pass.getAttribute("validationMessage");
		return message1;
		
	}
	public String validate_username()
	{
		String message2=Uname.getAttribute("validationMessage");
		return message2;
	}
	
	
	
	

}
