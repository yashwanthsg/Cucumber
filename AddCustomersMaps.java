package stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class AddCustomersMaps {
static WebDriver driver;
@Given("The telecome page")
public void the_telecome_page() {
   System.setProperty("webdriver.chrome.driver", "/home/ravin/Downloads/chromedriver");
   driver=new ChromeDriver();
   driver.get("http://demo.guru99.com/telecom/index.html");
}

@Given("The navigate to customer page")
public void the_navigate_to_customer_page() {
	driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();	     

}

@When("The user fill the fields")
public void the_user_fill_the_fields(DataTable CustomerDetails) {
	List<Map<String, String>> CustomerDetailsMaps = CustomerDetails.asMaps(String.class, String.class);
	   System.out.println(CustomerDetailsMaps);
	   driver.findElement(By.xpath("//label[text()='Done']")).click();
	   driver.findElement(By.id("fname")).sendKeys(CustomerDetailsMaps.get(3).get("Fname"));
	   driver.findElement(By.id("lname")).sendKeys(CustomerDetailsMaps.get(1).get("Lname"));
	   driver.findElement(By.id("email")).sendKeys(CustomerDetailsMaps.get(1).get("Email"));
	   driver.findElement(By.name("addr")).sendKeys(CustomerDetailsMaps.get(1).get("Address"));
	   driver.findElement(By.id("telephoneno")).sendKeys(CustomerDetailsMaps.get(2).get("PhNum"));
}

@When("The user submit the button")
public void the_user_submit_the_button() {
	driver.findElement(By.name("submit")).click();
}

@Then("The Customer id generated")
public void the_Customer_id_generated() {
	 Assert.assertTrue(driver.findElement(By.xpath("//table//h3")).isDisplayed());
	 driver.quit();
}
}
