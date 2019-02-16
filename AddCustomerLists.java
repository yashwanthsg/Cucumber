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

public class AddCustomerLists {
	static WebDriver driver;
	

	@Given("The user telecom page")
	public void the_user_telecom_page() {
		 System.setProperty("webdriver.chrome.driver", "/home/ravin/Downloads/chromedriver");
		    driver= new ChromeDriver();
		    driver.get("http://demo.guru99.com/telecom/index.html");	}

	@Given("The user navigates to add customer page")
	public void the_user_navigates_to_add_customer_page() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();	
	}

	@When("The user filling the details")
	public void the_user_filling_the_details(DataTable CustomerDetails) {
		List<List<String>> CustomerDetailsLists = CustomerDetails.asLists(String.class);
		System.out.println(CustomerDetailsLists);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(CustomerDetailsLists.get(0).get(0));
		driver.findElement(By.id("lname")).sendKeys(CustomerDetailsLists.get(1).get(1));
		driver.findElement(By.id("email")).sendKeys(CustomerDetailsLists.get(2).get(2));
		driver.findElement(By.name("addr")).sendKeys(CustomerDetailsLists.get(3).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(CustomerDetailsLists.get(3).get(4));
	}

	@When("The user submitss the form")
	public void the_user_submitss_the_form() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("The customer id is generated")
	public void the_customer_id_is_generated() {
		 Assert.assertTrue(driver.findElement(By.xpath("//table//h3")).isDisplayed());
		 driver.quit();
	}


	
}
