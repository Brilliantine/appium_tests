package ru.rzd.pages;

import ru.rzd.enums.AgreementAction;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AgreementPage extends BasePage{
    private AppiumDriver driver;

    public AgreementPage(AppiumDriver driver){
        super(driver);
    }

    //Нажатие на кнопку "принять/отклонить" согласие
    public AgreementKasperskyPage confirmAgreement(AgreementAction action){
        By button = null;
        switch (action){
            case ACCEPT -> button = By.id("ru.rzd.pass.debug:id/accept_button");
            case DECLINE -> button = By.id("ru.rzd.pass.debug:id/cancel_button");
        }
        if (button!=null){
            waitAndClick(button);
            //driver.findElement(button).click();
        }
        else {
            throw new IllegalStateException("Не удалось найти кнопку: "+action);
        }
        return new AgreementKasperskyPage(driver);
    }
}
