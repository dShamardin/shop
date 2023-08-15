package com.example.shop.Api.Objects;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.http.ContentType.JSON;

public class SupportingClass {


    public static Faker faker = new Faker();
    public static AddShopCLass generateNewShop() {
        String shopName = faker.name().username();
        Boolean shopPublic = faker.random().nextBoolean();
        return new AddShopCLass();
    }

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setBaseUri() {
        RestAssured.baseURI = "http://localhost:4000/";
    }
}
