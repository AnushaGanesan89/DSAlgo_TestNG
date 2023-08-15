package Pages_Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelData.ExcelReader;
import Pages.DS_Time;
import Pages.DataStructures;
import Pages.HomePage;
import Pages.LaunchPage;
import Pages.Register;
import Pages.SignIn;
import Pages.Try_Editor;
import TestBase.BaseClass;

public class DataStructures_Test extends BaseClass{

	HomePage hp;
	LaunchPage lp;
	SignIn Sp;
	Register rp;
	DataStructures ds;
	DS_Time dt;
	Try_Editor te;
	
	public DataStructures_Test()
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
		ds=new DataStructures();
		hp=lp.click_GetStarted();
		Sp=hp.signin_click();
		hp=Sp.signin_common(prop.getProperty("uname"), prop.getProperty("pass"));
		ds=hp.DS_click();
		
		
		
		
	}
	
	@Test(priority=1)
	public void DS_launch()
	{
		//ds=hp.DS_click();
		String Expected_title="Data Structures-Introduction";
		String Actual_title=ds.DS_Title();
		System.out.println("The title is:"+Actual_title);
		Assert.assertEquals(Actual_title, Expected_title);
		
	}
	@Test(priority=2,dataProvider="validdsexcel")
	public void Time_Comp_click(String code) throws InterruptedException
	{
		dt=ds.time_complex_click();
		String Expected_title="Time Complexity";
		String Actual_title=dt.DS_Time_Title();
		System.out.println("The title is:"+Actual_title);
		Assert.assertEquals(Actual_title, Expected_title);
		te=dt.tryhere_click();
		String Expected_title1="Assessment";
		String Actual_title1=te.Try_Editor_Title();
		System.out.println("The title is:"+Actual_title1);
		Assert.assertEquals(Actual_title1, Expected_title1);
		te.enter_phyton_code(code);
		te.run_click();
		//te.run_result();
		
		
	}
	
	
	
	@DataProvider (name = "validdsexcel")
	 public Object[][] getTestData() throws InvalidFormatException
	 {
		Object data[][]=ExcelReader.getTestData("DSCode");
		return data;
		
	 }
	
	
	
	@AfterMethod
	public void tearDown()
	{
		dr.quit();
	}
	
	
}
