package Pages_Tests;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ExcelData.ExcelReader;
import Pages.HomePage;
import Pages.LaunchPage;
import Pages.Register;
import Pages.SignIn;
import TestBase.BaseClass;
import Utilities.TakeScreenshot;

public class SignIn_Test extends BaseClass {
	
	HomePage hp;
	LaunchPage lp;
	SignIn Sp;
	Register rp;
	
	public SignIn_Test()
	{
		super();
	}
	@BeforeMethod()
	public void setup()
	{
		intialization();
		hp=new HomePage();
		lp=new LaunchPage();
		Sp=new SignIn();
		rp=new Register();
		hp=lp.click_GetStarted();
		Sp=hp.signin_click();
		
	}

	@Test(priority=1)
	public void register_sigin_launch()
	{
		rp=Sp.register_click();
		String Expected_title="Registration";
		String Actual_title=Sp.launch_register();
		System.out.println("The title is:"+Actual_title);
		Assert.assertEquals(Actual_title, Expected_title);
		Sp=rp.signin_click();
		String Expected_title1="Login";
		String Actual_title1=Sp.launch_register();
		System.out.println("The title is:"+Actual_title1);
		Assert.assertEquals(Actual_title1, Expected_title1);
	}
	
	@DataProvider (name = "empty")
	 public String[][] dpMethod(){
	 return new String[][] {{"", ""}};
	 }
	@Test(priority=2,dataProvider="empty")
	public void all_field_empty(String uname,String pass)
	{
		Sp.signin_common(uname, pass);
		String mess=Sp.validate_username();
		System.out.println(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "passempty")
	 public String[][] dpMethod1(){
	 return new String[][] {{"AnushaG", ""}};
	 }
	@Test(priority=3,dataProvider="passempty")
	public void pass_field_empty(String uname,String pass)
	{
		Sp.signin_common(uname, pass);
		String mess=Sp.validate_password();
		System.out.println(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "invalid")
	 public String[][] dpMethod2(){
	 return new String[][] {{"Abc1234", "Abc1234"}};
	 }
	@Test(priority=4,dataProvider="invalid")
	public void invalid_entry(String uname,String pass)
	{
		Sp.invalid_sign_in(uname, pass);
		
	}
	
	@DataProvider (name = "validexcel")
	 public Object[][] getTestData() throws InvalidFormatException
	 {
		Object data[][]=ExcelReader.getTestData("Login");
		return data;
		
	 }
	
	@Test(priority=5,dataProvider="validexcel")
	public void valid_Excel(String uname,String pass)
	{
		hp=Sp.signin_common(uname, pass);
		String mess=rp.login_success_mess();
		System.out.println(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
}
