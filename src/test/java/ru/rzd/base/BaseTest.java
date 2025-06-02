package ru.rzd.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setAppPackage("ru.rzd.pass.debug")
                .setAppActivity("ru.rzd.app.common.gui.MainActivity")
                .setNoReset(true);

        //ru.rzd.pass.presentation.feature.start.SplashActivity

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
    }

    @AfterClass
    public void teraDown(){
        if (driver!=null){
            driver.quit();
        }
    }

}
