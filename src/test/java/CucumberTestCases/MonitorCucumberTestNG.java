package CucumberTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageObject.MonitorPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MonitorCucumberTestNG {
	
	public WebDriver driver;
	
	public MonitorPageObjects amazonPageObjects;
	
	@BeforeTest
	@Given("open Amazon.com")
	public void open_amazon_com() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects = new  MonitorPageObjects (driver);
		amazonPageObjects.AcceptButton();
	    
	}

	@Given("in the Search field type “Monitor”")
	public void in_the_search_field_type_monitor() {
		
		amazonPageObjects.SearchforItem.sendKeys("Monitor");
	   
	}

	@Then("press “Enter”")
	public void press_enter() {
	 
		amazonPageObjects.ClickOnSearchButton();
	}

	@Then("select the 1st item in the List")
	public void select_the_1st_item_in_the_list() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.ClickOnFirstItem();
	   
	}

	@Then("add the item to cart by clicking on \"Add to Cart”")
	public void add_the_item_to_cart_by_clicking_on_add_to_cart() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.AddItemToCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		amazonPageObjects.NoThanksButton();
	  
	}

	@Then("open “Cart” from the top-left")
	public void open_cart_from_the_top_left() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		amazonPageObjects.ClickOnCart();
	    
	}

	@Then("verify that the price is identical to the product page")
	public void verify_that_the_price_is_identical_to_the_product_page() {
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	@Then("verify that the sub total is identical to the product page")
	public void verify_that_the_sub_total_is_identical_to_the_product_page() {
		
		  driver.quit();
	    
	}


}
