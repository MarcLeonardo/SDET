package example;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class Test3 {		
	    private WebDriver driver;	
	    String driverPath = "C:\\chromedriver.exe";

		@Test				
		public void invalidLoginDetails() throws InterruptedException {	
			driver.get("https://jupiter.cloud.planittesting.com");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Jupiter Toys")); 	

			//arrange
			WebElement loginPage = driver.findElement(By.xpath("//i[@class='icon icon-user icon-white']")); //
			
			//act
			Thread.sleep(3000);
			loginPage.click();
		
			//arrange
			WebElement loginHeader = driver.findElement(By.xpath("//div[@class='modal-header']/h1"));
			
			//act
			String login = loginHeader.getText();
			
			//assert
			Assert.assertEquals(login, "Login");
			
			//arrange
			WebElement userName = driver.findElement(By.xpath("//input[@id='loginUserName']"));
			WebElement password = driver.findElement(By.xpath("//input[@id='loginPassword']"));
			WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			
			//act
			userName.sendKeys("test@gmail.com");
			password.sendKeys("password123");
			loginButton.click();
						
			//arrange
			WebElement loginError = driver.findElement(By.xpath("//div[@id='login-error']"));
			
			//act
			String loginErrorMessage = loginError.getText();
			
			//assert
			Assert.assertEquals(loginErrorMessage, "Your login details are incorrect"); 
			
			//unverified login credentials not working
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
