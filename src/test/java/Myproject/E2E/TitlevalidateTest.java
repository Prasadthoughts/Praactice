package Myproject.E2E;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.baseTest;

public class TitlevalidateTest extends baseTest {
	
	public static Logger log=LogManager.getLogger(baseTest.class.getName());
 
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to the URL");
	}
	
	
	@Test
	public void validations() throws IOException
	{
		
		LandingPage lp=new LandingPage(driver);
		//System.out.println(lp.getTitle().getText());
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Validation is successfully");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
