package chakaTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChakaWithdraw {

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
		withdrawProcess(driver);
		
		}
		
	private void openAndLogin(WebDriver driver, JavascriptExecutor js) {
		driver.get("https://chaka.com");
		driver.findElement(By.linkText("Log in")).click();
			
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("tesleemisiaq1@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Harkintunde1");
		js.executeScript("window.scrollBy(0, 200)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
		
	private void withdrawProcess(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'Local')]")).click();
		driver.findElement(By.xpath("//span[@class='sbtn ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//input[@id='withdrawalInput']")).clear();
		String val = "1015";
		driver.findElement(By.xpath("//input[@id='withdrawalInput']")).sendKeys(val);
		
		WebElement element1 = driver.findElement(By.xpath("//select[@name='reason']"));
		Select sel = new Select(element1);
		sel.selectByVisibleText("I need the funds");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
	
		driver.findElement(By.xpath("//button[@class='continue-button']")).click();
	
}
}
