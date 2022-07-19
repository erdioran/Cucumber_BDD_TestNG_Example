package com.erdioran.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.BaseTest;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.erdioran.base.Common.*;

import static com.erdioran.utils.DataManager.getData;

public class SearchBarTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        ExtentTest test = ExtentTestManager.getNode();
        test.assignCategory("Login Page");
    }


    @Test(description = "...", priority = 1)
    public void test1(ITestContext context) {



    }


}
