package example;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class Test7 {		
	    private WebDriver driver;	
	    String driverPath = "C:\\chromedriver.exe";

		@Test				
		public void updateQuantity() throws InterruptedException {	
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
			
			//act
			quantity.clear();
			quantity.sendKeys("2");
			Thread.sleep(3000);
			total = subTotal.getText();
			
			//assert
			Assert.assertEquals(total, "$25.98");
			
			//arrange
			WebElement checkOut = driver.findElement(By.xpath("//a[@class='btn-checkout btn btn-success  ng-scope']"));
			
			//act
			checkOut.click();
			Thread.sleep(5000);
			
			//arrange
			WebElement foreName = driver.findElement(By.xpath("//input[@id='forename']"));
			WebElement surName = driver.findElement(By.xpath("//input[@id='surname']"));
			WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
			WebElement telephone = driver.findElement(By.xpath("//input[@id='telephone']"));
			WebElement address = driver.findElement(By.xpath("//textarea[@id='address']"));
			Select cardType = new Select (driver.findElement(By.xpath("//select[@id='cardType']")));
			WebElement cardNumber = driver.findElement(By.xpath("//input[@id='card']"));
			
			//act
			foreName.sendKeys("Marc");
			surName.sendKeys("Leonardo");
			email.sendKeys("test@gmail.com");
			telephone.sendKeys("0412345678");
			address.sendKeys("11 Test Street, Melbourne VIC 3000");
			cardType.selectByVisibleText("Visa");
			cardNumber.sendKeys("0123456789101112");
			
			//arrange
			WebElement submitBtn = driver.findElement(By.xpath("//button[@id='checkout-submit-btn']"));
			
			//act
			submitBtn.click();
			Thread.sleep(15000);
			
			//arrange
			WebElement orderAccepted = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			
			//assert
			String purchaseSuccessful = orderAccepted.getText();
		    String firstWords = purchaseSuccessful.substring(0, purchaseSuccessful.lastIndexOf(" "));
		    String lastWord = purchaseSuccessful.substring(purchaseSuccessful.lastIndexOf(" ") + 1);
			Assert.assertEquals(firstWords, "Thanks Marc, your order has been accepted. Your order nuumber is");
			Assert.assertTrue(lastWord.matches("[a-zA-Z]{2}\\d{13}"));
			
			//order went through properly even with changes in quantity
			
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
