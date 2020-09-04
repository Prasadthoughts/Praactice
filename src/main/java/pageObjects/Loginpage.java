package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
	public WebDriver driver;
	
	By email=By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[id='user_password']");
	By login=By.cssSelector("input[value='Log In']");
	
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getEmail()
	{
		return  driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}

}
