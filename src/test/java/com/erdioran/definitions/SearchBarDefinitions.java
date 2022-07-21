package com.erdioran.definitions;

import com.erdioran.base.DriverManager;
import com.erdioran.base.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.erdioran.utils.DataManager.getData;
import static com.erdioran.base.HomePage.*;
public class SearchBarDefinitions  {

    WebDriver driver = DriverManager.getDriver();


    private static final Logger LOGGER = LogManager.getLogger(SearchBarDefinitions.class);

    @Given("user is on ebay.com page")
    public void user_is_on_ebay_home_page() {
        driver.get(getData("common.url"));
        LOGGER.info("user is on ebay.com page");

    }

    @When("user enters (.*) in searchbar box")
    public void user_enters_a_text_in_searchbox(String text) {
        enterSearchBar(text);
        LOGGER.info("user enters a text in search box");

    }

    @And("click search")
    public void click_search() {

        clickSearch();
        LOGGER.info("click search");

    }

    @Then("user is navigated to (.*) search results")
    public void user_is_navigated_to_search_results(String resulstText) {
        Assert.assertTrue(checkSearchResults(resulstText).isDisplayed());
        LOGGER.info("user is navigated to search results");

    }

}
