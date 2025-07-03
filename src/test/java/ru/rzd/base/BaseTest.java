package ru.rzd.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import ru.rzd.helpers.ConfigReader;
import ru.rzd.pages.*;
import ru.rzd.enums.AgreementAction;
import ru.rzd.helpers.OnboardingHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import ru.rzd.permission.PermissionManager;

public class BaseTest {
    protected AppiumDriver driver;

    //PageObjects
    protected LanguageSelectionPage languageSelectionPage;
    protected EnvironmentSelectionPage environmentSelectionPage;
    protected AgreementPage agreementPage;
    protected AgreementKasperskyPage agreementKasperskyPage;
    protected TutorialPage tutorialPage;
    protected LoginPage loginPage;
    protected MainPage mainPage;

    //Контейнер для хранения уникального driver для каждого потока
    private static ThreadLocal<BaseTest> instance = new ThreadLocal<>();

    //При каждом создании класса-наследника кладется текущий экземпляр в контейнер ThreadLocal.
    // Это позволяет из любого потока получить свой уникальный driver
    public BaseTest(){
        instance.set(this);
    }

    //Возвращает BaseTest для текущего потока
    public static BaseTest getInstance(){
        return instance.get();
    }

    //Позволяет всем классам-наследникам использовать готовый драйвер
    public AppiumDriver getDriver(){
        return driver;
    }

    @Parameters({"udid","port"})
    @BeforeClass
    public void setUp(String udid, String port) throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ConfigReader.get("platformName"))
                .setDeviceName(udid) // ← используем параметр udid
                .setUdid(udid)       // ← критично для правильного подключения к устройству
                .setAppPackage(ConfigReader.get("appPackage"))
                .setAppActivity(ConfigReader.get("appActivity"))
                .setNoReset(false);
        System.out.println("Создаём драйвер для udid: " + udid + " на порту: " + port);

        driver = new AndroidDriver(new URL("http://127.0.0.1:"+port),options);
        PermissionManager.grantNotificationPermission();
        new OnboardingHelper(driver).completeIfPresents(); //Проходим онбординг
        mainPage = new MainPage(driver);

    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

}
