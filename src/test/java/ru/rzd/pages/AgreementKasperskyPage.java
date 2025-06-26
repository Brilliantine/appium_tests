package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.rzd.enums.AgreementAction;

public class AgreementKasperskyPage extends BasePage{

    private final By acceptButton = By.id("ru.rzd.pass.debug:id/accept_button");
    private final By declineButton = By.id("ru.rzd.pass.debug:id/cancel_button");

    public AgreementKasperskyPage(AppiumDriver driver){
        super(driver);
    }
    //Проверяем, что находимся на экране соглашения Касперского
    public boolean isPageDisplayed(){
        return isElementPresent(acceptButton) || isElementPresent(declineButton);
    }
    //Нажатие на кнопку "принять/отклонить" согласие
    @Step("Нажимаем на кнопку: {button}")
    public TutorialPage confirmKaspersky(AgreementAction action){
        By button = switch (action){
            case ACCEPT -> acceptButton;
            case DECLINE -> declineButton;
        };
        waitAndClick(button);
        return new TutorialPage(driver);
    }
}
