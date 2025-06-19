package ru.rzd.helpers.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
        System.out.println("[ПРОВАЛ]\n*** Тест: "+result.getName()+" провалился! ***");
        System.out.println("ПРИЧИНА: "+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("ПРОПУЩЕН тест: "+result.getName());
    }
}
