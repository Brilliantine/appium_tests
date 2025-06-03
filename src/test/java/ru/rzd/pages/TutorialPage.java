package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TutorialPage {
    private AppiumDriver driver;

    private By buttonClose = By.id("ru.rzd.pass.debug:id/pass_button");
    private By buttonNextSlide = By.id("ru.rzd.pass.debug:id/button_forward");

    public TutorialPage(AppiumDriver driver){
        this.driver = driver;
    }

    //Закрываем туториал
    public MainPage tapButtonClose(){
        driver.findElement(buttonClose).click();
        return new MainPage(driver);
    }
}
