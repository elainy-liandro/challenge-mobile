package org.liandro.elainy.pages.objects;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageObject extends PageObjectHelper {

    public ShoppingCartPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy( xpath = "//span[text()='Your Cart']" )
    private WebElement textoPaginaCarrinho;

    @FindBy( id = "checkout" )
    private WebElement btnCheckout;

    public void verificarSeEstouNaPaginaCarrinho() {
        esperarElementoFicarVisivel(textoPaginaCarrinho);
    }

    public void clicarNoBtnCheckout() {
        btnCheckout.click();
    }

}
