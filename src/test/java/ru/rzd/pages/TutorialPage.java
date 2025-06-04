package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TutorialPage extends BasePage{

    private final By buttonClose = By.id("ru.rzd.pass.debug:id/pass_button");
    private final By tutorialImage = By.id("ru.rzd.pass.debug:id/tutorial_image");

    public TutorialPage(AppiumDriver driver){
        super(driver);
    }
    //Проверяем что находимся на экране туториала
    public boolean isPageDisplayed(){
        return isElementPresent(tutorialImage);
    }
    //Закрываем туториал
    public MainPage tapButtonClose(){
        waitAndClick(buttonClose);
        return new MainPage(driver);
    }
}
