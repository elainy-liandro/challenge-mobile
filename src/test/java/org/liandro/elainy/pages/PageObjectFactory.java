package org.liandro.elainy.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.liandro.elainy.pages.objects.*;
import org.liandro.elainy.utils.Utils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectFactory {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait webDriverWait;

    private LoginPageObject loginPageObject;
    private ProductsPageObejct productsPageObejct;

    private ProductDetailsPageObject productDetailsPageObject;
    private ShoppingCartPageObject shoppingCartPageObject;
    private CheckoutPageObject checkoutPageObject;

    public PageObjectFactory(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        webDriverWait = Utils.getWaitDriver();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
    }

    public LoginPageObject getLoginPageObject() {
        if(this.loginPageObject == null) {
            this.loginPageObject = new LoginPageObject(appiumDriver);
        }
        return loginPageObject;
    }

    public ProductsPageObejct getProductsPageObejct() {
        if(this.productsPageObejct == null) {
            this.productsPageObejct = new ProductsPageObejct(appiumDriver);
        }
        return productsPageObejct;
    }

    public ProductDetailsPageObject getProductDetailsPageObject() {
        if(this.productDetailsPageObject == null) {
            this.productDetailsPageObject = new ProductDetailsPageObject(appiumDriver);
        }
        return productDetailsPageObject;
    }

    public ShoppingCartPageObject getShoppingCartPageObject() {
        if(this.shoppingCartPageObject == null) {
            this.shoppingCartPageObject = new ShoppingCartPageObject(appiumDriver);
        }
        return shoppingCartPageObject;
    }

    public CheckoutPageObject getCheckoutPageObject() {
        if(this.checkoutPageObject == null) {
            this.checkoutPageObject = new CheckoutPageObject(appiumDriver);
        }
        return checkoutPageObject;
    }

}
