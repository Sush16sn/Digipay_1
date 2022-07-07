package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	static WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop= new Properties();
		InputStream is = getClass().getResourceAsStream("/data.properties");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		//FileInputStream fls= new FileInputStream("/Users/sushmitha/eclipse-workspace/Test/src/main/java/resources/data.properties");
		
		prop.load(reader);
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "//Users/sushmitha/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
