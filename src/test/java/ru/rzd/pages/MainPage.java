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
    private By initialsView = By.id("ru.rzd.pass.debug:id/initials_view"); //заглушка аватара
    private By avatarImageView = By.id("ru.rzd.pass.debug:id/avatar_image_view"); //аватар (если он загружен)

    public MainPage(AppiumDriver driver){
        super(driver);
    }
    //Проверяем, что находимся на главной странице
    public boolean isPageDisplayed(){
        return isElementPresent(buttonSearchTrains);
    }

    @Step("Нажимаем на кнопку авторизации")
    public LoginPage tapButtonLogin(){
        waitAndClick(buttonLogin);
        return new LoginPage(driver);
    }
    //Вызов бокового меню
    public void tapButtonSideMenu(){waitAndClick(buttonSideMenu);}

    //Нажатие на кнопку Корзина
    public void tapButtonBasket(){waitAndClick(buttonBsket);}

    //Нажатие на кнопку поиска расписания
    public void tapButtonSearchTrains(){waitAndClick(buttonSearchTrains);}

    //Проверяем отображается ли заглушка аватара пользователя
    public boolean isInitialsViewVisible(){
        return isElementPresent(initialsView);
    }

    //Проверяем отображается ли аватар пользователя
    public boolean isUserAvataVisible(){
        return isElementPresent(avatarImageView);
    }

    //Проверяем отображается ли аватар или заглушка
    public boolean isImageView(){
        return isElementPresent(initialsView) || isElementPresent(avatarImageView);
    }

    //Проверяем, отображается ли кнопка Войти
    public boolean isLoginButtonVisible(){
        return isElementPresent(buttonLogin);
    }
}
