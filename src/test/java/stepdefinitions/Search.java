package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;
import utils.ElementUtils;

public class Search {

	WebDriver driver;
	HomePage hp= new HomePage(driver);
	SearchResultPage  s= new SearchResultPage(driver);
	ElementUtils eu= new ElementUtils(driver);
	
	@Given("User opens application")
	public void user_opens_application() {
		
		driver= DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validproduct) throws Exception {
	   
		hp.enterproductsearch(validproduct);
		
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		hp.clicksearchbtn();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(s.displayStatusofvalidproduct());
	}


	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
		
		hp.enterproductsearch(invalidproduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	  Assert.assertEquals("There is no product that matches the search criteria.",s.Noproductmatchwarningmsg());
	}


	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	   //intentially blank
	}

	
}
