package ru.rzd.helpers.listeners;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.rzd.base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        Object testClass = result.getInstance();

        AppiumDriver driver = ((BaseTest)testClass).getDriver();

        if(driver instanceof TakesScreenshot){
            TakesScreenshot ts = (TakesScreenshot) driver;

            //Делаем скриншот
            File screenshot = ts.getScreenshotAs(OutputType.FILE);

            //Строки для создания уникального имени скриншота
            String time = new SimpleDateFormat("yyy-MM-dd_HH-mm-ss").format(new Date());
            String testName = result.getMethod().getMethodName();
            String path = "screenshots/"+testName+"_"+time+".png";

            try {
                //Создаем папку для скринов
                Files.createDirectories(Paths.get("screenshots"));
                //Помещаем скрин в созданную папку
                Files.copy(screenshot.toPath(),Paths.get(path));
                //Информация для отладки
                System.out.println("[СКРИНШОТ СОХРАНЕН: ]"+path);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
