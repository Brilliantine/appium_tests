package ru.rzd.tests;

import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class StepTest {
    @Test
    public void testWithSteps() {
        stepOne();
        stepTwo();
        stepThree();
    }

    @Step("Шаг 1: Открыть приложение")
    public void stepOne() {
        System.out.println("Step 1");
    }

    @Step("Шаг 2: Авторизация")
    public void stepTwo() {
        System.out.println("Step 2");
    }

    @Step("Шаг 3: Проверка главной страницы")
    public void stepThree() {
        System.out.println("Step 3");
    }
}
