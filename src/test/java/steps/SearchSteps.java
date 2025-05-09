package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.HomePage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import static utils.DriverFactory.*;

public class SearchSteps {

    WebDriver driver;
    HomePage homePage;
    
    public SearchSteps(TestContext context) {
        this.driver = context.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Given("I am on the Amazon homepage")
    public void i_am_on_the_amazon_homepage() {
        homePage.goToHomePage();
    }

    @When("I type {string} in the search bar")
    public void i_type_in_the_search_bar(String word) {
        homePage.typeInSearchBox(word);
    }

    @Then("I should see autocomplete suggestions")
    public void i_should_see_autocomplete_suggestions() {
        Assertions.assertTrue(homePage.suggestionsIsVisible());
    }
    
    @Then("I should not see autocomplete suggestions")
    public void i_should_not_see_autocomplete_suggestions() {
    	Assertions.assertTrue(homePage.suggestionsIsNotVisible());
    }
    
    @When("I maximize browser")
    public void i_maximize_browser() {
    	homePage.maximizeBrowser();
    }
    
    @Then("I should see many items on menu")
    public void i_should_see_many_items_on_menu() {
    	Assertions.assertTrue(homePage.menuItemsSize() > 10);
    }
    
    @When("I put browser in a mobile resolution")
    public void i_put_browser_in_a_mobile_resolution() {
    	homePage.setBrowserDimension();
    }
    
    @Then("I should be able to use burger menu")
    public void i_should_be_able_to_use_burger_menu() {
    	Assertions.assertTrue(homePage.burgerMenuIsWorking());
    }
    
    @When("I open burger menu")
    public void i_open_burger_menu() {
    	homePage.clickOnBurgerMenu();
    }
    
    @When("I click on Novidades na Amazon on menu")
    public void i_click_on_amazon_new_releases_on_menu() {
    	homePage.clickOnNewReleasesBurgerMenu();
    }
    
    @Then("I should be redirected to Amazon new releases")
    public void i_should_be_redirected_to_amazon_new_releases() {
    	Assertions.assertTrue(homePage.urlContainsNewReleases());
    }
    
    @Then("loading time should be lass than {long}")
    public void loading_time_should_be_lass_than(long maximumLoadingTime) {
    	Assertions.assertTrue(homePage.getLoadingTime() < maximumLoadingTime);
    }
}
