package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class Register extends BaseClass {
	
	@FindBy (xpath=" //*[@id=\"navbarCollapse\"]/div[2]/ul/a[2] ") WebElement Registerlnk;
	@FindBy (xpath="//*[@id='id_username']") WebElement uname;
	@FindBy (xpath="//*[@id=\"id_password1\"]") WebElement pwd;
	@FindBy (xpath="//*[@id=\"id_password2\"]") WebElement confpwd;
	@FindBy (xpath="//*[@value='Register']") WebElement RegButton;
	@FindBy (xpath="/html/body/div[2]/div/div[2]/a") WebElement Loginlnk;
	@FindBy (linkText=" Sign in ") WebElement Signinlnk;
	@FindBy (xpath="/html/body/div[3]") WebElement Alert;
	@FindBy (xpath="/html/body/div[2]") WebElement Success_Alert;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[2]/ul/a[3]") WebElement Signinlnk1;
	
	@FindBy (xpath="/html/body/div[2]/div/div[2]/form/input[4]") WebElement LoginButton;
	@FindBy (xpath="/html/body/div[2]") WebElement LoginSuccessAlert;
	
	@FindBy (xpath="//*[@id=\"id_password\"]") WebElement Signinpassword;
	@FindBy (xpath="//*[@id=\"id_username\"]") WebElement Signinuname;
	
	
	public Register()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	public void all_empty(String user,String pass,String confpass)
	{

	
	uname.sendKeys(user);
	pwd.sendKeys(pass);
	confpwd.sendKeys(confpass);
	RegButton.click();
	System.out.println("User id:"+user+"Pass:"+pass+"Confirm:"+confpass);



	}

	public String err_username()
	{
		String message=uname.getAttribute("validationMessage");
		return message;
		
	}
	
	
	
	public String err_password()
	{
		String message1=pwd.getAttribute("validationMessage");
		return message1;
		
	}

	
	public String err_confirmpassword()
	{
		String message1=confpwd.getAttribute("validationMessage");
		return message1;
		
	}
	
	
	public String err_Alert() 
	{
		String message1=Alert.getText();
		System.out.println("The Alert message is:"+message1);
		return message1;
	}
	
	
	public String success_mess()
	{
		String message1=Success_Alert.getText();
		System.out.println("The Success Alert message is:"+message1);
		return message1;
		
	}
	
	public SignIn login_click()
	{
		Loginlnk.click();
		return new SignIn();
	}
	public SignIn signin_click()
	{
		Signinlnk1.click();
		return new SignIn();
	}
	
	
	public String login_launch()
	{
		return dr.getTitle();
	}
	public HomePage signin_success(String user3,String pass3)
	{
		
		Signinuname.sendKeys(user3);
		Signinpassword.sendKeys(pass3);
		LoginButton.click();
		System.out.println("User id:"+user3+"Pass:"+pass3);
		return new HomePage();
	}

	public String login_success_mess()
	{
		String message1=LoginSuccessAlert.getText();
		System.out.println("The Success Alert message is:"+message1);
		return message1;
		
	}

}
