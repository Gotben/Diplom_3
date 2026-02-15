package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage extends BasePage {

    private final SelenideElement loginLink = $x("//a[normalize-space(text())='Войти']");

    @Step("Перейти на страницу входа со страницы восстановления пароля")
    public void goToLoginPage() {
        click(loginLink);
    }
}