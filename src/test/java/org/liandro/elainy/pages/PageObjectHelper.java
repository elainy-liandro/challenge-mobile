package org.liandro.elainy.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectHelper extends PageObjectFactory {

    public PageObjectHelper(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void esperarElementoFicarVisivel(WebElement elemento) {
        webDriverWait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.isDisplayed();
    }

}
