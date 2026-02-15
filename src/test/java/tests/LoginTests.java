package tests;


import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.*;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private ForgotPasswordPage forgotPasswordPage;
    private AccountPage accountPage;

    @Before
    public void setupPages() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
        forgotPasswordPage = new ForgotPasswordPage();
        accountPage = new AccountPage();

    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginViaMainPageLoginButtonTest() {
        mainPage.openUrl("https://stellarburgers.education-services.ru/");
        mainPage.clickLoginButtonOnMain();
        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/login"));

        loginPage.login(testEmail, testPassword);

        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/"));

    }





    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginViaPersonalAccountButtonTest() {
        mainPage.openUrl("https://stellarburgers.education-services.ru/");
        mainPage.clickPersonalAccount();
        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/login"));

        loginPage.login(testEmail, testPassword);

        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginViaRegistrationFormTest() {
        registrationPage.openUrl("https://stellarburgers.education-services.ru/register");
        registrationPage.goToLoginPage();
        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/login"));

        loginPage.login(testEmail, testPassword);

        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginViaForgotPasswordFormTest() {
        forgotPasswordPage.openUrl("https://stellarburgers.education-services.ru/forgot-password");
        forgotPasswordPage.goToLoginPage();
        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/login"));

        loginPage.login(testEmail, testPassword);

        webdriver().shouldHave(url("https://stellarburgers.education-services.ru/"));
    }

    @Test
    @DisplayName("Вход с некорректным паролем")
    public void loginWithWrongPasswordTest() {
        loginPage.openUrl("https://stellarburgers.education-services.ru/login");
        loginPage.setEmail(testEmail);
        loginPage.setPassword("w1234");
        loginPage.clickLoginButton();

        // Проверяем, что появилось сообщение об ошибке
        loginPage.getLoginErrorMessage().shouldBe(visible);
        // Или проверяем, что мы всё ещё на странице входа
        loginPage.getLoginTitle().shouldBe(visible);
    }


}