package com.erdioran.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.erdioran.objectRepository.HomeOR.*;

public class HomePage extends Page {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);


    public static void enterSearchBar(String text) {
       enterText(SEARCH_BAR, text);
    }

    public static void clickSearch() {
        click(SEARCH_BAR);
    }


    public static WebElement checkSearchResults(String resultText) {
       WebElement resultTextElement= DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='"+resultText+"']"));
       return resultTextElement;
    }

}
