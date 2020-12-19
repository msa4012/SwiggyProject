package StepDefinition;

import cucumber.api.PendingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import org.junit.Assert;

public class SwiggySignup {
	
WebDriver driver = SetUp.driver;
	
	ExtentReports extent;
	ExtentTest logger;
	
   @Given("^User is already on the swiggy website$")
    public void user_is_already_on_the_swiggy_website() throws Throwable {
		driver.get("https://www.swiggy.com/");
    }

    
   @When("^User clicks on Sign up link$")
    public void user_clicks_on_sign_up_link() throws Throwable {
    	WebElement Signupuser = driver.findElement(By.linkText("Sign up"));
    	Signupuser.click();
    	
    	Thread.sleep(5000);
    	
    	extent = new ExtentReports (System.getProperty("user.dir") +"/SwiggyTestReport.html", false);
		
 		logger = extent.startTest("Test01");
 		
 		logger.log(LogStatus.PASS, "Click on the Signup button");
    }

   
    
    @Then("^The Sign up page is obtained$")
    public void the_sign_up_page_is_obtained() throws Throwable {
System.out.println("Then");
    	
    	WebElement Logo = driver.findElement(By.xpath("//*[@class='_1Tg1D']"));
    
    	Assert.assertTrue(Logo.isDisplayed());
    	
    	logger.log(LogStatus.PASS, "Validate the signup is appearing");
    	
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
    	
    }
    
    @Given("^User is on the swiggy website already$")
    public void user_is_on_the_swiggy_website_already() throws Throwable {
    	   	
        	driver.get("https://www.swiggy.com/");
        	WebElement SingUp = driver.findElement(By.linkText("Sign up"));
        	SingUp.click();
        	
        	extent = new ExtentReports (System.getProperty("user.dir") +"/SwiggyTestReport.html", false);
        	
        	logger = extent.startTest("Test02");
        	logger.log(LogStatus.PASS, "Click on the Signup button");
    	}

    
    @When("^User provides the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_something_something_something_and_something(String phone, String name, String email, String password) throws Throwable {
        
    	WebElement tbPhone = driver.findElement(By.id("mobile"));
    	WebElement tbName = driver.findElement(By.id("name"));
    	WebElement tbEmail = driver.findElement(By.id("email"));
    	WebElement tbPwd = driver.findElement(By.id("password"));
    	
    	tbPhone.sendKeys(phone);
    	tbName.sendKeys(name);
    	tbEmail.sendKeys(email);
    	tbPwd.sendKeys(password);
    	
    	Thread.sleep(5000);
    	
    	logger.log(LogStatus.PASS, "Enter the user details");
     }
    
    @Then("^User clicks on the Continue button$")
    public void user_clicks_on_the_continue_button() throws Throwable {
        
    }

    @Then("^User is signed up$")
    public void user_is_signed_up() throws Throwable {
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
    }

}

