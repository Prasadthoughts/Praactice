package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseTest {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException 
	{
		
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\E2E\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//code to execute chrome driver
			System.setProperty("webdriver.chrome.driver", "E:\\My work\\Drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			//code to execute in firefox 
		}
		else if(browserName.equals("IE"))
		{
			//code to execute in IE
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshots(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}
	
	

}
