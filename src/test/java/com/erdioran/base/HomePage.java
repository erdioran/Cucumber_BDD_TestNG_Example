package com.erdioran.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static com.erdioran.objectRepository.HomeOR.*;
import static com.erdioran.utils.DataManager.getData;

public class HomePage extends Page {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);


    public static void enterSearchBar(String text) {
       enterText(SEARCH_BAR, text);
    }

    public static void clickSearch() {
        click(SEARCH_BAR);
    }

}
