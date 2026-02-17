package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage extends BasePage {

    private final SelenideElement inputName = $x("//label[text()='Имя']/following::input[1]");
    private final SelenideElement inputEmail = $x("//label[text()='Email']/following::input[1]");
    private final SelenideElement inputPassword = $x("//input[@name='Пароль' and @type='password']");
    private final SelenideElement buttonRegister = $x("//button[text()='Зарегистрироваться']");
    private final SelenideElement loginLink = $x("//a[text()='Войти']");
    private final SelenideElement passwordErrorMessage = $x("//p[text()='Некорректный пароль']");

    @Step("Заполнить имя")
    public void setName(String name) {
        setValue(inputName, name);
    }

    @Step("Заполнить email")
    public void setEmail(String email) {
        setValue(inputEmail, email);
    }

    @Step("Заполнить пароль")
    public void setPassword(String password) {
        setValue(inputPassword, password);
    }

    @Step("Нажать Зарегистрироваться")
    public void clickRegisterButton() {
        click(buttonRegister);
    }

    @Step("Перейти на страницу входа")
    public void goToLoginPage() {
        click(loginLink);
    }

    @Step("Регистрация пользователя через UI")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    @Step("Получить элемент с ошибкой пароля")
    public SelenideElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }
}