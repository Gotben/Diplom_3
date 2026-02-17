package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import com.codeborne.selenide.Condition;

public class LoginPage extends BasePage {

    // Email поле
    private final SelenideElement inputEmail = $x("//label[text()='Email']/following::input[1]");

    // Пароль поле
    private final SelenideElement inputPassword = $x("//input[@name='Пароль' and @type='password']");

    // Кнопка "Войти"
    private final SelenideElement buttonLogin = $x("//button[contains(text(), 'Войти')]");

    // Ссылка "Зарегистрироваться"
    private final SelenideElement registerLink = $x("//a[text()='Зарегистрироваться']");

    // Ссылка "Восстановить пароль"
    private final SelenideElement forgotPasswordLink = $x("//a[text()='Восстановить пароль']");

    // Заголовок "Вход"
    private final SelenideElement loginTitle = $x("//h2[text()='Вход']");

    // Кнопка "Войти в аккаунт" на главной
    private final SelenideElement loginButtonMain = $x("//button[text()='Войти в аккаунт']");

    // Сообщение об ошибке - ВОЗВРАЩАЕМ!
    private final SelenideElement loginErrorMessage = $x("//p[contains(text(), 'Некорректный')]");

    @Step("Ввести email")
    public void setEmail(String email) {
        setValue(inputEmail, email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        setValue(inputPassword, password);
    }

    @Step("Нажать кнопку Войти")
    public void clickLoginButton() {
        click(buttonLogin);
    }

    @Step("Перейти на страницу регистрации")
    public void goToRegisterPage() {
        click(registerLink);
    }

    @Step("Перейти на страницу восстановления пароля")
    public void goToForgotPasswordPage() {
        click(forgotPasswordLink);
    }

    @Step("Логин пользователя через UI")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Нажать кнопку 'Войти в аккаунт' на главной")
    public void clickLoginButtonOnMain() {
        click(loginButtonMain);
    }

    @Step("Проверить, что заголовок 'Вход' виден")
    public SelenideElement getLoginTitle() {
        return loginTitle;
    }

    // ВОЗВРАЩАЕМ МЕТОД!
    @Step("Получить сообщение об ошибке при входе")
    public SelenideElement getLoginErrorMessage() {
        return loginErrorMessage;
    }


}