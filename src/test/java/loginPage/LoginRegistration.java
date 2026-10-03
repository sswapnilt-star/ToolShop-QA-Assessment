package loginPage;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginRegistration {
    	WebDriver driver;
    @BeforeMethod
    public void setUp() {
 	ChromeOptions opt=new ChromeOptions();
 	   opt.addArguments("headless=new");
WebDriver driver=new ChromeDriver(opt);
driver.manage().window().maximize();
driver.get("https://with-bugs.practicesoftwaretesting.com/#/");
    }
    @Test
    public void registerNewUser() throws InterruptedException {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// Navigate to Registration
try {
TakesScreenshot ts = (TakesScreenshot) driver;
File sourcef1=ts.getScreenshotAs(OutputType.FILE);
File targetf1=new File(System.getProperty("user.dir")+"\\ScreenShots\\Test.png");
sourcef1.renameTo(targetf1);
driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
WebDriverWait Regwait=new WebDriverWait(driver,Duration.ofSeconds(10));
Regwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Register your account']"))).click();
driver.findElement(By.id("first_name")).sendKeys("TestAccount");
driver.findElement(By.id("last_name")).sendKeys("ToolShop");
driver.findElement(By.id("dob")).sendKeys("2000-01-01");
driver.findElement(By.id("address")).sendKeys("New Link Road,Above SBI Bank");
driver.findElement(By.id("postcode")).sendKeys("411001");
driver.findElement(By.id("city")).sendKeys("Pune");
driver.findElement(By.id("state")).sendKeys("Maharashtra");
WebElement country =driver.findElement(By.id("country"));
Select dropdown = new Select(country);
dropdown.selectByVisibleText("India");
driver.findElement(By.id("phone")).sendKeys("9999999999");
String email ="qa" + System.currentTimeMillis() + "@example.com";
String password = "Test@12345";
driver.findElement(By.id("email")).sendKeys(email);
WebElement loginPassword = wait.until(
	    ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("input[data-test='password']")
	    )
	);
loginPassword.clear();
loginPassword.sendKeys(password);
WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Register']")));
registerButton.click();
WebElement loginHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[normalize-space()='Login']")));
Assert.assertTrue(loginHeading.isDisplayed(),"Registration did not navigate to Login page");
WebElement loginEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test='email']")));
     loginEmail.clear();
        loginEmail.sendKeys(email);
WebElement loginPassword1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test='password']")));
        loginPassword1.clear();
        loginPassword1.sendKeys(password);
WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='submit']")));
((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",loginButton);
wait.until(ExpectedConditions.elementToBeClickable(loginButton));
     loginButton.click();
    }
    
   catch(Exception e) 
   {
	System.out.println("Error message:-"+e.getMessage());   
   }}
    @AfterMethod
    public void tdown() {
        if (driver != null) {
            driver.quit();
        }
    }
}