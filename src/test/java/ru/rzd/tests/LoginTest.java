package ru.rzd.tests;

import org.testng.annotations.Test;
import ru.rzd.base.BaseTest;
import ru.rzd.helpers.LoginHelper;
import ru.rzd.pages.LoginPage;
import ru.rzd.pages.MainPage;


public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithValidData(){
        LoginPage loginPage = new MainPage(driver).tapButtonLogin();
        MainPage mainPage = new MainPage(driver);
        mainPage = new LoginHelper(driver).loginAs("testovtestov","Qwerty123");
    }
}
