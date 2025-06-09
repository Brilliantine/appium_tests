package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PinCodePage extends BasePage{

    private By hint = By.id("ru.rzd.pass.debug:id/hint");
    private By buttonCanel = By.id("ru.rzd.pass.debug:id/btn_cancel");
    private By buttonBackspace = By.id("ru.rzd.pass.debug:id/btn_backspace");

    public PinCodePage(AppiumDriver driver){
        super(driver);
    }
}
