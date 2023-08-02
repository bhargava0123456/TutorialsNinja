package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils eu= new ElementUtils(driver);
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropDownmenu;
	
	@FindBy(xpath="//a[text()='Login']")
    private WebElement loginoption;
	
	@FindBy(xpath="(//a[text()='Register'])[1]")
	private WebElement registerOption;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchfield;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchbtn;
	
	
	
	public void clickonMyAccount() {
		myAccountDropDownmenu.click();
		//eu.clickonElement(myAccountDropDownmenu, 10);
	}
	
	public void selectLoginOption() {
		loginoption.click();
		//eu.clickonElement(loginoption, 15);
	}
	
	public void selectRegisterOption() {
		registerOption.click();
		//eu.clickonElement(registerOption, 10);
	}
	
	public void enterproductsearch(String search) {
		
		eu.waitforVisibilityofElement(searchfield, 15);
		searchfield.sendKeys(search);
		//eu.typeTextIntoElement(searchfield, search, 15);
	}
	
	public void clicksearchbtn() {
		searchbtn.click();
	}
}
