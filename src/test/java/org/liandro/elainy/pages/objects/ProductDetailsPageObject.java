package org.liandro.elainy.pages.objects;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageObject extends PageObjectHelper {

    public ProductDetailsPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy( id = "back-to-products" )
    private WebElement btnPaginaDetalhesProduto;

    @FindBy( xpath = "//button[text()='Add to cart']" )
    private WebElement btnAdicionarAoCarrinho;

    @FindBy( xpath = "//span[@class='shopping_cart_badge'][text()='1']" )
    private WebElement btnIrAoCarrinho;

    public void verificarSeEstouNaPaginaDetalhesProduto() {
        esperarElementoFicarVisivel(btnPaginaDetalhesProduto);
    }

    public void clicarNoBtnAdicionarAoCarrinho() {
        clicarNoElementoJS(btnAdicionarAoCarrinho);
    }

    public void clicarNoBtnIrAoCarrinho() {
        esperarElementoFicarVisivel(btnIrAoCarrinho);
        btnIrAoCarrinho.click();
    }

}
