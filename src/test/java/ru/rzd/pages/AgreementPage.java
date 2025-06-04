package ru.rzd.pages;

import ru.rzd.enums.AgreementAction;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AgreementPage extends BasePage{

    private final By acceptButton = By.id("ru.rzd.pass.debug:id/accept_button");
    private final By declineButton = By.id("ru.rzd.pass.debug:id/cancel_button");

    public AgreementPage(AppiumDriver driver){
        super(driver);
    }
    //Проверяем, что находимся на экране принятия согласия
    public boolean isPageDisplayed(){
        return isElementPresent(acceptButton) || isElementPresent(declineButton);
    }
    //Нажатие на кнопку "принять/отклонить" согласие
    public AgreementKasperskyPage confirmAgreement(AgreementAction action){
        By button = switch (action){
            case ACCEPT -> acceptButton;
            case DECLINE -> declineButton;
        };
        waitAndClick(button);
        return new AgreementKasperskyPage(driver);
    }
}
