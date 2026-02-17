package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import utils.BrowserFactory;
import utils.TestData;
import utils.UserApi;

public class BaseTest {

    protected String testEmail;
    protected String testPassword;
    protected String testName;
    protected String accessToken;

    @Before
    public void setUp() {
        // Получаем имя браузера из системной переменной, по умолчанию - chrome
        String browser = System.getProperty("browser", "chrome");
        BrowserFactory.configureDriver(browser);

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        // Чтобы браузер не закрывался сразу после теста (удобно для отладки)
        // Configuration.holdBrowserOpen = true;

        testName = TestData.generateRandomName();
        testEmail = TestData.generateRandomEmail();
        testPassword = TestData.defaultPassword();

        // Создаём пользователя через API и получаем токен
        accessToken = UserApi.createUser(testName, testEmail, testPassword);
    }

    @After
    public void tearDown() {
        // Удаляем пользователя после теста, если он был создан
        if (accessToken != null) {
            UserApi.deleteUser(accessToken);
        }
        // Закрываем браузер после каждого теста
        Selenide.closeWebDriver();
    }
}