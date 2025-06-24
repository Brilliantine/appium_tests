package ru.rzd.helpers.listeners;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.rzd.base.BaseTest;
import ru.rzd.utils.AllureAttachments;

public class TestLoggerListener implements ITestListener {

    @Override
    public void onStart(ITestContext context){
        System.out.println("===Начало наборов тестов: "+context.getName()+" ===");
    }
    @Override
    public void onFinish(ITestContext context){
        System.out.println("=== Конец набора тестов: "+context.getName()+" ===");
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("=== Начала теста: "+result.getName()+" ===");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("[УСПЕХ]\n*** Тест: "+result.getName()+" завершился успешно! ***");
    }

    @Override
    public void onTestFailure(ITestResult result){
        AppiumDriver driver = BaseTest.getInstance().getDriver();
        if(driver != null){
            AllureAttachments.captureScreenshot(driver);
        }
        AllureAttachments.attachLog("Тест упал: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("ПРОПУЩЕН тест: "+result.getName());
    }
}
