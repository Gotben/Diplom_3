package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    // Локатор для "Личный Кабинет" из списка друга (хедер)
    private final SelenideElement personalAccountLink = $x("//p[normalize-space(text())='Личный Кабинет']");
    // Локатор для кнопки входа на главной
    private final SelenideElement loginButton = $x("//button[text()='Войти в аккаунт']");

    @Step("Кликнуть на 'Личный Кабинет' в хедере")
    public void clickPersonalAccount() {
        click(personalAccountLink);
    }

    @Step("Кликнуть на 'Войти в аккаунт' на главной")
    public void clickLoginButtonOnMain() {
        click(loginButton);
    }
}