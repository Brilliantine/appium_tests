package ru.rzd.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    /*protected void scrollAndClick(By locator) {
        String id = locator.toString().replace("By.id: ", "");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + id + "\"))"
        )).click();
    }*/

    //Новый универсальный метод скролла и клика
    protected void scrollAndClick(By locator){
        //Максимальное количество скроллов
        int maxScroll = 5;

        //Скролл и клик
        for (int i = 0; i < maxScroll; i++){
            //Получаем размеры экрана
            Dimension screenSize = driver.manage().window().getSize();
            int screenWidth = screenSize.getWidth(); //Ширина
            int screenHeight = screenSize.getHeight(); //Высота

            try{
                //Пытаемся найти элемент и кликнуть по нему
                // Если элемент найден, то кликаем по нему и выходим из метода
                WebElement element = driver.findElement(locator);
                element.click();
                return;
            } catch (NoSuchElementException e) {
                //Параметры для скролла
                Map<String, Object> params = new HashMap<>();
                // X-кордината начала области скролла
                params.put("left", screenWidth/10);
                //Y-кордината начала области скролла
                params.put("top", screenHeight/4);
                //Ширина области, в которой будт скролл
                params.put("width", screenWidth*8/10);
                //Высота области, в которой будет скролл
                params.put("height", screenHeight/2);
                //Направления скролла
                params.put("direction","down");
                //Насколько длинным будет скролл (от 0.0 до 1.0)
                params.put("percent",0.7);

                Boolean canScroll = (Boolean) driver.executeScript("mobile: scrollGesture",params);

                if(!canScroll){
                    throw new NoSuchElementException("Не удалось найти элемент после скролла" + locator.toString());
                }
            }
        }
        throw new NoSuchElementException("Не удалось найти элемент после " +maxScroll+ "скроллов:" + locator.toString());
    }
}
