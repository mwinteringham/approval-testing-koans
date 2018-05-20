package com.mwtestconsultancy.api;

import static io.restassured.RestAssured.given;

public class CarApi {

    private static String baseurl = "http://localhost:8080";

    public static int getInfoStatusCode(){
        return given()
                .get(baseurl + "/info")
                .getStatusCode();
    }

    public static String getCarResponseBody() {
        return given()
                .get(baseurl + "/car")
                .getBody()
                .prettyPrint();
    }

    public static String getInfoResponseBody() {
        return given()
                .get("/info")
                .getBody()
                .prettyPrint();
    }
}
