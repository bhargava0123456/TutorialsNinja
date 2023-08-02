package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccesspage;
import pages.HomePage;
import pages.RegisterPage;
import utils.commonUtils;


public class Register {

	WebDriver driver= DriverFactory.getDriver();
	HomePage hp= new HomePage(driver);
	RegisterPage rp= new RegisterPage(driver);
	AccountSuccesspage as= new AccountSuccesspage(driver);
	
	@When("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	   
		hp.clickonMyAccount();
		hp.selectRegisterOption();
	    
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	   
	Map<String,String>	dataMap = dataTable.asMap(String.class, String.class);
		
	rp.enterFirstName(dataMap.get("firstName"));
	rp.enterLastName(dataMap.get("lastName"));
	rp.enteremail(commonUtils.getemailwithtimestamp());
	rp.entertelephone(dataMap.get("telephone"));
	rp.enterpassword(dataMap.get("Password"));
	rp.enterconfirmpassword(dataMap.get("Password"));
	
	
	}

	@When("User selects privacy polocy")
	public void user_selects_privacy_polocy() {
		
		rp.clickonprivacy();
		
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	   
		rp.clickoncontinue();
	}

	@Then("User account should get created sucessfully")
	public void user_account_should_get_created_sucessfully() {
	   Assert.assertEquals("Your Account Has Been Created",as.accsuccessfulmsgtext());
	}

	@When("User selects yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	 
		rp.clickonnewsletterbtn();
		
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	  
		Assert.assertTrue(as.accsuccessfulmsgtext().contains(" E-Mail Address is already registered!"));
	}


	@When("User don't enter any details into fields")
	public void user_don_t_enter_any_details_into_fields() {
	   
		//intentionally kept blank
	}

	

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	   
		Assert.assertTrue(rp.warningmsg().contains("You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",rp.getFirstnamewarning());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",rp.getlastnamewarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",rp.getemailwarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",rp.gettelephonewarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",rp.getpasswordwarning());
		
	}
	

}
