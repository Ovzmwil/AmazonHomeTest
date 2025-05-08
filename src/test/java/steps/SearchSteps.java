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
    
    @Before
    public void setUp() {
    	driver = getDriver();
    	homePage = new HomePage(driver);
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
    
    @After
    public void tearDown() {
    	quitDriver();
    }
}
