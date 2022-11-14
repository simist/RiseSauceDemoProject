package saucetest;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import sauceobjects.CartPage;
import sauceobjects.LoginPage;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

/**
 * 
 * @author Simi Soosan Thomas
 * @version TC:01
 *
 */

public class SauceDemoTest {
	
	WebDriver driver;
	LoginPage lp;
	CartPage cp;
	

  @Test(priority =0) // call the login Page
  public void login() throws InterruptedException {
	  lp = new LoginPage(driver);
	  lp.getUser("standard_user", "secret_sauce" );

  }
  
  @Test(priority =1) // call the Cart Page
  public void cart() throws InterruptedException {
	  cp = new CartPage(driver);
	  cp.cart();

  }
 
  @SuppressWarnings("deprecation")
  @BeforeTest
  public void initiateBrowser() {
	  
	  //setup chrome driver
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  //Open the requested website
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

 
  }

  @AfterTest // close the browser
  public void closeBrowser() {

		driver.close();

  }

}
