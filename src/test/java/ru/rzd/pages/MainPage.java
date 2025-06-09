package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
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
    public boolean isPageDisplayed(){
        return isElementPresent(buttonSearchTrains);
    }
    //Нажатие на кнопку "Войти"
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
    //Проверяем, отображается ли аватар пользователя
    public boolean isUserAvatarVisible(){
        return isElementPresent(avatarImage);
    }
    //Проверяем, отображается ли кнопка Войти
    public boolean isLoginButtonVisible(){
        return isElementPresent(buttonLogin);
    }
}
