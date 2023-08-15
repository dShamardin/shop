package com.example.shop.Api;

import com.example.shop.Api.Objects.AddShopCLass;
import com.example.shop.Api.Objects.GetShopClass;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.example.shop.Api.Objects.ApiUtil.createOnlineShopByApi;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.hamcrest.Matchers.equalTo;

public class ShopApiTest extends BaseApiTest {

    GetShopClass getShopClass = new GetShopClass();


    @BeforeEach
    public void setUp() {
        requestSpec = given();
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder();
        responseGetShopClass = specBuilder.build();
    }

    //Test №1
    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Cоздание магазина")
    public void ShouldAddShop() {


            RequestSpecification request = RestAssured.given();

            AddShopCLass data = generateNewShop();
            given()
                    .body(data)
                    .when()
                    .post(PATH_GET_ADD_SHOPS)
                    .then();
        }

    //Test №2
    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Получение всех магазинов")
    public void ShouldGetAllShops() {

        Response response1 = given().get(PATH_GET_ALL_SHOPS);
        Assertions.assertThat(response1)
                .extracting(
                        Response::getStatusCode,
                        Response::getStatusLine
                )
                .contains(
                        200,
                        "HTTP/1.1 200 "
                );
    }

    //Test №3
    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Получение всех магазинов")
    public void ShouldGetAllShopsCase2() {
        requestSpec = RestAssured.given();
        List<GetShopClass> response = requestSpec
                .param("shopPublic", "true")
                .get(PATH_GET_ALL_SHOPS)
                .as(new TypeRef<>() {});
        Assertions.assertThat(response)
                .extracting(
                        GetShopClass::getShopId,
                        GetShopClass::getShopName,
                        GetShopClass::isShopPublic
                )
                .contains(
                        tuple(11752L,
                                "Create New Online shop№1",
                                true)
                );
    }

    //Test №4
    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Получение магазина по Id")
    public void ShouldGetShopNameById() {
        requestSpec = RestAssured.given();

        requestSpec
                .get(PATH_GET_SHOP_ID + 7952 )
                .then()
                .spec(responseGetShopClass)
                .body("shopName", equalTo("Online Store №1"));
    }

    //Test №5
    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Удаление магазина")
    public void ShouldDeleteOneShop() {
       when()
               .delete(PATH_DELETE_SHOP_ID + 8752)
               .then();
    }

    //Test №6
    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Cоздание магазина через Api")
    public void ShouldAddShopByApi() throws IOException {


        RequestSpecification request = RestAssured.given();

        JSONObject data = createOnlineShopByApi();
        given()
                .body(data)
                .when()
                .post(MAIN_URL + "/api/createOnlineShop")
                .then();
    }
}