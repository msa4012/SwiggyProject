package StepDefinition;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetUp {
			
		static WebDriver driver;
		
		@BeforeMethod
		public void SetDriver() {
			
			System.out.println("Inside Before ");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			
		}
		
		@AfterMethod
		@After("@Search")
		public void CloseDriver() {
			
			System.out.println("Inside After ");
			
			driver.close();
		}

	}

