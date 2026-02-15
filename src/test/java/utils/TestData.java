package utils;

import java.time.LocalDate;
import java.util.UUID;

public class TestData {

    public static String generateRandomEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 8) + "@mail.com";
        //return "user" + LocalDate.now() + "@mail.com";

    }

    public static String generateRandomName() {
        return "User" + UUID.randomUUID().toString().substring(0, 4);
        //return "user";
    }

    public static String defaultPassword() {
        return "123456";
    }
}
