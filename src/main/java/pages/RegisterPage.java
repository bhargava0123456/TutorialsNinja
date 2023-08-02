package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword;
	
	@FindBy(css="[name='agree']")
	private WebElement privacypolicy;
	
	@FindBy(css="[value='Continue']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameFieldwarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnamewarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephonewarning;
	
	@FindBy(xpath="input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarning;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsletteryesbtn;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicatewarning;
	
	
	public void enterFirstName(String firstNametext) {
		
		firstNameField.sendKeys(firstNametext);
		
	}
    
	public void enterLastName(String lastName) {
		
		lastname.sendKeys(lastName);
		
	}
	
	public void enteremail(String eamiltext) {	
		lastname.sendKeys(eamiltext);
	}
	
	public void entertelephone(String phone) {
		telephone.sendKeys(phone);
	}
	
	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterconfirmpassword(String confmpass) {
		confirmpassword.sendKeys(confmpass);
	}
	
	public void clickonprivacy() {
		privacypolicy.click();
	}
	
	public void clickoncontinue() {
		continuebtn.click();
	}
	
	
	
	public void clickonnewsletterbtn() {
		newsletteryesbtn.click();
	}
	
	public String warningmsg() {
		
		return duplicatewarning.getText();
		
	}
	
	public String getFirstnamewarning() {
		
			return firstNameFieldwarning.getText();
		}
		
	public String getlastnamewarning() {
		
		return lastnamewarning.getText();
			
		}
	
	public String getemailwarning() {
		
		return emailwarning.getText();
	}
	
	public String gettelephonewarning() {
		
		return telephonewarning.getText();
	}
	
	public String getpasswordwarning() {
		
		return passwordwarning.getText();
	}
	
}
