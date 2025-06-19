package ru.rzd.helpers.listeners;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.rzd.base.BaseTest;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        Object testClass = result.getInstance();

        AppiumDriver driver = ((BaseTest)testClass).getDriver();

        if(driver instanceof TakesScreenshot){
            TakesScreenshot ts = (TakesScreenshot) driver;
        }
    }
}
