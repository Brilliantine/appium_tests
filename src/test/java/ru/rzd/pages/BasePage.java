package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    protected BasePage(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Ожидает элемент и возвращает его
    protected WebElement waitForVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Ждет кликабельность и возвращает элемент
    protected WebElement waitForClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //Проверка наличия элемента (без падения)
    protected boolean isElementPresent(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }
    //Проверка исчезновения элемента
    protected boolean waitUntilInvisible(By locator){
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
        catch (TimeoutException e){
            return false;
        }

    }
    //Универсальный клик
    protected void waitAndClick(By locator){
        waitForClickable(locator).click();
    }
    //Очистить и ввести текст
    protected void waitAndSendKeys(By locator,String text){
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }
    //Получить текст
    protected String waitAndGetText(By locator){
        return waitForVisibility(locator).getText();
    }
    //Получить атрибут
    protected String waitAndGetAttribute(By locator, String attributeName){
        return waitForVisibility(locator).getAttribute(attributeName);
    }
}
