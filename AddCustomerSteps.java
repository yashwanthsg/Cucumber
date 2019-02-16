package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddCustomerSteps {
	static WebDriver driver;
	@Given("The user is in telecom home page")
	public void the_user_is_in_telecom_home_page() {
	    System.setProperty("webdriver.chrome.driver", "/home/ravin/Downloads/chromedriver");
	    driver= new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@Given("The user naviagtes to add customer page")
	public void the_user_naviagtes_to_add_customer_page() {
	    driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	    		
	}

	@When("The user fill in the form details")
	public void the_user_fill_in_the_form_details() {
	    driver.findElement(By.xpath("//label[text()='Done']")).click();
	    driver.findElement(By.id("fname")).sendKeys("yashwanth");
	    driver.findElement(By.id("lname")).sendKeys("kumar");
	    driver.findElement(By.id("email")).sendKeys("yashwanth121294@gmail.com");
	    driver.findElement(By.name("addr")).sendKeys("Taramani");
	    driver.findElement(By.id("telephoneno")).sendKeys("97508000006");
	}

	@When("The user submits the form")
	public void the_user_submits_the_form() {
	    driver.findElement(By.name("submit")).click();
	    
	}

	@Then("The customer should see the customer id is generated")
	public void the_customer_should_see_the_customer_id_is_generated() {
	   Assert.assertTrue(driver.findElement(By.xpath("//table//h3")).isDisplayed());
	}


}
