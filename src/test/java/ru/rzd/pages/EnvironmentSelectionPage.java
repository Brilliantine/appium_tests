package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class EnvironmentSelectionPage extends BasePage{

    private final By title = By.id("ru.rzd.pass.debug:id/title");
    private final By changeContour = By.id("ru.rzd.pass.debug:id/apply_host");
    private final By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public EnvironmentSelectionPage(AppiumDriver driver){
        super(driver);
    }
    //ПРоверяем, находиммся ли мы на экране выбора ветки
    public boolean isPageDisplayed(){
        return isElementPresent(title);
    }
    //Получаем название экрана
    public String getTitle(){
        return waitAndGetText(title);
    }
    //Выбор контура. Например "master"
    public EnvironmentSelectionPage selectEnvironment(String environment){
        By environmentOption = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/tvGroupName\" and @text='" + environment + "']");
        waitAndClick(environmentOption);
        return this;
    }
    //Выбор ветки. Например, TEST-RELEASE
    public EnvironmentSelectionPage selectBranch(String branch){
        By branchOption = By.xpath("//android.widget.RadioButton[@text='"+ branch +"']");
        waitAndClick(branchOption);
        return this;
    }
    //Скролл до кнопки "ПОМЕНЯТЬ КОНТУР" и её нажатие
    public EnvironmentSelectionPage tapChangeContour(){
        scrollAndClick(changeContour);
        return this;
    }

    //Нажатие кнопки "ПРОДОЛЖИТЬ"
    public AgreementPage tapNext(){
        waitAndClick(buttonNext);
        return new AgreementPage(driver);
    }

}
