package com.erdioran.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.erdioran.objectRepository.HomeOR.*;
import static com.erdioran.objectRepository.ProductDetailOR.*;

public class Common extends Page {

    private static final Logger LOGGER = LogManager.getLogger(Common.class);
    static WebDriver driver = DriverManager.getDriver();

    public static void enterSearchBar(String text) {
       enterText(SEARCH_BAR, text);
    }

    public static void clickSearch() {
        click(SEARCH_BUTTON);
    }


    public static WebElement checkSearchResults(String resultText) {
        return driver.findElement(By.xpath("//span[normalize-space()='"+resultText+"']"));

    }

    public static WebElement checkVisiblePopup(String popupId) {
        return driver.findElement(By.id(popupId));

    }

    public static void enterPiecesOfOrder(String pieces) {
        enterText(PIECES_OF_ORDER, pieces);
    }

    public static WebElement checkVisibleError(String errorId) {
        return driver.findElement(By.id(errorId));

    }


}
