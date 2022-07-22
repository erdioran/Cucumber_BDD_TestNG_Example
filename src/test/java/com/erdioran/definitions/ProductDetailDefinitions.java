package com.erdioran.definitions;

import com.erdioran.base.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import static com.erdioran.base.Common.*;
import static com.erdioran.objectRepository.ProductDetailOR.*;


public class ProductDetailDefinitions {

    WebDriver driver = DriverManager.getDriver();


    private static final Logger LOGGER = LogManager.getLogger(ProductDetailDefinitions.class);


    @When("click {string} product")
    public void click_x_product(String x) throws InterruptedException {
        clickXpath("//body[1]/div[5]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[2]/a[1]/h3[" + x + "]");
        for (String winHandle : DriverManager.getDriver().getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(3000);
        LOGGER.info("user click a X. product");

    }


    @And("click BuyItButton")
    public void click_buy_it_button() {
        click(BUY_IT_NOW_PRODUCT_DETAIL);
        LOGGER.info("click buy it button");

    }


    @Then("sea popup check")
    public void sea_popup_check() {
        Assert.assertTrue(checkVisiblePopup(POPUP_PRODUCT_DETAIL).isDisplayed());
        LOGGER.info("sea popup check");

    }

}
