import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Github {
	WebDriver driver;
	@Given("^Open browser as \"([^\"]*)\" And enter url as \"([^\"]*)\"$")
	public void open_browser_as_And_enter_url_as(String browser, String url) throws Throwable {
	  driver= new FirefoxDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^Enter username <username> And password <password> And click on sign in button$")
	public void enter_username_username_And_password_password_And_click_on_sign_in_button(DataTable username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	   List<List<String>> data=username.raw();
	   driver.findElement(By.linkText("Sign in")).click();
	   WebElement el=driver.findElement(By.id("login_field"));
	   el.clear();
	   el.sendKeys(data.get(0).get(0));
	   WebElement ele=driver.findElement(By.id("password"));
	   ele.clear();
	   ele.sendKeys(data.get(0).get(1));
	   driver.findElement(By.xpath(".//*[@id='login']/form/div[4]/input[3]")).click();
	}
	@When("^Enter username \"([^\"]*)\" And password \"([^\"]*)\" And click on sign in button$")
	public void enter_username_And_password_And_click_on_sign_in_button(String username1, String password1) throws Throwable {
		driver.findElement(By.linkText("Sign in")).click();
		   WebElement el=driver.findElement(By.id("login_field"));
		   el.clear();
		   el.sendKeys(username1);
		   WebElement ele=driver.findElement(By.id("password"));
		   ele.clear();
		   ele.sendKeys(password1);
		   driver.findElement(By.xpath(".//*[@id='login']/form/div[4]/input[3]")).click();
		   Assert.assertEquals(driver.getTitle(), "gi");
	}



	@Then("^Successfully login github$")
	public void successfully_login_github() throws Throwable {
	    System.out.println("login success");
	}

	@Then("^unSuccessfully login github$")
	public void unsuccessfully_login_github() throws Throwable {
	    System.out.println("login unsucess");
	}
@After
public void close()
{
	driver.quit();
}


}
