package org.liandro.elainy.pages.objects;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ProductsPageObejct extends PageObjectHelper {

    public ProductsPageObejct(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy( xpath = "//span[text()='Products']" )
    private WebElement textoPaginaProdutos;

    @FindBy( xpath = "//div[text()='Sauce Labs Backpack']" )
    private WebElement itemMochilaSauceLabs;

    @FindBy( className = "product_sort_container" )
    private WebElement selectFiltro;

    @FindBy( id = "react-burger-menu-btn" )
    private WebElement menuHamburger;

    @FindBy( id = "reset_sidebar_link" )
    private WebElement btnResetarEstadoApp;

    @FindBy ( id = "react-burger-cross-btn" )
    private WebElement btnFecharMenuHamburger;

    public void verificarSeEstouNaPaginaProdutos() {
        esperarElementoFicarVisivel(textoPaginaProdutos);
    }

    public void clicarNoItemMochila() {
        itemMochilaSauceLabs.click();
    }

    public void clicarEmItemAleatorio() {
        esperarElementoFicarVisivel(appiumDriver.findElement(By.className("inventory_item_name")));
        appiumDriver.findElement(By.className("inventory_item_name")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verificarSeItemMochilaExibido() {
        esperarElementoFicarVisivel(itemMochilaSauceLabs);
    }

    public void selecionarUmTipoDeFiltro() {
        Random random = new Random();
        int indexRandom = random.nextInt(4);
        Select select = new Select(selectFiltro);
        select.selectByIndex(indexRandom);
    }

    public void resetarEstadoDoApp() {
        clicarNoElementoJS(menuHamburger);
        clicarNoElementoJS(btnResetarEstadoApp);
        clicarNoElementoJS(btnFecharMenuHamburger);
    }

}
