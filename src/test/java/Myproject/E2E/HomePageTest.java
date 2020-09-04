package Myproject.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.Loginpage;
import resources.baseTest;

public class HomePageTest extends baseTest {
	public static Logger log=LogManager.getLogger(baseTest.class.getName());
    public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = InitializeDriver();
		log.info("Driver is initiated");

	}
	

	@Test(dataProvider = "getData")
	public void basePageNavigations(String Username, String Password, String text) throws IOException {
		
		driver.get(prop.getProperty("URL"));
		log.info("URL is opened and navigated to the website");
		LandingPage lp = new LandingPage(driver);	
		lp.getLogin().click();
		Loginpage l = new Loginpage(driver);
		l.getEmail().sendKeys(Username);
		l.getPassword().sendKeys(Password);
		System.out.println(text);
		l.getLogin().click();
	}

	@DataProvider
	public Object[][] getData() {

		// Row count tells us how many different types of data types test should run
		// Column count tells us how many values should be passed to each test
		Object[][] data = new Object[2][3];
		data[0][0] = "Nonrestricteduser.com";
		data[0][1] = "1234556";
		data[0][2] = "Text";

		data[1][0] = "Restricteduser.com";
		data[1][1] = "456789";
		data[1][2] = "Texttt";

		return data;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
