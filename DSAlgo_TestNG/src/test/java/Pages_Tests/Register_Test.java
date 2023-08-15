package Pages_Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LaunchPage;
import Pages.Register;
import Pages.SignIn;
import TestBase.BaseClass;
import Utilities.Loggerload;
import Utilities.TakeScreenshot;

public class Register_Test extends BaseClass {
	
	HomePage hp;
	LaunchPage lp;
	SignIn Sp;
	Register rp;
	
	public Register_Test()
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
		rp=Sp.register_click();
	}
	
	
	@DataProvider (name = "empty")
	 public String[][] dpMethod(){
	 return new String[][] {{"", "",""}};
	 }
	@Test(priority=1,dataProvider="empty")
	public void all_field_empty(String uname,String pass,String Conf)
	{
		Loggerload.info("*************Register Page*****************");
		rp.all_empty(uname, pass, Conf);
		String mess=rp.err_username();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "pass")
	 public Object[][] dpMethod1(){
	 return new Object[][] {{"Abc", "","Abc"}};
	 }
	
	@Test(priority=2, dataProvider="pass")
	public void pass_empty(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_password();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "confpass")
	 public Object[][] dpMethod3(){
	 return new Object[][] {{"Abc", "Abc",""}};
	 }
	
	@Test(priority=3, dataProvider="confpass")
	public void confpass_empty(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_confirmpassword();
		System.out.println(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "unameChar")
	 public Object[][] dpMethod4(){
	 return new Object[][] {{"&**&**&", "Abc","Abc"}};
	 }
	
	@Test(priority=4, dataProvider="unameChar")
	public void uname_char(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_Alert();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "unameexist")
	 public Object[][] dpMethod5(){
	 return new Object[][] {{"AnushaG", "Abc","Abc"}};
	 }
	
	@Test(priority=5, dataProvider="unameexist")
	public void uname_exist(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_Alert();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "passmismatch")
	 public Object[][] dpMethod6(){
	 return new Object[][] {{"AnushaG12", "Virat12","Virat21"}};
	 }
	
	@Test(priority=6, dataProvider="passmismatch")
	public void pass_mismatch(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_Alert();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "passnumbers")
	 public Object[][] dpMethod7(){
	 return new Object[][] {{"AnushaG12", "123456789","123456789"}};
	 }
	
	@Test(priority=7, dataProvider="passnumbers")
	public void pass_numbers(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_Alert();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "passunamesame")
	 public Object[][] dpMethod8(){
	 return new Object[][] {{"AnushaG12", "AnushaG1","AnushaG1"}};
	 }
	
	@Test(priority=8, dataProvider="passunamesame")
	public void pass_unamesame(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_Alert();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "passcommon")
	 public Object[][] dpMethod9(){
	 return new Object[][] {{"AnushaG12", "Welcome1","Welcome1"}};
	 }
	
	@Test(priority=9, dataProvider="passcommon")
	public void pass_common(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.err_Alert();
		//System.out.println(mess);
		Loggerload.error(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider (name = "valid")
	 public Object[][] dpMethod10(){
	 return new Object[][] {{"AnushaG123456", "Arthi199457","Arthi199457"}};
	 }
	
	@Test(priority=10, dataProvider="valid")
	public void valid_entry(String user,String pass,String confpass)
	{
		rp.all_empty(user, pass, confpass);
		String mess=rp.success_mess();
		//System.out.println(mess);
		Loggerload.info(mess);
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=11)
	public void loginlnk_click()
	{
		Sp=rp.login_click();
		String Expected_title="Login";
		String Actual_title=rp.login_launch();
		//System.out.println("The title is:"+Actual_title);
		Loggerload.info(Actual_title);
		Assert.assertEquals(Actual_title, Expected_title);
	}
	
	@DataProvider (name = "validlogin")
	 public Object[][] dpMethod11(){
	 return new Object[][] {{"AnushaG1234", "Arthi199457"}};
	 }
	
	@Test(priority=12, dataProvider="validlogin")
	public void valid_login(String user,String pass)
	{
		Sp=rp.login_click();
		hp=rp.signin_success(user, pass);
		String mess=rp.login_success_mess();
		//System.out.println(mess);
		Loggerload.info(mess);
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
