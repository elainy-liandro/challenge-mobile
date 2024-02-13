package org.liandro.elainy.tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    public LoginTests() {
    }

    @Test(testName = "CT001 - Login com Sucesso", priority = 1)
    public void Login() {
//        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario("standard_user");
        loginPageObject.preencherInputSenha("secret_sauce");
        loginPageObject.clicarNoBotaoLogin();
    }

    @Test(testName = "CT002 - Login com falha - Campo usuário vazio", priority = 2)
    public void LoginFail_UsuarioVazio() {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_UsuarioVazio();
    }

    @Test(testName = "CT003 - Login com falha - Campo senha vazio", priority = 3)
    public void LoginFail_SenhaVazia() {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario("standard_user");
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_SenhaVazia();
    }

    @Test(testName = "CT004 - Login com falha - Usuário bloqueado", priority = 4)
    public void LoginFail_UsuarioBloqueado() {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario("locked_out_user");
        loginPageObject.preencherInputSenha("secret_sauce");
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_UsuarioBloqueado();
    }

}
