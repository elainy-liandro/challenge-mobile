package org.liandro.elainy.tests;

import org.testng.annotations.*;

public class LoginTests extends BaseTests {

    @Test(testName = "CT001 [Login] - Login com Sucesso", priority = 1)
    @Parameters({"usuario","senha"})
    public void Login(String usuario, String senha) {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario(usuario);
        loginPageObject.preencherInputSenha(senha);
        loginPageObject.clicarNoBotaoLogin();
        productsPageObejct.verificarSeEstouNaPaginaProdutos();
    }

    @Test(testName = "CT002 [Login] - Login com falha - Campo usuário vazio", priority = 2)
    public void LoginFail_UsuarioVazio() {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_UsuarioVazio();
    }

    @Test(testName = "CT003 [Login] - Login com falha - Campo senha vazio", priority = 3)
    @Parameters({"usuario"})
    public void LoginFail_SenhaVazia(String usuario) {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario(usuario);
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_SenhaVazia();
    }

    @Test(testName = "CT004 [Login] - Login com falha - Usuário bloqueado", priority = 4)
    @Parameters({"usuario","senha"})
    public void LoginFail_UsuarioBloqueado(String usuario, String senha) {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario(usuario);
        loginPageObject.preencherInputSenha(senha);
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_UsuarioBloqueado();
    }

    @Test(testName = "CT005 [Login] - Login com falha - Usuário inválido", priority = 5)
    @Parameters({"usuario","senha"})
    public void LoginFail_UsuarioInvalido(String usuario, String senha) {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario(usuario);
        loginPageObject.preencherInputSenha(senha);
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_UsuarioOuSenhaInvalidos();
    }

    @Test(testName = "CT006 [Login] - Login com falha - Senha inválida", priority = 6)
    @Parameters({"usuario","senha"})
    public void LoginFail_SenhaInvalida(String usuario, String senha) {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario(usuario);
        loginPageObject.preencherInputSenha(senha);
        loginPageObject.clicarNoBotaoLogin();
        loginPageObject.verificarSeMsgErroFoiExibida_UsuarioOuSenhaInvalidos();
    }

}
