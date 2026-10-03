package loginPage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
public class OrderWOLogin {
	WebDriver driver;
		@BeforeMethod
		public void setUp() {
			ChromeOptions opt=new ChromeOptions();
		 	   opt.addArguments("headless=new");	
			driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.get("https://with-bugs.practicesoftwaretesting.com/#/");
			    }
	@Test
public void Order() throws InterruptedException {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
try {
driver.findElement(By.xpath("//a[normalize-space()='Categories']")).click();
driver.findElement(By.xpath("//a[normalize-space()='Power Tools']")).click();
WebDriverWait product=new WebDriverWait(driver,Duration.ofSeconds(10));
WebElement prod=product.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[normalize-space()='Belt Sander']")));
prod.click();
double expectedPrice = 73.59;
WebElement priceElement = product.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='col-md-2 align-middle']")));
String priceText = priceElement.getText();
double actualPrice = Double.parseDouble(priceText.replace("$", "").trim());
System.out.println("Expected Price: $" + expectedPrice);
System.out.println("Actual Price: $" + actualPrice);

Assert.assertEquals(actualPrice,expectedPrice,0.01,"Product price is incorrect");
Actions act=new Actions(driver);
WebElement add2cart=driver.findElement(By.xpath("//button[@id='btn-add-to-cart']//i[@class='fa fa-shopping-cart px-1']"));
act.moveToElement(add2cart).build().perform();
WebDriverWait cartT = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement cart=cartT.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn-add-to-cart']//i[@class='fa fa-shopping-cart px-1']")));
cart.click();
driver.findElement(By.xpath("//a[@aria-label='cart']")).click();

driver.findElement(By.xpath("//button[normalize-space()='Proceed to checkout']")).click();
driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc1240@example.com");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@12345");
driver.findElement(By.xpath("//input[@value='Login']")).click();
driver.findElement(By.xpath("//div[@class='col-md-6 offset-md-3 login-form-1']//button[@type='button'][normalize-space()='Proceed to checkout']")).click();
driver.findElement(By.xpath("//input[@id='address']")).sendKeys("NewLinkRoad");
driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharasthra");
driver.findElement(By.xpath("//input[@id='country']")).sendKeys("INDIA");
driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("122123");
driver.findElement(By.xpath("//aw-wizard-step[@steptitle='Address']//button[@type='button']")).click();

WebElement cart2=driver.findElement(By.xpath("//select[@id='payment-method']"));
Select cart1=new Select(cart2);
cart1.selectByVisibleText("Credit Card");
driver.findElement(By.xpath("//input[@id='account-name']")).sendKeys("customerName");
driver.findElement(By.xpath("//input[@id='account-number']")).sendKeys("1234556");
driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
String s=driver.findElement(By.xpath("//div[@class='help-block']")).getText();
System.out.println(s);
if(s.equals("Payment was successful"))
{
	System.out.println("Payment is done");
}
else
{
	System.out.println("Check payment method");
}
driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
driver.findElement(By.xpath("//div[@id='order-confirmation']")).isDisplayed();
}
catch(Exception e)
{
	System.out.println("Error message"+e);
}
	
}}
