package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy (xpath="/html/body/div[2]/div[1]/div/div/a") WebElement DSButton;
	@FindBy (xpath="/html/body/div[3]/div[1]/div/div/a") WebElement DSButton1;
	@FindBy (xpath="/html/body/div[2]/div[2]/div/div/a") WebElement ArrButton;
	@FindBy (xpath="/html/body/div[2]/div[3]/div/div/a") WebElement LLButton;
	@FindBy (xpath="/html/body/div[2]/div[4]/div/div/a") WebElement StkButton;
	@FindBy (xpath="/html/body/div[2]/div[5]/div/div/a") WebElement QuButton;
	@FindBy (xpath="/html/body/div[2]/div[6]/div/div/a") WebElement TrButton;
	@FindBy (xpath="/html/body/div[2]/div[7]/div/div/a") WebElement GphButton;
	@FindBy (xpath="/html/body/div[2]") WebElement Mess;
	@FindBy (linkText="Sign in") WebElement Signin;
	@FindBy (xpath=" //*[contains (text(), 'Register!')]") WebElement Register;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]") WebElement Arrlist;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]") WebElement Lnklist;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]") WebElement Stklist;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]") WebElement Qulist;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]") WebElement Trlist;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/div/a[1]") WebElement Gphlist;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[1]/div/a") WebElement toggle;
	
	
	public HomePage()
	{
		
		PageFactory.initElements(dr, this);
				
	}
	
	
	public String Homepage_Title()
	{
		//dr.get(HomeUrl);
		return dr.getTitle();
		
	}
	
	public void Getstart_click(String opt)
	{
		
		
	 if (opt.equalsIgnoreCase("Datastructures"))
	 {
		 DSButton.click();
	 }
	 else if (opt.equalsIgnoreCase("Arrays"))
	 {
		 ArrButton.click();
	 }
	 else if (opt.equalsIgnoreCase("Linkedlist"))
	 {
		 LLButton.click();
	 }
	 else if (opt.equalsIgnoreCase("Stack"))
	 {
		 StkButton.click();
	 }
	 else if (opt.equalsIgnoreCase("Queue"))
	 {
		 QuButton.click();
	 }
	 else if (opt.equalsIgnoreCase("Tree"))
	 {
		 TrButton.click();
	 }
	 else if (opt.equalsIgnoreCase("Graph"))
	 {
		 GphButton.click();
	 }
	 else
	 {
		 System.out.println("Invalid Element");
	 }
		
		
	}
		public String warning_mess()
		{
			
			String Warning= Mess.getText();
			 
			return Warning;
		}
		
		public void droplist(String opt)
		{
			toggle.click();
			
		if (opt.equalsIgnoreCase("Arrays"))
		 {
			Arrlist.click();
		 }
		 else if (opt.equalsIgnoreCase("Linkedlist"))
		 {
			 Lnklist.click();
		 }
		 else if (opt.equalsIgnoreCase("Stack"))
		 {
			 Stklist.click();
		 }
		 else if (opt.equalsIgnoreCase("Queue"))
		 {
			 Qulist.click();
		 }
		 else if (opt.equalsIgnoreCase("Tree"))
		 {
			 Trlist.click();
		 }
		 else if (opt.equalsIgnoreCase("Graph"))
		 {
			 Gphlist.click();
		 }
		 else
		 {
			 System.out.println("Invalid Element");
		 }
		}
			
		
		public SignIn signin_click()
		{
			Signin.click();
			return new SignIn();
			
		}
		
		public String launch_signin()
		{
			return dr.getTitle();
		}
		
		public DataStructures DS_click()
		{
			DSButton1.click();
			return new DataStructures();
		}
		
//		public void register_click()
//		{
//			Register.click();
//		}
//		
//		public String launch_register()
//		{
//		return dr.getTitle();	
//		}
		

}
