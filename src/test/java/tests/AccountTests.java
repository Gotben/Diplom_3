package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.AccountPage;
import pages.ConstructorPage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.visible;

public class AccountTests extends BaseTest {

    private AccountPage accountPage;
    private LoginPage loginPage;
    private ConstructorPage constructorPage;
    private MainPage mainPage;

    @Before
    public void setupPagesAndLogin() {
        accountPage = new AccountPage();
        loginPage = new LoginPage();
        constructorPage = new ConstructorPage();
        mainPage = new MainPage();

        // Логинимся перед тестами
        loginPage.openUrl("https://stellarburgers.education-services.ru/login");
        loginPage.login(testEmail, testPassword);
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на «Личный Кабинет»")
    public void goToAccountPageTest() {

        // Кликаем на "Личный Кабинет" в хедере
        mainPage.clickPersonalAccount();

        // Проверяем, что мы в личном кабинете
        accountPage.getProfileTitle().shouldBe(visible);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void goToConstructorFromAccountViaLinkTest() {

        mainPage.clickPersonalAccount();
        // Сначала убедимся, что мы в личном кабинете
        accountPage.getProfileTitle().shouldBe(visible);

        // Переходим в конструктор
        accountPage.goToConstructorViaLink();

        // Проверяем, что мы в конструкторе
        constructorPage.getConstructorTitle().shouldBe(visible);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void goToConstructorFromAccountViaLogoTest() {

        mainPage.clickPersonalAccount();
        // Сначала убедимся, что мы в личном кабинете
        accountPage.getProfileTitle().shouldBe(visible);

        // Переходим в конструктор по логотипу
        accountPage.goToConstructorViaLogo();

        // Проверяем, что мы в конструкторе
        constructorPage.getConstructorTitle().shouldBe(visible);
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {

        mainPage.clickPersonalAccount();
        // Сначала убедимся, что мы в личном кабинете
        accountPage.getProfileTitle().shouldBe(visible);

        // Выходим
        accountPage.logout();

        // Проверяем, что мы на странице входа
        loginPage.getLoginTitle().shouldBe(visible);
    }
}