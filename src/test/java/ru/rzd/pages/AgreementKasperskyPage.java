package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AgreementKasperskyPage {
    private AppiumDriver driver;

    public AgreementKasperskyPage(AppiumDriver driver){
        this.driver = driver;
    }

    public TutorialPage confirmKaspersky(AgreementAction action){
        By button = null;
        switch (action){
            case ACCEPT -> button = By.id("ru.rzd.pass.debug:id/accept_button");
            case DECLINE -> button = By.id("ru.rzd.pass.debug:id/cancel_button");
        }
        if(button!=null){
            driver.findElement(button).click();
        }
        else {
            throw new IllegalStateException("Не удалось найти кнопку: "+action);
        }
        return new TutorialPage(driver);
    }
}
