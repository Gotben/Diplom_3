package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {

    // Кнопка выхода
    private final SelenideElement logoutButton = $x("//button[text()='Выход']");

    // Текст в личном кабинете
    private final SelenideElement profileInfoText = $x("//p[contains(text(), 'персональные данные')]");

    // Заголовок "Профиль"
    private final SelenideElement profileTitle = $x("//a[text()='Профиль']");

    // Ссылка "Конструктор" в хедере
    private final SelenideElement constructorLink = $x("//p[text()='Конструктор']");

    // Логотип Stellar Burgers
    private final SelenideElement logoStellarBurgers = $x("//div[@class='AppHeader_header__logo__2D0X2']/a");

    // Ссылка "Личный Кабинет" в хедере
    private final SelenideElement personalAccountLink = $x("//p[text()='Личный Кабинет']");

    @Step("Выход из аккаунта")
    public void logout() {
        click(logoutButton);
    }

    @Step("Переход в конструктор по кнопке 'Конструктор'")
    public void goToConstructorViaLink() {
        click(constructorLink);
    }

    @Step("Переход в конструктор по логотипу")
    public void goToConstructorViaLogo() {
        click(logoStellarBurgers);
    }

    @Step("Кликнуть на 'Личный Кабинет' в хедере")
    public void clickPersonalAccount() {
        click(personalAccountLink);
    }

    @Step("Проверить, что виден текст с информацией о профиле")
    public SelenideElement getProfileInfoText() {
        return profileInfoText;
    }

    @Step("Проверить, что видна ссылка 'Профиль' (признак личного кабинета)")
    public SelenideElement getProfileTitle() {
        return profileTitle;
    }
}