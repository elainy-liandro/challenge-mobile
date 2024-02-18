package org.liandro.elainy.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileBrowserType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Utils {

    protected static AndroidDriver androidDriver;
    protected static IOSDriver iosDriver;
    protected static WebDriverWait waitDriver;
    protected final static int SHORT_TIMEOUT = 15;
    protected final static int LONG_TIMEOUT = 30;

    protected static String platform;

    public static void startDriver() {

        platform = "android".toUpperCase();

        URL driverUrl;
        try {
            driverUrl = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        switch (platform) {
            case "ANDROID":
                UiAutomator2Options optionsAndroid = new UiAutomator2Options()
                        .setUdid("emulator-5554")
                        .setDeviceName("Pixel")
                        .setPlatformName(Platform.ANDROID.toString())
                        .withBrowserName(MobileBrowserType.CHROME);
                optionsAndroid.setCapability("appium:nativeWebScreenshot", true);
                androidDriver = new AndroidDriver(driverUrl, optionsAndroid);
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
                waitDriver = new WebDriverWait(androidDriver, Duration.ofSeconds(LONG_TIMEOUT));
                break;
            case "IOS":
                XCUITestOptions optionsIos = new XCUITestOptions()
                        .setUdid("FD4E7EDE-8BA6-47F0-96C0-6594A634A376")
                        .setDeviceName("Simulator iPhone 15")
                        .setPlatformName(Platform.IOS.toString())
                        .withBrowserName(Browser.SAFARI.browserName());
                iosDriver = new IOSDriver(driverUrl, optionsIos);
                iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
                waitDriver = new WebDriverWait(iosDriver, Duration.ofSeconds(LONG_TIMEOUT));
                break;
            default:
                throw new RuntimeException("Platform not supported: " + platform);
        }

    }

    public static AppiumDriver getDriver() {
        if (androidDriver != null) {
            return androidDriver;
        }
        if (iosDriver != null) {
            return iosDriver;
        }
        throw new RuntimeException("You must call Utils.startDriver() before using the driver");
    }

    public static WebDriverWait getWaitDriver() {
        if (androidDriver != null || iosDriver != null) {
            return waitDriver;
        }
        throw new RuntimeException("You must call Utils.startDriver() before using the waitDriver");
    }

    public static void stopApp() {
        if (androidDriver != null) {
            androidDriver.quit();
        }
        if (iosDriver != null) {
            iosDriver.quit();
        }
    }

}
