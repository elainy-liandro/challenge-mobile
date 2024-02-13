package org.liandro.elainy.pages.objects;

import io.appium.java_client.AppiumDriver;
import org.liandro.elainy.pages.PageObjectHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends PageObjectHelper {

    public LoginPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy( className = "login_logo" )
    private WebElement logoPaginaLogin;

    @FindBy( id = "user-name" )
    private WebElement inputUsuario;

    @FindBy( id = "password" )
    private WebElement inputPassword;

    @FindBy( id = "login-button" )
    private WebElement btnLogin;

    //Error handling
    @FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
    private WebElement textoErroUsuarioVazio;

    @FindBy(xpath = "//h3[text()='Epic sadface: Password is required']")
    private WebElement textoErroSenhaVazia;

    @FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
    private WebElement textoErroUsuarioBloqueado;

    public void verificarSeEstouNaPaginaLogin() {
        esperarElementoFicarVisivel(logoPaginaLogin);
    }

    public void preencherInputUsuario(String usuario) {
        inputUsuario.sendKeys(usuario);
    }


    public void preencherInputSenha(String senha) {
        inputPassword.sendKeys(senha);
    }

    public void clicarNoBotaoLogin() {
        btnLogin.click();
    }

    public void verificarSeMsgErroFoiExibida_UsuarioVazio() {
        esperarElementoFicarVisivel(textoErroUsuarioVazio);
    }

    public void verificarSeMsgErroFoiExibida_SenhaVazia() {
        esperarElementoFicarVisivel(textoErroSenhaVazia);
    }

    public void verificarSeMsgErroFoiExibida_UsuarioBloqueado() {
        esperarElementoFicarVisivel(textoErroUsuarioBloqueado);
    }

}