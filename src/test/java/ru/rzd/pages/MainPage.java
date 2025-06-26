package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BasePage{
    //Локаторы
    private By buttonLogin = By.id("ru.rzd.pass.debug:id/sign_in_text_view");
    private By buttonSideMenu = By.id("ru.rzd.pass.debug:id/sign_in_text_view");
    private By buttonBsket = By.id("ru.rzd.pass.debug:id/cart");
    private By buttonSearchTrains = By.id("ru.rzd.pass.debug:id/search_button");
    private By avatarImage = By.id("ru.rzd.pass.debug:id/initials_view");

    public MainPage(AppiumDriver driver){
        super(driver);
    }
    //Проверяем, что находимся на главной странице
    @Step("Проверяем что находимся на главном экране")
    public boolean isPageDisplayed(){
        return isElementPresent(buttonSearchTrains);
    }
    //Нажатие на кнопку "Войти"
    @Step("Нажимаем на кнопку войти: {buttonLogin}")
    public LoginPage tapButtonLogin(){
        waitAndClick(buttonLogin);
        return new LoginPage(driver);
    }
    //Вызов бокового меню
    @Step("Нажимаем на кнопку вызова бокового меню: {buttonSideMenu}")
    public void tapButtonSideMenu(){waitAndClick(buttonSideMenu);}

    //Нажатие на кнопку Корзина
    @Step("Нажимаем на кнопку Корзина: {buttonBsket}")
    public void tapButtonBasket(){waitAndClick(buttonBsket);}
    //Нажатие на кнопку поиска расписания
    @Step("Нажимаем на кнопку поиска расписания: {buttonSearchTrains}")
    public void tapButtonSearchTrains(){waitAndClick(buttonSearchTrains);}
    //Проверяем, отображается ли аватар пользователя
    @Step("Проверяем отображается ли аватар")
    public boolean isUserAvatarVisible(){
        return isElementPresent(avatarImage);
    }
    //Проверяем, отображается ли кнопка Войти
    @Step("Нажимаем на кнопку Войти: {buttonLogin}")
    public boolean isLoginButtonVisible(){
        return isElementPresent(buttonLogin);
    }
}
