package org.liandro.elainy.tests;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectFactory;
import org.liandro.elainy.pages.objects.LoginPageObject;
import org.liandro.elainy.utils.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTests {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait webDriverWait;

    protected PageObjectFactory pageObjectFactory;
    protected LoginPageObject loginPageObject;

    public BaseTests() {
        Utils.startDriver();
        appiumDriver = Utils.getIosDriver();
        webDriverWait = Utils.getWaitDriver();
        this.pageObjectFactory = new PageObjectFactory(appiumDriver);
        this.loginPageObject = pageObjectFactory.getLoginPageObject();
    }

    @BeforeMethod
    public void goTo() {
        appiumDriver.get("https://www.saucedemo.com/");
    }

    @AfterSuite
    public static void tearDown() {
        Utils.stopApp();
    }

}
