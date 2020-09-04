package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	By sigIn=By.xpath("//a[@class='theme-btn register-btn']");
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navBar=By.xpath("//div[@class='right-col pull-right']//a[contains(text(),'Contact')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(sigIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getnavigationBar()
	{
		return driver.findElement(navBar);
	}

}
