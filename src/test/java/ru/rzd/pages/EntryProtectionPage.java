package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EntryProtectionPage extends BasePage{

    private By buttonUseAccessCode = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Использовать код доступа\"]");
    private By buttonNotUseAccessCode = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Не защищать вход в приложение\"]");
    private By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public EntryProtectionPage(AppiumDriver driver){
        super(driver);
    }
    //Проверям, что находимся на странице защиты входа
    public boolean isPageDisplayed(){
        return isElementPresent(buttonUseAccessCode) || isElementPresent(buttonNotUseAccessCode);
    }

}
