package com.example.shop.Api;

import com.example.shop.Api.Objects.GetShopClass;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.example.shop.Api.Objects.SupportingClass.requestSpec;

public class BaseApiTest {

    RequestSpecification requestSpec;
    ResponseSpecification responseGetShopClass;
    ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    static Faker faker = new Faker();

    @BeforeEach
    public void setBase() {
        RestAssured.baseURI = MAIN_URL;
        faker = new Faker();
    }


    public final static String MAIN_URL = "http://localhost:4000/";
    public final static String PATH_SHOPS = "shops/";
    public final static String PATH_GET_ADD_SHOPS = "shops/add";
    public final static String PATH_GET_ALL_SHOPS = "shops/all";
    public final static String PATH_GET_SHOP_ID = "shops/";
    public final static String PATH_DELETE_SHOP_ID = "delete/";



    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @BeforeEach
    public void setup() {
        RequestSpecification requestSpecification = new RequestSpecBuilder().build();
    }
}

