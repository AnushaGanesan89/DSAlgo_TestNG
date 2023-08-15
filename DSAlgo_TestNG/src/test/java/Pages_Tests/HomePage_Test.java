package Pages_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LaunchPage;
import Pages.SignIn;
import TestBase.BaseClass;
import Utilities.Loggerload;

public class HomePage_Test extends BaseClass {
	
	HomePage hp;
	LaunchPage lp;
	SignIn Sp;
	
	public HomePage_Test()
	{
		super();
	}
	@BeforeMethod()
	public void setup()
	{
		intialization();
		hp=new HomePage();
		lp=new LaunchPage();
		hp=lp.click_GetStarted();
	}
	@Test(priority=1)
	public void home_title()
	{
		Loggerload.info("**************Home Page****************");
		String Expected_title="NumpyNinja";
		String Actual_title=hp.Homepage_Title();
		//System.out.println("The title is:"+Actual_title);
		Loggerload.info(Actual_title);

		Assert.assertEquals(Actual_title, Expected_title);
	}
	
	@DataProvider (name = "opt1")
	 public Object[][] dpMethod1(){
	 return new Object[][] {{"Datastructures"},{"Arrays"}, {"Linkedlist"},{"Stack"},{"Queue"},{"Tree"},{"Graph"}};
	 }
	@Test(priority=2,dataProvider="opt1")
	public void home_click_getstarted(String opt)
	{
		hp.Getstart_click(opt);
		String	Expected_warn="You are not logged in";
		 String warn=hp.warning_mess();
		 Assert.assertEquals(warn, Expected_warn);
	}
	
	
	@DataProvider (name = "opt")
	 public Object[][] dpMethod(){
	 return new Object[][] {{"Arrays"}, {"Linkedlist"},{"Stack"},{"Queue"},{"Tree"},{"Graph"}};
	 }
	@Test(priority=3, dataProvider="opt")
	public void home_dropdown_select(String opt)
	{
		
		hp.droplist(opt);
		String	Expected_warn="You are not logged in";
		 String warn=hp.warning_mess();
		 Assert.assertEquals(warn, Expected_warn);
				
	}
	
	@Test(priority=4)
	public void signin_launch()
	{
		Sp=hp.signin_click();
		String Expected_title="Login";
		String Actual_title=hp.launch_signin();
		//System.out.println("The title is:"+Actual_title);
		Loggerload.info(Actual_title);

		Assert.assertEquals(Actual_title, Expected_title);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
	
}
