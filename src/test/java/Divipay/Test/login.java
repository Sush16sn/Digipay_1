package Divipay.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.UUID;

import org.openqa.selenium.By;


import pageObjects.userdetails;
import resources.base;


public class login extends base{
	
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://app-moccona.divipay.com/app/business-signup");
	}
	
	private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@bosch.com";
    }
	
	//Test 1: Verify the error message when email field is empty
	@Test 
	public void emptyErrorvalidation() 
	{
		userdetails ud = new userdetails(driver); 
		ud.getSubmit().click(); 
		
		String actual_error = driver.findElement(By.xpath("//span[contains(text(),'Please enter an email address')]")).getAttribute("innerHTML");
		AssertJUnit.assertTrue(actual_error.contains("Please enter an email address"));
		driver.close();			
	}
	//Test 2: Verify the error message when invalid work email is used to create an account
	@Test 
	public void populateFields()  
	{
		userdetails ud = new userdetails(driver); 
		ud.getEmail().sendKeys("test@divipay.com");	
		ud.getSubmit().click(); 
		ud.getPassword().sendKeys("Test@123");
		ud.getCheck().click();
		ud.createAcc().click();
	
		String actual_error = driver.findElement(By.cssSelector("div.App div.AppContentsContainer__StyledAppContentsContainer-hiw98q-0.fpfFhx div.AuthCommon__AuthPageBackgroundWrapper-r3thuv-1.cUqxqz div.AuthCommon__LegacyHeaderLessPageContainer-r3thuv-0.gKwKWz div.BaseAuth div.AuthCommon__AuthPanel-r3thuv-4.bmxpfa form:nth-child(1) div.Flex-sc-3v5oj8-0.Flex__FullWidthFlex-sc-3v5oj8-3.hxbKZk.sc-AxjAm.lntlPg:nth-child(1) div.BusinessSignup__StyledFormTextInput-vq09nq-0.bmIHak div.WithFormInput__SubTextContainer-sc-1mzb10l-0.bHkHfM > span.sc-AxirZ.sc-AxiKw.Body__BodyText-sc-10o5ese-0.Body__ErrorText-sc-10o5ese-3.csbGUZ")).getAttribute("innerHTML");
		AssertJUnit.assertTrue(actual_error.contains("Please try again with your work email address"));
		driver.close();	
	}
	//Test 3: Verify the error message for invalid password 
		@Test 
		public void invalidPwd()  
		{
			userdetails ud = new userdetails(driver); 
			ud.getEmail().sendKeys(randomEmail());	
			ud.getSubmit().click(); 
			ud.getPassword().sendKeys("Test");
			ud.getCheck().click();
			ud.createAcc().click();
			
			String actual_error = driver.findElement(By.cssSelector("span[class = 'sc-AxirZ sc-AxiKw Body__BodyText-sc-10o5ese-0 Body__ErrorText-sc-10o5ese-3 jBnWou']")).getAttribute("innerHTML");
			AssertJUnit.assertTrue(actual_error.contains("Password is too weak"));
			driver.close();	
		}
	//Test 4: Verify the error messages for empty mandatory fields
		@Test 
		public void fieldValidations()  
		{
			userdetails ud = new userdetails(driver); 
			ud.getEmail().sendKeys(randomEmail());	
			ud.getSubmit().click(); 
			ud.getPassword().sendKeys("Test@123");
			ud.getCheck().click();
			ud.createAcc().click();
			driver.close();
		
		}
		//Test 5: Verify the user is able to create an account with valid work email
		@Test 
		public void validDetails()  
		{
			userdetails ud = new userdetails(driver); 
			ud.getEmail().sendKeys("randomEmail()");	
			ud.getSubmit().click(); 
			ud.getPassword().sendKeys("Test@123");
			ud.getCheck().click();
			ud.createAcc().click();
			driver.close();
			
		}
		
	

}
