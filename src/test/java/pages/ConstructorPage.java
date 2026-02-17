package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ConstructorPage extends BasePage {

    public ConstructorPage() {
        super();
    }

    private final SelenideElement constructorTitle = $x("//h1[normalize-space(text())='Соберите бургер']");
    private final SelenideElement tabBun = $x("//span[normalize-space(text())='Булки']");
    private final SelenideElement tabSauce = $x("//span[normalize-space(text())='Соусы']");
    private final SelenideElement tabFilling = $x("//span[normalize-space(text())='Начинки']");
    // Этот локатор указывает на активный таб
    private final SelenideElement currentTab = $x("//div[contains(@class, 'tab_tab_type_current__')]");

    @Step("Перейти на вкладку Булки")
    public void goToBuns() {
        click(tabBun);
        waitForTabToBeActive("Булки");
    }

    @Step("Перейти на вкладку Соусы")
    public void goToSauces() {
        click(tabSauce);
        waitForTabToBeActive("Соусы");
    }

    @Step("Перейти на вкладку Начинки")
    public void goToFillings() {
        click(tabFilling);
        waitForTabToBeActive("Начинки");
    }


    @Step("Получаем текст активного таба")
    public String getCurrentTabName() {
        currentTab.should(com.codeborne.selenide.Condition.visible);
        return currentTab.getText();
    }

    @Step("Ожидание, что вкладка '{tabName}' активна")
    private void waitForTabToBeActive(String tabName) {
        currentTab.shouldHave(com.codeborne.selenide.Condition.exactText(tabName));
    }


    @Step("Проверить, что заголовок конструктора виден")
    public SelenideElement getConstructorTitle() {
        return constructorTitle;
    }
}