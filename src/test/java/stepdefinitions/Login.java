package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.commonUtils;

public class Login {
	WebDriver driver = DriverFactory.getDriver();
	HomePage hp= new HomePage(driver);
	LoginPage lp= new LoginPage(driver);
	 AccountPage ac= new AccountPage(driver);
	 
	 
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		
	    hp.clickonMyAccount();
	    hp.selectLoginOption();
	    
	}

	@When("^user has entered valid email address (.+) into email field$")
	public void user_has_entered_valid_email_address_into_email_field(String emailtext) {
	  
		lp.enterEmailAddress(emailtext);
		
	}

	@When("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String password) {
		
	    lp.enterPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		LoginPage lp= new LoginPage(driver);
		lp.clickonLOginbtn();
	  
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	   
		Assert.assertTrue(ac.displayStausofEditYourAccountInformationOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	  
		lp.enterEmailAddress(commonUtils.getemailwithtimestamp());
		
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpassword) {
	    
		lp.enterPassword(invalidpassword);
	
	}

	@Then("User should het a proper warning message about credentials mismatch")
	public void user_should_het_a_proper_warning_message_about_credentials_mismatch() {
       Assert.assertTrue(lp.getWarningMessageText().contains("No match for E-Mail Address and/or Password."));
	}

	@When("user enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailtext) {
		
		lp.enterEmailAddress(emailtext);
		
	}

	@When("User don't enter email address into email field")
	public void user_don_t_enter_email_address_into_email_field() {
	  
		lp.enterEmailAddress("");
		
	}

	@When("User don't enter password into password field")
	public void user_don_t_enter_password_into_password_field() {
		
		lp.enterPassword("");
		
	}
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		 Assert.assertTrue(driver.findElement(By.cssSelector("[class='alert alert-danger alert-dismissible']")).getText().contains("No match for E-Mail Address and/or Password."));
	     //Assert.fail();
	}
	

}
