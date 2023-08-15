package Pages_Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LaunchPage;
import TestBase.BaseClass;
import java.util.logging.Logger;
import Utilities.Loggerload;

public class LaunchPage_Test extends BaseClass {
	
	LaunchPage lp;
	HomePage hmpg;
	
	public LaunchPage_Test()
	{
		super();
	}
	@BeforeMethod()
	public void setup()
	{
		intialization();
		lp=new LaunchPage();
	}
	
	@Test(priority=1)
	public void launch_title()
	{
		String Expected_title="Numpy Ninja";
		String Actual_title=lp.Get_LaunchTitle();
		//System.out.println("The title is:"+Actual_title);
		Loggerload.info(Actual_title);
		Assert.assertEquals(Actual_title, Expected_title);
	}
	
	@Test(priority=2)
	public void launch_click()
	{
		hmpg=lp.click_GetStarted();
		
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
	
	

}
