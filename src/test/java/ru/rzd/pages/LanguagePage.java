package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LanguagePage {
    AppiumDriver driver;

    private By title = By.id("ru.rzd.pass.debug:id/title");
    private By languageIsRussia = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Русский\"]");
    private By languageIsEnglish = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"English\"]");
    private By languageIsChina = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"简体中文\"]");
    private By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public String getTextTitle(){
        return driver.findElement(title).getText();
    }

    public void tapButtonNext(){
        driver.findElement(buttonNext).click();
    }

    public void tapLanguageIsRussia(){
        driver.findElement(languageIsRussia).click();
    }

    public void tapLanguageIsEnglish(){
        driver.findElement(languageIsEnglish).click();
    }

    public void tapLanguageIsChina(){
        driver.findElement(languageIsChina).click();
    }
}
