package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserApi {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru/api";

    public static String createUser(String name, String email, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("email", email);
        body.put("password", password);

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(body)
                .post(BASE_URL + "/auth/register");

        response.then().statusCode(200);
        return response.jsonPath().getString("accessToken");
    }

    public static void deleteUser(String accessToken) {
        RestAssured
                .given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/auth/user")
                .then().statusCode(202);
    }

    public static String login(String email, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(body)
                .post(BASE_URL + "/auth/login");

        if (response.statusCode() == 200) {
            return response.jsonPath().getString("accessToken");
        }
        return null;
    }
}
