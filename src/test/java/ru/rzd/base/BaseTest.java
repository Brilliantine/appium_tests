package ru.rzd.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.rzd.pages.LanguageSelectionPage;
import ru.rzd.pages.MainPage;
import ru.rzd.enums.AgreementAction;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;
    protected MainPage mainPage;

    //Метод проходит по стартовым экранам "онбординга" в дев версии приложения
    protected MainPage completeOnboarding(){
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage(driver);
        languageSelectionPage.selectLanguage("Русский").tapNext()
                .selectEnvironment("master")
                .selectBranch("TEST-RELEASE")
                .tapNext()
                .confirmAgreement(AgreementAction.ACCEPT)
                .confirmKaspersky(AgreementAction.ACCEPT)
                .tapButtonClose();
        return new MainPage(driver);
    }
    @BeforeMethod
    public void setUp() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setAppPackage("ru.rzd.pass.debug")
                .setAppActivity("ru.rzd.pass.presentation.feature.start.SplashActivity")
                .setNoReset(true);

        //ru.rzd.pass.presentation.feature.start.SplashActivity
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        mainPage = completeOnboarding();
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

}
