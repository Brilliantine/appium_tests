package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AgreementKasperskyPage {
    private AppiumDriver driver;

    public AgreementKasperskyPage(AppiumDriver driver){
        this.driver = driver;
    }

    public TutorialPage clickButton(String agree){
        By button;
        switch (agree){
            case "agree":
                button = By.id("ru.rzd.pass.debug:id/accept_button");
                break;

            case "disagree":
                button = By.id("ru.rzd.pass.debug:id/cancel_button");
                break;

            default:
                throw new IllegalArgumentException("Unknown button ID: " + agree);
        }
        driver.findElement(button).click();
        return new TutorialPage(driver);
    }
}
