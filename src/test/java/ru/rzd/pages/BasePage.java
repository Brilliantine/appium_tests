package ru.rzd.pages;

import io.appium.java_client.AppiumBy;
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
    protected void scrollAndClick(By locator) {
        String id = locator.toString().replace("By.id: ", "");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + id + "\"))"
        )).click();
    }
    //Обработка всплывающего окна, которое запрашивает разрешение на отправку уведомлений
    public void handleNotificationPermissionIfPresent(){
        try {
            // Ждём 2-3 секунды для появления окна
            Thread.sleep(2000);

            // Ищем кнопку "Разрешить" по тексту
            By allowButton = AppiumBy.xpath("//*[@text='Разрешить']");

            if (!driver.findElements(allowButton).isEmpty()) {
                driver.findElement(allowButton).click();
                System.out.println("Разрешение на уведомления выдано.");
            } else {
                System.out.println("Окно разрешения не появилось.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при попытке обработать разрешение: " + e.getMessage());
        }

    }
}
