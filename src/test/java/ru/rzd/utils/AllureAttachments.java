package ru.rzd.utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachments {

    @Attachment(value = "Скрин при падении", type = "image/png")
    public static byte[] captureScreenshot(AppiumDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Лог ошибки",type = "text/plain")
    public static String attachLog(String message){
        return message;
    }
}
