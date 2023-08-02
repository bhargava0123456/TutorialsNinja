package factory;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory {

	static WebDriver driver;
	public static WebDriver initializeBrowser(String browserName) throws IOException {
		
		Properties prop=ConfigReader.initiazeproperties();
		
		if(browserName.equals("chrome")) {
			
		     WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();

			
		}else if (browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
}
