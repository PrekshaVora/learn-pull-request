package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver;
	
	@Given("Open the Chrome and launch the application")					
	public void open_the_Chrome_and_launch_the_application() throws Throwable							
	{		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe" );					
		driver= new ChromeDriver();					
		driver.manage().window().maximize();			
		driver.get("http://demo.guru99.com/v4");					
	}		

	@When("^Enter the Username and Password$")					
	public void enter_the_Username_and_Password( ) throws Throwable 							
	{		
		driver.findElement(By.name("uid")).sendKeys("username12");							
		driver.findElement(By.name("password")).sendKeys("password12 ");							
	}			

	@Then("^Reset the credential$")
	public void Reset_the_credential()
	{
		driver.findElement(By.name("btnReset")).click();
		String  actualTitle=driver.findElement(By.name("uid")).getAttribute("value");
		Assert.assertFalse(actualTitle.equals("abcd"));
		Assert.assertTrue(actualTitle.equals(""));
	}
}
