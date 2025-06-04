package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LanguageSelectionPage extends BasePage{
    AppiumDriver driver;

    private By title = By.id("ru.rzd.pass.debug:id/title");
    private By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public LanguageSelectionPage(AppiumDriver driver){
        super(driver);
    }

    public String getTextTitle(){
        return driver.findElement(title).getText();
    }

    //Выбор языка
    public LanguageSelectionPage selectLanguage(String language) {
        By languageOption = By.xpath("//android.widget.TextView[@resource-id='ru.rzd.pass.debug:id/name' and @text='" + language + "']");
        waitAndClick(languageOption);
        return this;
    }

    //Нажатие на кнопку "ПРОДОЛЖИТЬ"
    public EnvironmentSelectionPage tapNext(){
        waitAndClick(buttonNext);
        //driver.findElement(buttonNext).click();
        return new EnvironmentSelectionPage(driver);
    }
}
