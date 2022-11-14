package sauceobjects;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Simi Soosan Thomas
 * @version TC:01
 *
 */

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	//POM objects of cart page 
	By addToCart =By.xpath("//*[text()='Add to cart']");
	By cartTotal =By.xpath("//span[text()='3']");
	
	public void cart()  {
		
		
			try {
				Thread.sleep(2000);
			
				// find total number of 'Add to Cart'buttons
				List<WebElement> cartvalue= driver.findElements(addToCart);
				
				// To select random three products and to add to the cart.
				for (int i=0;i<3;i++) {
					Thread.sleep(2000);;
					Random random = new Random();
					int count=cartvalue.size();
					int index=random.nextInt(count);
					cartvalue.get(index).click();
					Thread.sleep(2000);;
					System.out.println("The index value of product added to cart is : "+index);
				}
				
				//check if added to cart 3 products:
				WebElement display= driver.findElement(cartTotal);
				if(display.isDisplayed()) {
					System.out.println("Test case Passed : Three products are added to cart successfully ");
	
				}
				else {
					System.out.println("Test case Failed : Three products not added to cart  ");
	
				}
				
				}
			catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 


	}
	
}
