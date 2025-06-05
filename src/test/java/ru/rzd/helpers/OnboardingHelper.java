package ru.rzd.helpers;

import io.appium.java_client.AppiumDriver;
import ru.rzd.enums.AgreementAction;
import ru.rzd.pages.*;

public class OnboardingHelper {
    private AppiumDriver driver;

    public OnboardingHelper(AppiumDriver driver){
        this.driver = driver;
    }

    public void completeIfPresents(){
        System.out.println("=== Начинаем проверку онбординга ===");
        //Language Selection
        LanguageSelectionPage languageSelectionPage = new LanguageSelectionPage(driver);
        if(languageSelectionPage.isPageDisplayed()){
            System.out.println("Проходим LanguageSelectionPage");
            languageSelectionPage.selectLanguage("Русский")
                    .tapNext();
        }
        //Environment Selection
        EnvironmentSelectionPage environmentSelectionPage = new EnvironmentSelectionPage(driver);
        if ((environmentSelectionPage.isPageDisplayed())){
            System.out.println("Проходим EnvironmentSelectionPage");
            environmentSelectionPage.selectEnvironment("master")
                    .selectBranch("TEST-RELEASE")
                    .tapChangeContour()
                    .tapNext();
        }
        //Agreement
        AgreementPage agreementPage = new AgreementPage(driver);
        if (agreementPage.isPageDisplayed()){
            System.out.println("Проходим AgreementPage");
            agreementPage.confirmAgreement(AgreementAction.ACCEPT);
        }
        //Agreement Kaspersky
        AgreementKasperskyPage agreementKasperskyPage = new AgreementKasperskyPage(driver);
        if (agreementKasperskyPage.isPageDisplayed()){
            System.out.println("Проходим AgreementKasperskyPage");
            agreementKasperskyPage.confirmKaspersky(AgreementAction.ACCEPT);
        }
        //Tutorial
        TutorialPage tutorialPage = new TutorialPage(driver);
        if (tutorialPage.isPageDisplayed()){
            System.out.println("Проходим TutorialPage");
            tutorialPage.tapButtonClose();
        }
        System.out.println("Онбординг пройден");
    }
}
