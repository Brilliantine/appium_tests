package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver driver;

    //Локаторы
    private By title = By.id("ru.rzd.pass.debug:id/header");
    private By loginInput = By.id("ru.rzd.pass.debug:id/login");
    private By passwordInput = By.id("ru.rzd.pass.debug:id/password");
    private By buttonLogin = By.id("ru.rzd.pass.debug:id/avatar");
    private By buttonResetPassword = By.id("ru.rzd.pass.debug:id/recovery_login_btn");
    private By termsOffer = By.id("ru.rzd.pass.debug:id/offerta");
    private By buttonRegistration = By.id("ru.rzd.pass.debug:id/btn_registration");

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
    }

    public LoginPage enterLogin (String login){
        driver.findElement(loginInput).sendKeys(login);
        return this;
    }
    public LoginPage enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    public String getTextTitle(){
        return driver.findElement(title).getText();
    }

    public void tapButtonLogin(){driver.findElement(buttonLogin).click();}
    public void tapButtonRegistration(){driver.findElement(buttonRegistration).click();}
    public void tapTermOffer(){driver.findElement(termsOffer).click();}
}
