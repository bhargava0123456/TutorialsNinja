package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver= driver;
	}
	
	public void clickonElement(WebElement element,long durationInseconds) {
		
		WebElement webelement= waitforElement(element, durationInseconds);
		
		webelement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String text,long durationinseconds) {
		
		WebElement webelement= waitforElement(element, durationinseconds);
		
		webelement.click();
		webelement.clear();
		webelement.sendKeys(text);
	}
	
	public WebElement waitforElement(WebElement element,long duration) {
		
		WebElement webelement = null;
		
		try {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(duration));
		webelement =  wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	public void selectOptionIndropdown(WebElement element,String option,long duration) {
		
		WebElement webelement = waitforElement(element,duration);
		Select sc=new Select(element);
		sc.selectByVisibleText(option);
		
	}
	public void acceptAlert(long duration) {
		
		Alert alert = waitforAlert(duration);
		alert.accept();
	}
	
	public void dismissAlert(long duration) {
			
			Alert alert = waitforAlert(duration);
			alert.dismiss();
		}
	
	public Alert waitforAlert(long duration) {
		
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		 alert= wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mousehoverAndClick(WebElement element,long duration) {
		
		
		WebElement webelement = waitforVisibilityofElement(element, duration);
		
		Actions act = new Actions(driver);
		act.moveToElement(webelement).click().build().perform();
	}
	
	public WebElement waitforVisibilityofElement(WebElement element , long durationofseconds) {
		
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationofseconds));
			webelement= wait.until(ExpectedConditions.visibilityOf(element));
			
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		return webelement;
	}
	
	public void jacaScriptClick(WebElement element,long durationofseconds) {
		
		WebElement webelement = waitforVisibilityofElement(element, durationofseconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",webelement);
	}
	
	public void javascriptType(WebElement element,long duration,String texttotype) {
		
		WebElement webelement = waitforVisibilityofElement(element, duration);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+texttotype+"'",webelement);
	}
	
}
