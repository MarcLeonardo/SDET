package example;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class Test1 {		
	    private WebDriver driver;	
	    String driverPath = "C:\\chromedriver.exe";

		@Test				
		public void homePage() throws InterruptedException {	
			driver.get("https://jupiter.cloud.planittesting.com");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Jupiter Toys"));
			Thread.sleep(5000);
			
			//assert
			WebElement header = driver.findElement(By.xpath("//div[@class='hero-unit']/h1"));
			WebElement subTitle = driver.findElement(By.xpath("//small[@class='muted']"));
			WebElement startShoppingBtn = driver.findElement(By.xpath("//a[@class='btn btn-success btn-large']"));
			WebElement contentOne = driver.findElement(By.xpath("//p[@class='lead']"));
			WebElement contentTwo = driver.findElement(By.xpath("//div[@class='row-fluid']//p[2]"));
			WebElement credit = driver.findElement(By.xpath("//p[@class='muted ng-binding']"));
			
			//act
			String actualHeader = header.getText();
			String actualsubTitle = subTitle.getText();
			String actualstartShoppingBtn = startShoppingBtn.getText();
			String actualcontentOne = contentOne.getText();
			String actualcontentTwo = contentTwo.getText();
			String actualcredit = credit.getText();
			
			//assert
			Assert.assertEquals(actualHeader, "Jupiter Toys");
			Assert.assertEquals(actualsubTitle, "toys, games, puzzles, art and craft, novelties, teddy bears, bicycles, kites, models, sports, gifts...");
			Assert.assertEquals(actualstartShoppingBtn, "Start Shopping »");
			Assert.assertEquals(actualcontentOne, "Welcome to Jupiter Toys, a magical world for good girls and boys.");
			Assert.assertEquals(actualcontentTwo, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			Assert.assertEquals(actualcredit, "© Jupiter Toys 2022");
			
			//home page content is shown correctly
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
