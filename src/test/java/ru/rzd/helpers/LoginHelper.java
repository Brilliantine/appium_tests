package ru.rzd.helpers;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import ru.rzd.pages.LoginPage;
import ru.rzd.pages.MainPage;

public class LoginHelper {
    private AppiumDriver driver;

    public LoginHelper(AppiumDriver driver){
        this.driver = driver;
    }
    //Авторизация в приложении
    @Step("Авторизация с логином: {username} и паролем: {password}")
    public MainPage loginAs(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLogin(username)
                .enterPassword(password)
                .tapButtonLogin();
        return new MainPage(driver);
    }
}
