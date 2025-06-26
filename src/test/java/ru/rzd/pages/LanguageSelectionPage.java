package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LanguageSelectionPage extends BasePage{

    private final By title = By.id("ru.rzd.pass.debug:id/title");
    private final By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public LanguageSelectionPage(AppiumDriver driver){
        super(driver);
    }
    //Проверка, открыт ли экран выбора языка
    public boolean isPageDisplayed(){
        return isElementPresent(title);
    }
    public String getTextTitle(){
        return waitAndGetText(title);
    }
    //Выбор языка
    @Step("Выбор языка: {language}")
    public LanguageSelectionPage selectLanguage(String language) {
        By languageOption = By.xpath("//android.widget.TextView[@resource-id='ru.rzd.pass.debug:id/name' and @text='" + language + "']");
        waitAndClick(languageOption);
        return this;
    }

    //Нажатие на кнопку "ПРОДОЛЖИТЬ"
    @Step("Нажатие на кнопку ПРОДОЛЖИТЬ: {buttonNext}")
    public EnvironmentSelectionPage tapNext(){
        waitAndClick(buttonNext);
        return new EnvironmentSelectionPage(driver);
    }
}
