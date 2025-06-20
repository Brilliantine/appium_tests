package ru.rzd.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.rzd.base.BaseTest;
import ru.rzd.helpers.JsonReader;
import ru.rzd.helpers.LoginHelper;
import ru.rzd.helpers.listeners.ScreenshotListener;
import ru.rzd.helpers.listeners.TestLoggerListener;
import ru.rzd.models.User;
import ru.rzd.pages.EntryProtectionPage;
import ru.rzd.pages.LoginPage;
import ru.rzd.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({TestLoggerListener.class, ScreenshotListener.class})
public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithValidData(){
        //Загрузка данных пользователя из JSON файла
        User user = JsonReader.read("data/user.json",User.class);

        LoginPage loginPage = new MainPage(driver).tapButtonLogin();
        MainPage mainPage = new LoginHelper(driver).loginAs(user.getUsername(), user.getPassword());
        System.out.println("Введен логин: "+user.getUsername());
        System.out.println("Введен пароль: "+user.getPassword());

        EntryProtectionPage entryProtectionPage = new EntryProtectionPage(driver);
        assertThat(entryProtectionPage.isPageDisplayed())
                .as("Страница защиты входа должна отображаться")
                        .isTrue();
        //Assert.assertTrue(entryProtectionPage.isPageDisplayed(),"Страница выбора защиты входа не загрузилась");
        entryProtectionPage.tapNext();

        //Проверки главной страницы
        assertThat(mainPage.isPageDisplayed())
                .as("Главная страница должна отображаться")
                .isTrue();

        assertThat(mainPage.isUserAvatarVisible())
                .as("Аватар пользователя должен отображаться")
                .isTrue();

        assertThat(mainPage.isLoginButtonVisible())
                .as("Кнопка Войти не должна отображаться")
                .isFalse();
        /*SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isPageDisplayed(),"Главная страница не загрузилась");
        softAssert.assertTrue(mainPage.isUserAvatarVisible());
        softAssert.assertFalse(mainPage.isLoginButtonVisible());
        softAssert.assertAll();*/

    }
}
