package org.liandro.elainy.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.liandro.elainy.pages.objects.LoginPageObject;
import org.liandro.elainy.utils.Utils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectFactory {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait webDriverWait;
    protected LoginPageObject loginPageObject;

    public PageObjectFactory(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        webDriverWait = Utils.getWaitDriver();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
    }

    public LoginPageObject getLoginPageObject() {
        if(loginPageObject == null) {
            loginPageObject = new LoginPageObject(appiumDriver);
        }
        return loginPageObject;
    }
}
