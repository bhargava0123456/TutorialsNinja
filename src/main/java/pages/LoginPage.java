package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailfield;

	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginbtn;
	
	@FindBy(css = "[class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailtext) {
		emailfield.sendKeys(emailtext);
	}
	
	public void enterPassword(String pass) {
		passwordfield.sendKeys(pass);
	}
	
	public void clickonLOginbtn() {
		loginbtn.click();
	}
	
	public String getWarningMessageText() {
		return warningMessage.getText();
	}
}
