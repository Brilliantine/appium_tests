package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.rzd.enums.AgreementAction;

public class AgreementKasperskyPage extends BasePage{
    private AppiumDriver driver;

    public AgreementKasperskyPage(AppiumDriver driver){
        super(driver);
    }

    //Нажатие на кнопку "принять/отклонить" согласие
    public TutorialPage confirmKaspersky(AgreementAction action){
        By button = null;
        switch (action){
            case ACCEPT -> button = By.id("ru.rzd.pass.debug:id/accept_button");
            case DECLINE -> button = By.id("ru.rzd.pass.debug:id/cancel_button");
        }
        if(button!=null){
            waitAndClick(button);
            //driver.findElement(button).click();
        }
        else {
            throw new IllegalStateException("Не удалось найти кнопку: "+action);
        }
        return new TutorialPage(driver);
    }
}
