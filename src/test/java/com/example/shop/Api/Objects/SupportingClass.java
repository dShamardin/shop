package com.example.shop.Api.Objects;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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



    public void SetUp(){
        requestSpec = RestAssured.given();
        responseSpec = RestAssured.expect()
                .statusCode(200);
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200);
        responseSpec = specBuilder.build();
    }


    public static ResponseSpecification responseShopDtoWithJson() {
        return new ResponseSpecBuilder()
                .expectContentType(JSON)
                .expectStatusCode(200)
                .build();
    }

    public static void startResponseSpecification(ResponseSpecification responseSpec) {
        RestAssured.responseSpecification = responseSpec;
    }

}
