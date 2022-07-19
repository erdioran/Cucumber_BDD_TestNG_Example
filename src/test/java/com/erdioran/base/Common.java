package com.erdioran.base;

import static com.erdioran.utils.DataManager.getData;

import com.erdioran.utils.Helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class Common extends Page {

    private static final Logger LOGGER = LogManager.getLogger(Common.class);


    public static boolean findUserName() {
        boolean displayed = DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='" + getData("signupLogin.name") + " " + getData("signupLogin.surname") + "']")).isDisplayed();
        return displayed;
    }

    public static boolean checkCssValue(String value, String name) {
        boolean displayed=DriverManager.getDriver().findElement(By.cssSelector("input[placeholder='(___) ___ __ __'][value='"+value+"'][name='"+name+"']")).isDisplayed();
        return displayed;
    }



    public static ArrayList<String> hTagsCheck(String[] footer_test_pages, String[] footer_h1_tags) {
        ArrayList<String> wrongPages=new ArrayList<>();
        for (int i = 0; i < footer_test_pages.length; i++) {
            click(By.linkText(footer_test_pages[i]));

            try {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(DriverManager.getDriver().findElement(getH1(footer_h1_tags[i])).isDisplayed());
            } catch (Exception e) {
                LOGGER.error("H1 tag doesn't match. Page: " + (footer_test_pages[i]));
                wrongPages.add(footer_test_pages[i]);
            }
          //  scrollIntoView(FOOTER);
        }
        return wrongPages;

    }

    public static void enterCredentials(String phone, String password) {
       // enterText(LOGIN_PHONE_NUMBER, phone);
       // enterText(LOGIN_PASSWORD, password);
    }

}
