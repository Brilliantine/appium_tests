package ru.rzd.tests;

import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class StepTest {
    @Test
    public void testWithSteps() {
        openApp();
        login();
        verifyMainScreen();
    }

    @Step("Открываем приложение")
    public void openApp() {
        System.out.println("App opened");
    }

    @Step("Выполняем вход")
    public void login() {
        System.out.println("Login success");
    }

    @Step("Проверяем главный экран")
    public void verifyMainScreen() {
        System.out.println("Main screen OK");
    }
}
