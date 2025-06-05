package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private AppiumDriver driver;

    //Локаторы
    private By title = By.id("ru.rzd.pass.debug:id/header");
    private By loginInput = By.id("ru.rzd.pass.debug:id/login");
    private By passwordInput = By.id("ru.rzd.pass.debug:id/password");
    private By buttonLogin = By.id("ru.rzd.pass.debug:id/avatar");
    private By buttonResetPassword = By.id("ru.rzd.pass.debug:id/recovery_login_btn");
    private By termsOffer = By.id("ru.rzd.pass.debug:id/offerta");
    private By buttonRegistration = By.id("ru.rzd.pass.debug:id/btn_registration");
    private By loginErrorText = By.id("android:id/message");

    public LoginPage(AppiumDriver driver){
        super(driver);
    }
    //Ожидание поля логина и ввода в него значения
    public LoginPage enterLogin (String login){
        waitAndSendKeys(loginInput,login);
        return this;
    }
    //Ожидание поля пароля и ввод в него значения
    public LoginPage enterPassword(String password){
        waitAndSendKeys(passwordInput,password);
        return this;
    }
    //Ожидание заголовка и возвращение его текста
    public String getTextTitle(){
        return waitAndGetText(title);
    }
    //Ожидание кнопки логи и нажатие на неё
    public void tapButtonLogin(){
        waitAndClick(buttonLogin);
        //driver.findElement(buttonLogin).click();
    }
    //Ожидание кнопки регитсрации и нажатие на неё
    public void tapButtonRegistration(){
        waitAndClick(buttonRegistration);
        //driver.findElement(buttonRegistration).click();
    }
    //Ожидание поля офферты и нажатие на него
    public void tapTermOffer(){
        waitAndClick(termsOffer);
        //driver.findElement(termsOffer).click();
    }
    //Получаем текст ошибки авторизации
    public String getLoginErrorText(){
        return waitAndGetText(loginErrorText);
    }
}
