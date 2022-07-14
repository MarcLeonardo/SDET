package example;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class Test2 {		
	    private WebDriver driver;	
	    String driverPath = "C:\\chromedriver.exe";

		@Test				
		public void navigationPage() throws InterruptedException {	
			driver.get("https://jupiter.cloud.planittesting.com");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Jupiter Toys"));
			Thread.sleep(5000);
			
			//arrange
			WebElement shopBtn = driver.findElement(By.xpath("//li[@id='nav-shop']"));
			
			//act
			shopBtn.click();
			Thread.sleep(3000);
			String shopUrl = driver.getCurrentUrl();
					
			//assert
			Assert.assertEquals(shopUrl, "https://jupiter.cloud.planittesting.com/#/shop");
			
			//arrange
			WebElement homeBtn = driver.findElement(By.xpath("//li[@id='nav-home']"));
			
			//act
			homeBtn.click();
			Thread.sleep(3000);
			String homeUrl = driver.getCurrentUrl();
			
			//assert
			Assert.assertEquals(homeUrl, "https://jupiter.cloud.planittesting.com/#/home");
			
			//arrange
			WebElement contactBtn = driver.findElement(By.xpath("//li[@id='nav-contact']"));
			
			//act
			contactBtn.click();
			Thread.sleep(3000);
			String contactUrl = driver.getCurrentUrl();
			
			//assert
			Assert.assertEquals(contactUrl, "https://jupiter.cloud.planittesting.com/#/contact");
			
			//arrange
			WebElement jupiterToys = driver.findElement(By.xpath("//a[@class='brand']"));
			
			//act
			jupiterToys.click();
			Thread.sleep(3000);
			
			//assert
			Assert.assertEquals(homeUrl, "https://jupiter.cloud.planittesting.com/#/home");
			
			//arrange
			WebElement cartBtn = driver.findElement(By.xpath("//li[@id='nav-cart']"));
			
			//act
			cartBtn.click();
			Thread.sleep(3000);
			String cartUrl = driver.getCurrentUrl();
			
			//assert
			Assert.assertEquals(cartUrl, "https://jupiter.cloud.planittesting.com/#/cart");
			
			//arrange
			WebElement loginBtn = driver.findElement(By.xpath("//li[@id='nav-login']"));
			
			//act
			loginBtn.click();
			Thread.sleep(3000);
			String loginPage = loginBtn.getText();
			
			//assert
			Assert.assertEquals(loginPage, "Login");
			
			//act
			driver.findElement(By.xpath("//button[@class='btn btn-cancel']")).click();
			
			//navigation link are working
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
