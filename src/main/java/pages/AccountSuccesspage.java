package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesspage {

	
	WebDriver driver;
	
	public AccountSuccesspage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement successfulmsg;
	
	public String accsuccessfulmsgtext() {
		return successfulmsg.getText();
	}

	
}
