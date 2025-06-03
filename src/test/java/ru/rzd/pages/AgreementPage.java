package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AgreementPage {
    private AppiumDriver driver;

    public AgreementPage(AppiumDriver driver){
        this.driver = driver;
    }

    public AgreementKasperskyPage tapAccept(String accept){
        By button;
        switch (accept){
            case "accept_button":
                button = By.id("ru.rzd.pass.debug:id/accept_button");
                break;

            case "cancel_button":
                button = By.id("ru.rzd.pass.debug:id/cancel_button");
                break;

            default:
                throw new IllegalArgumentException("Unknown button ID: " + accept);
        }
        driver.findElement(button).click();
        return new AgreementKasperskyPage(driver);
    }
}
