package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.TestData;
import utils.UserApi;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests extends BaseTest {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Before
    public void setupPages() {
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successfulRegistrationTest() {
        registrationPage.openUrl("https://stellarburgers.education-services.ru/register");
        // Генерируем новый email специально для UI-регистрации
        String uiEmail = TestData.generateRandomEmail();
        String uiName = TestData.generateRandomName();

        registrationPage.register(uiName, uiEmail, testPassword);

        // Проверяем, что после регистрации произошёл редирект на страницу входа
        loginPage.getLoginTitle().shouldBe(visible);

        // Удаляем созданного через UI пользователя через API
        String token = UserApi.login(uiEmail, testPassword);
        if (token != null) {
            UserApi.deleteUser(token);
            System.out.println("Пользователь " + uiEmail + " успешно удалён");
        }
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля (менее 6 символов)")
    public void registrationWithShortPasswordTest() {
        registrationPage.openUrl("https://stellarburgers.education-services.ru/register");
        registrationPage.register(testName, testEmail, "123"); // меньше 6 символов

        // Проверяем, что появилась ошибка под полем пароля
        registrationPage.getPasswordErrorMessage().shouldBe(visible);
    }
}