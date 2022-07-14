package example;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class Test9 {		
	    private WebDriver driver;	
	    String driverPath = "C:\\chromedriver.exe";

		@Test				
		public void blankCheckoutForm() throws InterruptedException {	
			driver.get("https://jupiter.cloud.planittesting.com");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Jupiter Toys")); 	
			Thread.sleep(3000);
			
			//arrange
			WebElement startShopping = driver.findElement(By.xpath("//a[@class='btn btn-success btn-large']")); //start shopping btn
			
			//act
			startShopping.click();
			
			//arrange
			Thread.sleep(5000);
			WebElement teddyBuyButton = driver.findElement(By.xpath("//li[@id='product-1']//a")); //teddy bear buy btn
			WebElement cartHeader = driver.findElement(By.xpath("//li[@id='nav-cart']"));
						
			//act
			teddyBuyButton.click();
			Thread.sleep(3000);
			String addTocart = cartHeader.getText();
			cartHeader.click();
			Thread.sleep(5000);
			
			//assert
			Assert.assertEquals(addTocart, "Cart (1)");
			
			//arrange
			WebElement price = driver.findElement(By.xpath("//tr[@class='cart-item ng-scope']//td[2]"));
			WebElement quantity = driver.findElement(By.xpath("//tr[@class='cart-item ng-scope']//td[3]/input"));
			WebElement subTotal = driver.findElement(By.xpath("//tr[@class='cart-item ng-scope']//td[4]"));
			
			//act
			String actualPrice = price.getText();
			String actualQuantity = quantity.getAttribute("value");
			String total = subTotal.getText();
			Thread.sleep(3000);
			
			//assert
			Assert.assertEquals(actualPrice, "$12.99");
			Assert.assertEquals(actualQuantity, "1");
			Assert.assertEquals(total, "$12.99");
			
			//arrange
			WebElement checkOut = driver.findElement(By.xpath("//a[@class='btn-checkout btn btn-success  ng-scope']"));
			
			//act
			checkOut.click();
			Thread.sleep(5000);
			
			//arrange
			WebElement submitBtn = driver.findElement(By.xpath("//button[@id='checkout-submit-btn']"));
			
			//act
			submitBtn.click();
			Thread.sleep(3000);
			
			//arrange
			WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']"));
			
			//act
			Thread.sleep(3000);
			String actualAlert = alert.getText();
			
			//assert
			Assert.assertEquals(actualAlert, "Almost there - but we can't send your items unless you complete the form correctly.");
			
			//order did not pushed through with an invalid checkout form
		}
		
		@BeforeTest
		public void beforeTest() {	
		    System.setProperty("webdriver.chrome.driver", driverPath);
		    driver = new ChromeDriver();  
		}
		
		@AfterTest
		public void afterTest() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}		
}	
