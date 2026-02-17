package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public static void configureDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "yandex":
                // Путь к драйверу
                String yandexDriverPath = "src/test/resources/yandexdriver.exe";

                // Путь к браузеру - ТОЛЬКО из системной переменной!
                String yandexBrowserPath = System.getProperty("browserPath");

                if (yandexBrowserPath == null || yandexBrowserPath.isEmpty()) {
                    throw new RuntimeException(
                            "Для запуска в Яндекс.Браузере нужно указать путь к нему:\n" +
                                    "mvn clean test -Dbrowser=yandex -DbrowserPath=\"C:\\path\\to\\yandex\\browser.exe\""
                    );
                }

                System.setProperty("webdriver.chrome.driver", yandexDriverPath);

                ChromeOptions options = new ChromeOptions();
                options.setBinary(yandexBrowserPath);
                Configuration.browserCapabilities = options;
                Configuration.browser = "chrome";
                break;

            case "chrome":
            default:
                Configuration.browser = "chrome";
                break;
        }
    }
}