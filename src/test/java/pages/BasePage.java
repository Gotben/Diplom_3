package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    @Step("Открыть страницу {url}")
    public void openUrl(String url) {
        open(url);
    }

    @Step("Клик на элемент")
    public void click(SelenideElement element) {
        element.click();
    }

    @Step("Ввести текст '{text}'")
    public void setValue(SelenideElement element, String text) {
        element.setValue(text);
    }
}