package ru.rzd.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.rzd.base.BaseTest;
import ru.rzd.helpers.JsonReader;
import ru.rzd.helpers.LoginHelper;
import ru.rzd.models.User;
import ru.rzd.pages.EntryProtectionPage;
import ru.rzd.pages.LoginPage;
import ru.rzd.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithValidData(){
        //Загрузка данных пользователя из JSON файла
        User user = JsonReader.read("data/user.json",User.class);

        LoginPage loginPage = new MainPage(getDriver()).tapButtonLogin();
        MainPage mainPage = new LoginHelper(getDriver()).loginAs(user.getUsername(), user.getPassword());

        EntryProtectionPage entryProtectionPage = new EntryProtectionPage(getDriver());
        assertThat(entryProtectionPage.isPageDisplayed())
                .as("Страница защиты входа должна отображаться")
                        .isTrue();
        //Assert.assertTrue(entryProtectionPage.isPageDisplayed(),"Страница выбора защиты входа не загрузилась");
        entryProtectionPage.tapNext();

        //Проверки главной страницы
        assertThat(mainPage.isPageDisplayed())
                .as("Главная страница должна отображаться")
                .isTrue();

        assertThat(mainPage.isImageView())
                .as("Кнопка профиля должна отображаться")
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
