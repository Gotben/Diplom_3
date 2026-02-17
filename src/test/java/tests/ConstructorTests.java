package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends BaseTest {

    private ConstructorPage constructorPage;
    private LoginPage loginPage;

    @Before
    public void setupPagesAndLogin() {
        constructorPage = new ConstructorPage();
        loginPage = new LoginPage();

        // Логинимся, чтобы попасть в конструктор
        loginPage.openUrl("https://stellarburgers.education-services.ru/login");
        loginPage.login(testEmail, testPassword);
    }

    @Test
    @DisplayName("Переход к разделу 'Булки' в конструкторе")
    public void navigateToBunsTabTest() {
        constructorPage.goToSauces(); // Сначала перейдем в другой раздел
        constructorPage.goToBuns();

        String actualTabName = constructorPage.getCurrentTabName();
        assertEquals("Активная вкладка не 'Булки'", "Булки", actualTabName);
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы' в конструкторе")
    public void navigateToSaucesTabTest() {
        constructorPage.goToSauces();

        String actualTabName = constructorPage.getCurrentTabName();
        assertEquals("Активная вкладка не 'Соусы'", "Соусы", actualTabName);
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки' в конструкторе")
    public void navigateToFillingsTabTest() {
        constructorPage.goToFillings();

        String actualTabName = constructorPage.getCurrentTabName();
        assertEquals("Активная вкладка не 'Начинки'", "Начинки", actualTabName);
    }
}