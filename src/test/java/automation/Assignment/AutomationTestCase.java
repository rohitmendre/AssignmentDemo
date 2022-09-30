package automation.Assignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTestCase {
	WebDriver driver;
	
	String[] setProperty= {"chrome","gecko","edge"};
	String[] username= {"RameshKkhade","Jayeshssable","Ganeshcchavan"};
	
	
	static int count=0;
//	@SuppressWarnings("deprecation")
	@Test(invocationCount=3)
	public void checkout() throws InterruptedException {
		
		System.setProperty("webdriver."+setProperty[count]+".driver", "C:\\Users\\Rohit.Mendre\\Desktop\\Assignment\\chromedriver_win32 (1)\\"+setProperty[count]+"driver.exe");
		if(setProperty[count].equals("chrome")) {
		 driver=new ChromeDriver();
		 
		}
		else if(setProperty[count].equals("gecko")) {
			 driver=new FirefoxDriver();
			 
		}
		else if(setProperty[count].equals("edge")){
			 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
//		driver.get("https://automationteststore.com/");
		driver.get("https://automationteststore.com/index.php?rt=account/account");
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=account/login']")).click();
		driver.findElement(By.xpath("//button[@title='Continue']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Rohit");
		driver.findElement(By.name("lastname")).sendKeys("Mendre");
		driver.findElement(By.name("email")).sendKeys(""+username[count]+"@gmail.com");
		
		System.out.println(" Value of count = "+count);
		driver.findElement(By.name("telephone")).sendKeys("020-45642");
		driver.findElement(By.name("fax")).sendKeys("555-123-4567");
		driver.findElement(By.id("AccountFrm_company")).sendKeys("xpanxion");
		driver.findElement(By.id("AccountFrm_address_1")).sendKeys("Capital House");
		driver.findElement(By.id("AccountFrm_address_2")).sendKeys("Sinhagad Road");
		driver.findElement(By.id("AccountFrm_city")).sendKeys("Pune");
		WebElement dropdownCountry=driver.findElement(By.id("AccountFrm_country_id"));

		Select selectRegion=new  Select(dropdownCountry);
		selectRegion.selectByVisibleText("India");

		
		WebElement dropdownRegion=driver.findElement(By.name("zone_id"));
		
		 selectRegion=new Select(dropdownRegion);
		selectRegion.selectByVisibleText("Maharashtra");
		
		driver.findElement(By.name("postcode")).sendKeys("411041");
		
		driver.findElement(By.name("loginname")).sendKeys(username[count]);
		++count;
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys("rohit");
		
		WebElement confirmPass=driver.findElement(By.name("confirm"));
		confirmPass.sendKeys("rohit");
		
		
		driver.findElement(By.xpath("//label/input[@id='AccountFrm_newsletter0']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
			driver.findElement(By.xpath("//button[@title='Continue']")).click();
			
		
			
		
	
//		WebElement validation=driver.findElement(By.xpath("//span[text()=' Your Account Has Been Created!']"));
//		System.out.println(validation.getText());
//		boolean b=validation.getText().equals("YOUR ACCOUNT HAS BEEN CREATED!");
//		
//		System.out.println(b);
//		if(b) {
//		driver.findElement(By.xpath("//a[@title='Continue']")).click();
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/category&path=49']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/ul/li[@class='col-md-2 col-sm-2 col-xs-6 align_center']/a/img")).click();
		driver.findElement(By.xpath("//div[@class='pricetag jumbotron']//a[@data-id='62']")).click();
		driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=checkout/cart']")).click();
		driver.findElement(By.xpath("//a[@id='cart_checkout1']")).click();
		driver.findElement(By.id("checkout_btn")).click();
		
		
	}
//	@AfterTest
//	void close() {
//		driver.quit();
//		count++;
//	}
	
	
	

}
