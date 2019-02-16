package stepdefinition;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class AddCustomerMap {
	static WebDriver driver;
	@Given("The user telecome page")
	public void the_user_telecome_page() {
	   System.setProperty("webdriver.chrome.driver", "/home/ravin/Downloads/chromedriver");
	   driver=new ChromeDriver();
	   driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@Given("The navigate customer page")
	public void the_navigate_customer_page() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();	     
	}

	@When("The user fill in the fields")
	public void the_user_fill_in_the_fields(DataTable CustomerDetails) {
	   Map<String, String> CustomerMap = CustomerDetails.asMap(String.class, String.class);
	   System.out.println(CustomerMap);
	   driver.findElement(By.xpath("//label[text()='Done']")).click();
	   driver.findElement(By.id("fname")).sendKeys(CustomerMap.get("Fname"));
	   driver.findElement(By.id("lname")).sendKeys(CustomerMap.get("Lname"));
	   driver.findElement(By.id("email")).sendKeys(CustomerMap.get("Email"));
	   driver.findElement(By.name("addr")).sendKeys(CustomerMap.get("Address"));
	   driver.findElement(By.id("telephoneno")).sendKeys(CustomerMap.get("PhNum"));
	   	
		
	}

	@When("The user submit")
	public void the_user_submit() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("The id generated")
	public void the_id_generated() {
		 Assert.assertTrue(driver.findElement(By.xpath("//table//h3")).isDisplayed());
		 driver.quit();
	}


}
