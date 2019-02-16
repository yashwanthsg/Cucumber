package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class AddCustomerList{
	static WebDriver driver;
	@Given("The user is in home page")
	public void the_user_is_in_home_page() {
		 System.setProperty("webdriver.chrome.driver", "/home/ravin/Downloads/chromedriver");
		    driver= new ChromeDriver();
		    driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@Given("The user naviagtes to addcustomer page")
	public void the_user_naviagtes_to_addcustomer_page() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();	     
		
	}

	@When("The user fill the form details")
	public void the_user_fill_the_form_details(DataTable dataTable) {
		List<String> CustomerDetails = dataTable.asList(String.class);
		System.out.println(CustomerDetails);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(CustomerDetails.get(0));
		driver.findElement(By.id("lname")).sendKeys(CustomerDetails.get(1));
		driver.findElement(By.id("email")).sendKeys(CustomerDetails.get(2));
		driver.findElement(By.name("addr")).sendKeys(CustomerDetails.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(CustomerDetails.get(4));
		
	}

	@When("The user submits form")
	public void the_user_submits_form() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("The customer should see customer id is generated")
	public void the_customer_should_see_customer_id_is_generated() {
		 Assert.assertTrue(driver.findElement(By.xpath("//table//h3")).isDisplayed());
		 driver.quit();
	}


	
	
	
}
