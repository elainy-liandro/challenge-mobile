package org.liandro.elainy.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderTests extends BaseTests {

    public void passosIniciais(String usuario, String senha) {
        loginPageObject.verificarSeEstouNaPaginaLogin();
        loginPageObject.preencherInputUsuario(usuario);
        loginPageObject.preencherInputSenha(senha);
        loginPageObject.clicarNoBotaoLogin();
        productsPageObejct.verificarSeEstouNaPaginaProdutos();
        productsPageObejct.resetarEstadoDoApp();
    }

    public void passosIntermediarios() {
        productsPageObejct.verificarSeItemMochilaExibido();
        productsPageObejct.clicarNoItemMochila();
        productDetailsPageObject.verificarSeEstouNaPaginaDetalhesProduto();
        productDetailsPageObject.clicarNoBtnAdicionarAoCarrinho();
        productDetailsPageObject.clicarNoBtnIrAoCarrinho();
        shoppingCartPageObject.verificarSeEstouNaPaginaCarrinho();
        productsPageObejct.verificarSeItemMochilaExibido();
        shoppingCartPageObject.clicarNoBtnCheckout();
        checkoutPageObject.verificarSeEstouNaPaginaCheckoutSuaInformacao();
    }

    @Test(testName = "CT001 [Order] - Realizando pedido com sucesso", priority = 1)
    @Parameters({"usuario","senha"})
    public void realizarPedido(String usuario, String senha) {
        passosIniciais(usuario, senha);
        passosIntermediarios();
        checkoutPageObject.preencherInputNome("Elainy");
        checkoutPageObject.preencherInputSobrenome("Liandro");
        checkoutPageObject.preencherInputPostalCode("2825-405");
        checkoutPageObject.clicarNoBtnContinuar();
        checkoutPageObject.verificarSeEstouNaPaginaCheckoutVisaoGeral();
        productsPageObejct.verificarSeItemMochilaExibido();
        checkoutPageObject.clicarNoBtnFinalizar();
        checkoutPageObject.verificarSeEstouNaPaginaCheckoutFinalizado();
    }

    @Test(testName = "CT002 [Order] - Realizando pedido com sucesso utilizando filtro", priority = 2)
    @Parameters({"usuario","senha"})
    public void realizarPedidoUtilizandoFiltro(String usuario, String senha) {
        passosIniciais(usuario, senha);
        productsPageObejct.selecionarUmTipoDeFiltro();
        productsPageObejct.clicarEmItemAleatorio();
        productDetailsPageObject.verificarSeEstouNaPaginaDetalhesProduto();
        productDetailsPageObject.clicarNoBtnAdicionarAoCarrinho();
        productDetailsPageObject.clicarNoBtnIrAoCarrinho();
        shoppingCartPageObject.verificarSeEstouNaPaginaCarrinho();
        shoppingCartPageObject.clicarNoBtnCheckout();
        checkoutPageObject.verificarSeEstouNaPaginaCheckoutSuaInformacao();
        checkoutPageObject.preencherInputNome("Elainy");
        checkoutPageObject.preencherInputSobrenome("Liandro");
        checkoutPageObject.preencherInputPostalCode("2825-405");
        checkoutPageObject.clicarNoBtnContinuar();
        checkoutPageObject.verificarSeEstouNaPaginaCheckoutVisaoGeral();
        checkoutPageObject.clicarNoBtnFinalizar();
        checkoutPageObject.verificarSeEstouNaPaginaCheckoutFinalizado();
    }

    @Test(testName = "CT003 [Order] - Realizando pedido com falha - Nome vazio", priority = 3)
    @Parameters({"usuario","senha"})
    public void realizarPedidoFail_NomeVazio(String usuario, String senha) {
        passosIniciais(usuario, senha);
        passosIntermediarios();
        checkoutPageObject.preencherInputNome("");
        checkoutPageObject.preencherInputSobrenome("Liandro");
        checkoutPageObject.preencherInputPostalCode("2825-405");
        checkoutPageObject.clicarNoBtnContinuar();
        checkoutPageObject.verificarSeMsgErroFoiExibida_NomeVazio();
    }

    @Test(testName = "CT004 [Order] - Realizando pedido com falha - Sobrenome vazio", priority = 4)
    @Parameters({"usuario","senha"})
    public void realizarPedidoFail_SobrenomeVazio(String usuario, String senha) {
        passosIniciais(usuario, senha);
        passosIntermediarios();
        checkoutPageObject.preencherInputNome("Elainy");
        checkoutPageObject.preencherInputSobrenome("");
        checkoutPageObject.preencherInputPostalCode("2825-405");
        checkoutPageObject.clicarNoBtnContinuar();
        checkoutPageObject.verificarSeMsgErroFoiExibida_SobrenomeVazio();
    }

    @Test(testName = "CT005 [Order] - Realizando pedido com falha - Postal Code vazio", priority = 5)
    @Parameters({"usuario","senha"})
    public void realizarPedidoFail_PostalCodeVazio(String usuario, String senha) {
        passosIniciais(usuario, senha);
        passosIntermediarios();
        checkoutPageObject.preencherInputNome("Elainy");
        checkoutPageObject.preencherInputSobrenome("Liandro");
        checkoutPageObject.preencherInputPostalCode("");
        checkoutPageObject.clicarNoBtnContinuar();
        checkoutPageObject.verificarSeMsgErroFoiExibida_PostalCodeVazio();
    }

}
