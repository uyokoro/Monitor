package TestNGTestCases;

import org.testng.annotations.Test;
import PageObject.MonitorPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MonitorTestNG {
	static WebDriver driver;
	
	static MonitorPageObjects amazonPageObjects;

  @Test
  public void f() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects = new  MonitorPageObjects (driver);
		amazonPageObjects.AcceptButton();
		amazonPageObjects.SearchforItem.sendKeys("Laptop");
		amazonPageObjects.ClickOnSearchButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.ClickOnFirstItem();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(amazonPageObjects.ProductPagePrice);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.AddItemToCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.NoThankYouButton();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		amazonPageObjects.ClickOnCart();
	
  }
 @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

 // @AfterTest
  public void afterTest() {

	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.quit();
  }

}
