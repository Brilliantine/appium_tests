package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.rzd.enums.ProtectionMethod;

public class EntryProtectionPage extends BasePage{

    private By buttonUseAccessCode = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Использовать код доступа\"]");
    private By buttonNotUseAccessCode = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/name\" and @text=\"Не защищать вход в приложение\"]");
    private By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");
    private By title = By.id("ru.rzd.pass.debug:id/title");
    private By hint = By.id("ru.rzd.pass.debug:id/hint");

    private ProtectionMethod selectedMethod = ProtectionMethod.NOPROTECT;

    public EntryProtectionPage(AppiumDriver driver){
        super(driver);
    }
    //Проверям, что находимся на странице защиты входа
    public boolean isPageDisplayed(){
        return isElementPresent(buttonUseAccessCode) || isElementPresent(buttonNotUseAccessCode);
    }
    //Получаем текст заголовка
    public String titleText(){
        return waitAndGetText(title);
    }
    //Нажимаем кнопку Продолжить
    public BasePage tapNext(){
        waitAndClick(buttonNext);
        return selectedMethod == ProtectionMethod.PROTECT
                ? new PinCodePage(driver)
                : new MainPage(driver);
    }
    //Выбираем способ защиты входа
    public EntryProtectionPage chooseProtectionMethod(ProtectionMethod method){
        selectedMethod = method;
        By button = switch (method){
            case PROTECT -> buttonUseAccessCode;
            case NOPROTECT -> buttonNotUseAccessCode;
        };
        waitAndClick(button);
        return this;
    }
}
