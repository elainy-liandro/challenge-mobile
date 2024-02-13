package org.liandro.elainy.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectHelper extends PageObjectFactory {

    public PageObjectHelper(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    protected void esperarElementoFicarVisivel(WebElement elemento) {
        webDriverWait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.isDisplayed();
    }

    public void clicarNoElementoJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)appiumDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }

}
