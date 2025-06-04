package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class EnvironmentSelectionPage extends BasePage{
    private AppiumDriver driver;

    private By title = By.id("ru.rzd.pass.debug:id/title");
    private By changeContour = By.id("ru.rzd.pass.debug:id/apply_host");
    private By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public EnvironmentSelectionPage(AppiumDriver driver){
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    //Выбор контура. Например "master"
    public EnvironmentSelectionPage selectEnvironment(String environment){
        By environmentOption = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/tvGroupName\" and @text='" + environment + "']");
        waitAndClick(environmentOption);
        //driver.findElement(environmentOption).click();
        return this;
    }

    //Выбор ветки. Например, TEST-RELEASE
    public EnvironmentSelectionPage selectBranch(String branch){
        By branchOption = By.xpath("//android.widget.RadioButton[@text='"+ branch +"']");
        waitAndClick(branchOption);
        //driver.findElement(branchOption).click();
        return this;
    }

    //Скролл до кнопки "ПОМЕНЯТЬ КОНТУР" и её нажатие
    public EnvironmentSelectionPage tapChangeContour(){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"ru.rzd.pass.debug:id/apply_host\"))"
        )).click();
        return this;
    }

    //Нажатие кнопки "РОДОЛЖИТЬ"
    public AgreementPage tapNext(){
        waitAndClick(buttonNext);
        //driver.findElement(buttonNext).click();
        return new AgreementPage(driver);
    }

}
