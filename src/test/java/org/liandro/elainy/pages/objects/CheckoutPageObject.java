package org.liandro.elainy.pages.objects;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageObject extends PageObjectHelper {

    public CheckoutPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    //Checkout: Your Information
    @FindBy( xpath = "//span[text()='Checkout: Your Information']" )
    private WebElement textoPaginaCheckoutSuaInformacao;

    @FindBy( id = "first-name" )
    private WebElement inputNome;

    @FindBy( id = "last-name" )
    private WebElement inputSobrenome;

    @FindBy( id = "postal-code" )
    private WebElement inputPostalCode;

    @FindBy( id = "continue" )
    private WebElement btnContinuar;

    //Checkout: Overview
    @FindBy( xpath = "//span[text()='Checkout: Overview']" )
    private WebElement textoPaginaCheckoutVisaoGeral;

    @FindBy( id = "finish" )
    private WebElement btnFinalizar;

    //Checkout: Complete
    @FindBy( xpath = "//span[text()='Checkout: Complete!']" )
    private WebElement textoPaginaCheckoutFinalizado;

    @FindBy( xpath = "//h2[text()='Thank you for your order!']" )
    private WebElement textoObrigadoPeloSeuPedido;

    //Error handling
    @FindBy(xpath = "//h3[text()='Error: First Name is required']")
    private WebElement textoErroNomeVazio;

    @FindBy(xpath = "//h3[text()='Error: Last Name is required']")
    private WebElement textoErroSobrenomeVazio;

    @FindBy(xpath = "//h3[text()='Error: Postal Code is required']")
    private WebElement textoErroPostalCodeVazio;

    public void verificarSeEstouNaPaginaCheckoutSuaInformacao() {
        esperarElementoFicarVisivel(textoPaginaCheckoutSuaInformacao);
    }

    public void preencherInputNome(String nome) {
        inputNome.sendKeys(nome);
    }

    public void preencherInputSobrenome(String sobrenome) {
        inputSobrenome.sendKeys(sobrenome);
    }

    public void preencherInputPostalCode(String postalcode) {
        inputPostalCode.sendKeys(postalcode);
    }

    public void clicarNoBtnContinuar() {
        btnContinuar.click();
    }

    public void verificarSeEstouNaPaginaCheckoutVisaoGeral() {
        esperarElementoFicarVisivel(textoPaginaCheckoutVisaoGeral);
    }

    public void clicarNoBtnFinalizar() {
        btnFinalizar.click();
    }

    public void verificarSeEstouNaPaginaCheckoutFinalizado() {
        esperarElementoFicarVisivel(textoPaginaCheckoutFinalizado);
        textoObrigadoPeloSeuPedido.isDisplayed();
    }

    public void verificarSeMsgErroFoiExibida_NomeVazio() {
        esperarElementoFicarVisivel(textoErroNomeVazio);
    }

    public void verificarSeMsgErroFoiExibida_SobrenomeVazio() {
        esperarElementoFicarVisivel(textoErroSobrenomeVazio);
    }

    public void verificarSeMsgErroFoiExibida_PostalCodeVazio() {
        esperarElementoFicarVisivel(textoErroPostalCodeVazio);
    }

}
