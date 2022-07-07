package pageObjects;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class userdetails {
	
		public WebDriver driver;
		
		By signUp = By.xpath("//button[contains(text(),'Sign up')]");
		By email= By.name("email");
		By password= By.name("password");
		By chkbox = By.cssSelector("input[type='checkbox']");
		By createAcc = By.cssSelector("button[type='submit']");
		
		public userdetails(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver= driver;
		}
		 
		public WebElement getSubmit()
		{
			return driver.findElement(signUp);
		}
		public WebElement getEmail()
		{
			return driver.findElement(email);
		}
		public WebElement getPassword()
		{
			return driver.findElement(password);
		}
		public WebElement getCheck()
		{
			return driver.findElement(chkbox);
		}
		public WebElement createAcc()
		{
			return driver.findElement(createAcc);
		}
		
}
