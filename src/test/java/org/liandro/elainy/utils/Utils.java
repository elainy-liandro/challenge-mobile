package org.liandro.elainy.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Utils {

    static IOSDriver iosDriver;
    static WebDriverWait waitDriver;
    protected final static int SHORT_TIMEOUT = 15;
    protected final static int LONG_TIMEOUT = 30;

    public static void startDriver() {

        URL driverUrl;
        try {
            driverUrl = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        XCUITestOptions optionsIos = new XCUITestOptions()
                .setUdid("FD4E7EDE-8BA6-47F0-96C0-6594A634A376")
                .setDeviceName("Simulator iPhone 15")
                .setPlatformName("iOS")
                .withBrowserName("Safari");
        iosDriver = new IOSDriver(driverUrl, optionsIos);
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
        waitDriver = new WebDriverWait(iosDriver, Duration.ofSeconds(LONG_TIMEOUT));
    }

    public static IOSDriver getIosDriver() {
        return iosDriver;
    }

    public static WebDriverWait getWaitDriver() {
        return waitDriver;
    }

    public static void stopApp() {
        iosDriver.quit();
    }

}
