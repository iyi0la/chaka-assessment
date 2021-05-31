package chakaTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChakaFund {

		 static WebDriver driver = null; 
		
		@BeforeTest
		public static void setUpTest(){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\new\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		@Test
		public void chakaTest() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		openAndLogin(driver, js);
		driver.findElement(By.xpath("//a[contains(text(),'Wallet')]")).click();
		fundProcess(driver);
		fundMode(driver);
		}
		
	private void openAndLogin(WebDriver driver,JavascriptExecutor js) {
		driver.get("https://chaka.com");
		driver.findElement(By.linkText("Log in")).click();
			
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("tesleemisiaq1@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Harkintunde1");
		js.executeScript("window.scrollBy(0, 200)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}	
		
//		Funding can be made both at Global and Local level
		
	private void fundProcess(WebDriver driver) {
		driver.findElement(By.xpath("//span[@class='sbtn active']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Local')]")).click();
	}	
		
//		Selecting 'Pay By Card/Ussd (Interswitch)' as mode of funding
		
	private void fundMode(WebDriver driver)	{
		driver.findElement(By.xpath("//p[contains(text(),'Pay by card/ussd (interswitch)')]")).click();
		driver.findElement(By.xpath("//input[@id='fundAmount']")).clear();
		int val = 1000;
		String str = Integer.toString(val);
		driver.findElement(By.xpath("//input[@id='fundAmount']")).sendKeys(String.valueOf(str));
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	
		driver.findElement(By.xpath("//div[@class='item-wrapper card active']")).click();
		driver.findElement(By.xpath("//input[@id='Cc']")).click();
		String val1 = "4061 8000 0000 0071"; 
		driver.findElement(By.xpath("//input[@id='fundAmount']")).sendKeys(val1);
		driver.findElement(By.xpath("//input[@id='CCexpiry']")).click();
		driver.findElement(By.xpath("//input[@id='CCexpiry']")).sendKeys("04");
		driver.findElement(By.xpath("//input[@id='CCexpiry']")).sendKeys("2023");
		driver.findElement(By.xpath("//input[@id='Cvv']")).click();
		driver.findElement(By.xpath("//input[@id='Cvv']")).sendKeys("400");
		
		driver.findElement(By.xpath("//span[@class='btn-text']")).click();
	}	
				
}


