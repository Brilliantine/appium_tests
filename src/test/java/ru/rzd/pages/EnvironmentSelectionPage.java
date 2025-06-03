package ru.rzd.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class EnvironmentSelectionPage {
    private AppiumDriver driver;

    private By title = By.id("ru.rzd.pass.debug:id/title");
    private By changeContour = By.id("ru.rzd.pass.debug:id/apply_host");
    private By buttonNext = By.id("ru.rzd.pass.debug:id/continue_button");

    public EnvironmentSelectionPage(AppiumDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public EnvironmentSelectionPage selectEnvironment(String environment){
        By environmentOption = By.xpath("//android.widget.TextView[@resource-id=\"ru.rzd.pass.debug:id/tvGroupName\" and @text='" + environment + "']");
        driver.findElement(environmentOption).click();
        return this;
    }

    public EnvironmentSelectionPage selectBranch(String branch){
        By branchOption = By.xpath("//android.widget.RadioButton[@text='"+ branch +"']");
        driver.findElement(branchOption).click();
        return this;
    }

    public EnvironmentSelectionPage tapChangeContour(){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"ru.rzd.pass.debug:id/apply_host\"))"
        )).click();
        return this;
    }

    public AgreementPage tapNext(){
        driver.findElement(buttonNext).click();
        return new AgreementPage(driver);
    }

}
