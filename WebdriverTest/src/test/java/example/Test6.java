package example;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class Test6 {		
	    private WebDriver driver;	
	    String driverPath = "C:\\chromedriver.exe";

		@Test				
		public void emptyCart() throws InterruptedException {	
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
			WebElement emptyCartBtn = driver.findElement(By.xpath("//a[@class='btn btn-danger ng-scope']"));
			
			//act
			emptyCartBtn.click();
			Thread.sleep(3000);
			
			//arrange
			WebElement emptyCartPopup = driver.findElement(By.xpath("//div[@class='modal-header']"));
			
			//act
			String emptyCartPage = emptyCartPopup.getText();
			
			//assert
			Assert.assertEquals(emptyCartPage, "Empty Cart");
			
			//arrange
			WebElement yesBtn = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
			
			//act
			yesBtn.click();
			Thread.sleep(3000);
			
			//arrange
			WebElement alert = driver.findElement(By.xpath("//div[@class='alert']"));
			
			//act
			String actualAlert = alert.getText();
			
			//assert
			Assert.assertEquals(actualAlert, "×\nYour cart is empty - there's nothing to see here.");
			
			//emptying cart button works properly
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
