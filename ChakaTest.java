package chakaTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChakaTest {
	
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

		openAndRegister(driver, js);
		Thread.sleep(7000);
		login(driver);
		Thread.sleep(3000);
		clickAccountVerification(driver);
		fillInPersonalInformation(driver, js);
		fillInBankDetails(driver);
		bvnVerification(driver, js);
		Thread.sleep(5000);	
//		validateBvn(driver);
		driver.findElement(By.xpath("//a[contains(text(),'Compliance Profi')]")).click();
		complianceProfile(driver);
		tradeInformation(driver);
		driver.findElement(By.xpath("//a[contains(text(),'Employment Detai')]")).click();
		employmentDetails(driver);
		investmentProfile(driver);
		documentUpload(driver);	
	}
	
	private void openAndRegister(WebDriver driver, JavascriptExecutor js) {
		driver.get("https://chaka.com");
		driver.findElement(By.linkText("Log in")).click();
		js.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.className("sign-up-link")).click();
		
		js.executeScript("window.scrollBy(0, 300)");
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("tesleemisiaq1@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Harkintunde1");
		driver.findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("@Harkintunde1");
		
		js.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	private void login(WebDriver driver) {
		driver.findElement(By.className("login-link")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("tesleemisiaq1@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Harkintunde1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	private void clickAccountVerification(WebDriver driver) {
		driver.findElement(By.xpath("//a[contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Verifications')]")).click();
	}
	
	private void fillInPersonalInformation(WebDriver driver, JavascriptExecutor js) {
		WebElement element = driver.findElement(By.xpath("//select[@type='text']"));
		Select sel = new Select(element);
		js.executeScript("window.scrollBy(0, 500)");
		sel.selectByValue("Mr");
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("Tesleem");
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Isiaq");
		driver.findElement(By.id("gridRadios1")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
		
	private void fillInBankDetails(WebDriver driver)throws InterruptedException{
		WebElement bankElement = driver.findElement(By.xpath("//select[@formcontrolname='bankId']"));
		Select bankSelect= new Select(bankElement);
		bankSelect.selectByVisibleText("Guaranty Trust Bank");
		driver.findElement(By.xpath("//input[@formcontrolname='bankAcctNo']")).sendKeys("0149029325");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	private void bvnVerification(WebDriver driver, JavascriptExecutor js) {
		driver.findElement(By.xpath("//input[@formcontrolname='bvn']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='bvn']")).sendKeys("22161668714");
		js.executeScript("window.scrollBy(0, 300)");
		
		driver.findElement(By.xpath("//input[@type='date']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).clear();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("04");
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("Mar");
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("1994");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	private void validateBvn(WebDriver driver)  throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
		Thread.sleep(45000);
		driver.findElement(By.xpath("//input[@formcontrolname='otp']")).sendKeys("216026");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		WebElement aa= driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		System.out.println ("Submit OTP enabled > "+ aa.isEnabled());
		if (aa.isEnabled()) {
			System.out.println("Able to click submit");
		} else {
			
			System.out.println("Unable to click submit");
		}
	}

	private void complianceProfile(WebDriver driver) {
		driver.findElement(By.xpath("//input[@formcontrolname='nextOfKin']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='nextOfKin']")).sendKeys("Saheed Yusuf");
		driver.findElement(By.xpath("//input[@formcontrolname='nextOfKinPhone']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='nextOfKinPhone']")).sendKeys("08102375562");
		driver.findElement(By.xpath("//input[@formcontrolname='address']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='address']")).sendKeys("No 14, Apena street, Ojuelegba");
		driver.findElement(By.xpath("//input[@formcontrolname='postalCode']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='postalCode']")).sendKeys("101283");
		
		WebElement marital = driver.findElement(By.xpath("//select[@formcontrolname='maritalStatus']"));
		Select maritalSelect = new Select(marital);
		maritalSelect.selectByVisibleText("SINGLE");
		
		WebElement city = driver.findElement(By.xpath("//select[@formcontrolname='city']"));
		Select citySelect = new Select(city);
		citySelect.selectByVisibleText("Oyo");
		
		WebElement lga = driver.findElement(By.xpath("//select[@formcontrolname='lg']"));
		Select lgaSelect = new Select(lga);
		System.out.println("Test is:"+  lgaSelect.getFirstSelectedOption().getText());
		lgaSelect.selectByVisibleText("Bende");
		
		
		WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='country']"));
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("Nigeria");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	private void tradeInformation(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//input[@formcontrolname='cscsNumber']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='cscsNumber']")).sendKeys("10239249645");
		driver.findElement(By.xpath("//input[@formcontrolname='cscsCHN']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='cscsCHN']")).sendKeys("W1023924645");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		Alert alertOk = driver.switchTo().alert();
		alertOk.accept();
		Thread.sleep(2000);
	}
	private void employmentDetails(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='UNEMPLOYED']")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}
	private void investmentProfile(WebDriver driver) {
		driver.findElement(By.xpath("//input[@id='gridRadios2']")).click();
		driver.findElement(By.xpath("//input[@value='YRS_1_2']")).click();
		driver.findElement(By.xpath("//input[@value='5000000']")).click();
		driver.findElement(By.xpath("//input[@value='2500000']")).click();
		driver.findElement(By.xpath("//input[@value='2500000']")).click();
		driver.findElement(By.xpath("//input[@value='LOW']")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	private void documentUpload(WebDriver driver) {
		WebElement doctype = driver.findElement(By.xpath("//select[@formcontrolname='id_type']"));
		Select doctypeSelect = new Select(doctype);
		doctypeSelect.selectByVisibleText("Voter's Card");
		WebElement upload_file = driver.findElement(By.xpath("//input[@type='file']"));
		upload_file.sendKeys("C:\\Users\\SHITTU\\Desktop\\Excel\\test.png");
		
		WebElement doctype1 = driver.findElement(By.xpath("//select[@formcontrolname='address_type']"));
		Select doctypeSelect1 = new Select(doctype1);
		doctypeSelect1.selectByVisibleText("PHCN Electrical Bill");
		WebElement upload_file1 = driver.findElement(By.xpath("//input[@type='file']"));
		upload_file1.sendKeys("C:\\Users\\SHITTU\\Desktop\\Excel\\capture.png");
		
	}
	
	@AfterTest 
	public void tearDownTest(){
		driver.close();
		driver.quit();
	}
}

