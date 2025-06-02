package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainPage {
    private AppiumDriver driver;
    //Локаторы
    private By buttonLogin = By.id("ru.rzd.pass.debug:id/sign_in_text_view");
    private By buttonSideMenu = By.id("ru.rzd.pass.debug:id/sign_in_text_view");
    private By buttonBsket = By.id("ru.rzd.pass.debug:id/cart");
    private By buttonSearchTrains = By.id("ru.rzd.pass.debug:id/search_button");

    public MainPage(AppiumDriver driver){
        this.driver = driver;
    }

    public LoginPage tapButtonLogin(){
        driver.findElement(buttonLogin).click();
        return new LoginPage(driver);

    }

    public void tapButtonSideMenu(){driver.findElement(buttonSideMenu).click();}

    public void tapButtonBasket(){driver.findElement(buttonBsket).click();}

    public void tapButtonSearchTrains(){driver.findElement(buttonSearchTrains).click();}
}
