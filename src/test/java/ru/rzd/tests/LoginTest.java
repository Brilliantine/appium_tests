package ru.rzd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.rzd.base.BaseTest;
import ru.rzd.helpers.LoginHelper;
import ru.rzd.pages.EntryProtectionPage;
import ru.rzd.pages.LoginPage;
import ru.rzd.pages.MainPage;


public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithValidData(){
        LoginPage loginPage = new MainPage(driver).tapButtonLogin();
        MainPage mainPage = new LoginHelper(driver).loginAs("testovtestov","Qwerty123");

        EntryProtectionPage entryProtectionPage = new EntryProtectionPage(driver);
        Assert.assertTrue(entryProtectionPage.isPageDisplayed(),"Страница выбора защиты входа не загрузилась");
        entryProtectionPage.tapNext();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isPageDisplayed(),"Главная страница не загрузилась");
        softAssert.assertTrue(mainPage.isUserAvatarVisible());
        softAssert.assertFalse(mainPage.isLoginButtonVisible());
        softAssert.assertAll();

    }
}
