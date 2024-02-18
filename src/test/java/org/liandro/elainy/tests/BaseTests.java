package org.liandro.elainy.tests;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectFactory;
import org.liandro.elainy.pages.objects.*;
import org.liandro.elainy.utils.Utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class BaseTests {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait webDriverWait;

    protected PageObjectFactory pageObjectFactory;
    protected LoginPageObject loginPageObject;
    protected ProductsPageObejct productsPageObejct;
    protected ProductDetailsPageObject productDetailsPageObject;
    protected ShoppingCartPageObject shoppingCartPageObject;
    protected CheckoutPageObject checkoutPageObject;

    public BaseTests() {
        Utils.startDriver();
        appiumDriver = Utils.getDriver();
        webDriverWait = Utils.getWaitDriver();
        this.pageObjectFactory = new PageObjectFactory(appiumDriver);
        this.loginPageObject = pageObjectFactory.getLoginPageObject();
        this.productsPageObejct = pageObjectFactory.getProductsPageObejct();
        this.productDetailsPageObject = pageObjectFactory.getProductDetailsPageObject();
        this.shoppingCartPageObject = pageObjectFactory.getShoppingCartPageObject();
        this.checkoutPageObject = pageObjectFactory.getCheckoutPageObject();
    }

    @BeforeMethod
    public void goTo() {
        appiumDriver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void screenshot() {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        String so = appiumDriver.getCapabilities().getPlatformName().toString();
        String timeNowFormatado = timeNow.toString();
        timeNowFormatado = timeNowFormatado.replace(":", ".").replace(" ", "_");
        try {
            File evidence = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.moveFile(evidence, new File("target/screenshots/" + so + "_screenshot_" + timeNowFormatado + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void tearDown() {
        Utils.stopApp();
    }

}