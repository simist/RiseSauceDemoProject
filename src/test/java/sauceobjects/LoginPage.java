package sauceobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * 
 * @author Simi Soosan Thomas
 * @version TC:01
 *
 */

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;}
	
	
	// POM objects related to LoginPage
	
	By uname =By.xpath("//input[@id ='user-name']"); // username field
	By pass = By.xpath("//input[@id ='password'] "); // password field
	By login = By.xpath(" //input[@id ='login-button']"); // login button
	By lockedUserText =By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']"); // Error message of User 2
	By pbmUser =By.xpath("/static/media/sl-404.168b1cce.jpg");// Problem user verification image
	By performUser = By.xpath("//span[text()='Products']"); // Performance user verification
	//By noUserName = By.xpath("//*[text()='Epic sadface: Username is required']"); // no username error message
	//By noPass	= By.xpath("//*[text()='Epic sadface: Password is required']"); // no password error message
	//By invalidLogin =By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']");// invalid login combination
	
	@SuppressWarnings("deprecation")
	public void getUser(String username, String password) {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String expUser1 = "standard_user" ;
		String expUser2 = "locked_out_user";
		String expUser3= "problem_user";
		String expUser4="performance_glitch_user";
		String expPwd="secret_sauce";
		
		
		// Pass values to username and password fields
		try {
			
			Thread.sleep(2000);
		
			driver.findElement(uname).sendKeys(username); // input correct username
			driver.findElement(pass).sendKeys(password); // input correct password
			driver.findElement(login).click();
			Thread.sleep(2000);
			
			// check if entered username and password is correct --> User has to login
			if(username.equals(expUser1)) {
				
				if(password.equals(expPwd)){
					System.out.println("Testcase Pass: User logged in successfully");
				}
				
				else {
					System.out.println("Testcase Fail: Wrong Password");
				}
			}
			
			
			// check if entered user is locked out user --> Error message to be displayed
			else if(username.equals(expUser2)) {
				
				/*
				 * check if entered password is correct
				 * check if error message is displayed when valid username and password is given
				 */
				
				if(password.equals(expPwd)){
					WebElement userErrorText = driver.findElement(lockedUserText);
					String expectedText="Epic sadface: Sorry, this user has been locked out.";
					String actualText = userErrorText.getText();
					Assert.assertEquals(expectedText, actualText, "issue with  field error message of lock out user");
					System.out.println(" Test case pass: correct error message displayed when locked out user try to login");
	
				}
				
				else {
					System.out.println("Testcase Fail: Wrong Password");
				}
			}
			
			// check if entered user is problem user --> Error message to be displayed
			else if(username.equals(expUser3)) {
				
				/*
				 * check if entered password is correct
				 * check if problem user is able to login
				 */
				
				if(password.equals(expPwd)){				
					//check if error image is displayed
					WebElement userErrorImage = driver.findElement(pbmUser);
					if(userErrorImage.isDisplayed()) {
						System.out.println("Testcase Pass: Probelm User logged in successfully");
	
					}
					else {	
						System.out.println("Testcase Fail: Probelm User login");
		
					}
				}
				
				else {
					System.out.println("Testcase Fail: Wrong Password");
				}
			}
			
	
			// check if entered user is performance user --> User loged in after a while
			else if(username.equals(expUser4)) {
				
				/*
				 * check if entered password is correct
				 * check if performance user is able to login
				 */
				
				if(password.equals(expPwd)){
					driver.findElement(uname).sendKeys(username); // input correct username
					driver.findElement(pass).sendKeys(password); // input correct password
					driver.findElement(login).click();
					Thread.sleep(4000);
					
					/*
					 * check if user is loged in after a while 
					 */
					WebElement userText = driver.findElement(performUser);
					if(userText.isDisplayed()) {
						System.out.println("Testcase Pass: Performance User logged in successfully after a while");
	
					}
					else {	
						System.out.println("Testcase Fail: Performance User login");
		
					}
				}
				
				else {
					System.out.println("Testcase Fail: Wrong Password");
				}
			}
			
			else {
				System.out.println("Testcase Fail: Invalid login details");

		}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
