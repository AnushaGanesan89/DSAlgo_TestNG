package TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import Utilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver dr;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
    static String mybrowser;
	public BaseClass()
	{
		FileReader reader=null;
		
	
		try {
			reader=new FileReader(".\\src\\test\\resources\\Config\\config.properties");
			
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 @SuppressWarnings("deprecation")
public static void intialization()
 {
	 
	mybrowser =prop.getProperty("browser");
	
	if (mybrowser.equalsIgnoreCase("chrome"))
	{
				//System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
				DesiredCapabilities dc3 = new DesiredCapabilities();
				//dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				WebDriverManager.chromedriver().setup();
				dr=new ChromeDriver();
				dr.manage().window().maximize();
	}
	else if(mybrowser.equalsIgnoreCase("firefox"))
	{
		//System.setProperty("webdriver.firefox.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
		DesiredCapabilities dc3 = new DesiredCapabilities();
		//dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		WebDriverManager.firefoxdriver().setup();
		dr=new FirefoxDriver();
		dr.manage().window().maximize();
	}
	else if(mybrowser.equalsIgnoreCase("edge"))
	{
		//System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\Drivers\\msedgedriver.exe");
		DesiredCapabilities dc3 = new DesiredCapabilities();
		//dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		WebDriverManager.edgedriver().setup();
		dr=new EdgeDriver();
		dr.manage().window().maximize();
	}
	else 
	{
		//System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
		DesiredCapabilities dc3 = new DesiredCapabilities();
		//dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		WebDriverManager.chromedriver().setup();
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		
	
}
	
	e_driver= new EventFiringWebDriver(dr);
	eventListener= new WebEventListener();
	e_driver.register((WebDriverEventListener) eventListener);
	dr=e_driver;
	
	
	
	dr.manage().deleteAllCookies();
	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	dr.get(prop.getProperty("url"));
	
	}
	
	

}
