package com.erdioran.runner;

import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.ConfigManager;
import com.erdioran.utils.ExtentTestManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.lang.reflect.Method;

@CucumberOptions(
        features = "src/test/resources/features/searchbar.feature",
        glue = "com.erdioran.definitions",
        monochrome = true)

public class SearchBarRunner extends AbstractTestNGCucumberTests {


    private static final Logger LOGGER = LogManager.getLogger(SearchBarRunner.class);


    @BeforeTest(alwaysRun = true)
    public void startBrowserAndLogin(Method method, ITestResult result, ITestContext context) {

        ThreadContext.put("testName", method.getName());
        LOGGER.info("Executing test method : [{}] in class [{}]", result.getMethod().getMethodName(),
                result.getTestClass().getName());
        String nodeName =
                StringUtils.isNotBlank(result.getMethod().getDescription()) ? result.getMethod().getDescription() : method.getName();
        ExtentTest node = ExtentTestManager.getTest().createNode(nodeName);
        ExtentTestManager.setNode(node);
        ExtentTestManager.info("Test Started");
        String status = (String) context.getAttribute("previousTestStatus");
        boolean isNewBrowserPerTest = Boolean.parseBoolean(ConfigManager.getConfigProperty("new.browser.per.test"));
        boolean isCleanUpTest = context.getName().contains("Clean");
        if (!isNewBrowserPerTest) {
            if (status == null || status.equalsIgnoreCase("failed")) {
                LOGGER.info("Launching fresh browser");
                DriverManager.launchBrowser(ConfigManager.getBrowser());
            } else {
                LOGGER.info("Skip log in");
            }
        } else if (isCleanUpTest) {
            LOGGER.info("Clean up test. Skip log in");
        } else {
            DriverManager.launchBrowser(ConfigManager.getBrowser());
        }
    }

    @AfterTest(alwaysRun = true)
    public void CloseBrowser(ITestResult result, ITestContext context) {
        if (!result.isSuccess()) {
            context.setAttribute("previousTestStatus", "failed");
        } else {
            context.setAttribute("previousTestStatus", "passed");
        }
        //   boolean isNewBrowserPerTest = Boolean.parseBoolean(ConfigManager.getConfigProperty("new.browser.per.test"));
        //   boolean isCleanUpTest = context.getName().contains("Clean");

        DriverManager.quitDriver();

    }


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        DriverManager.quitDriver();
    }

}
