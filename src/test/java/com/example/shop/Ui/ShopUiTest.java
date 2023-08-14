package com.example.shop.Ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ShopUiTest {


    BaseUiTest baseUiTest = new BaseUiTest();


    @BeforeEach
    public void setSelenide() throws InterruptedException {
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("http://localhost:4000/");
        Thread.sleep(5000);
    }

    //Test №1
    @Test
    @DisplayName("Проверка отображения главной страницы: url, приветствие, наличие логотипа в заголовке")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckMainPageLocation() {
        step("Проверить главную страницу сайта Онлайн-магазинов, по адрессу", () -> {
           baseUiTest.CheckmainURL();
        });
        step("Приветствие на главной странице и наличие логотипа в заголовке", () -> {
           baseUiTest.CheckGreetingsHave();
           baseUiTest.CheckMainPictureHave();
        });

    }

    //Test №2
    @Test
    @DisplayName("Проверка наличия основных кнопок-ссылок в верхней части главной страницы")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckMainButtonsInTopsOfThePage() {
        step("Проверить наличие кнопок: Create shop, All shops, Delete shop", () -> {
            baseUiTest.Button_Href_CREATE_SHOPVisible();
            baseUiTest.Button_Href_AllShopsVisible();
            baseUiTest.Button_Href_DeleteShopVisible();
        });
    }

    //Test №3
    @Test
    @DisplayName("Проверка работоспособности основных кнопок-ссылок в верхней части главной страницы")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckWorkMainButtonsInTopsOfThePage() {
        step("Проверить кликабельность кнопок: Create shop, All shops, Delete shop", () -> {
            baseUiTest.Button_Href_CREATE_SHOPClic();
            baseUiTest.Form_CreateShopVisible();

            baseUiTest.Button_Href_AllShopsClick();
            baseUiTest.Form_AlreadyCreatedShopsVisible();

            baseUiTest.Button_Href_DeleteShopClick();
            baseUiTest.Form_DeleateShopVisible();
        });
    }

    //Test №4
    @Test
    @DisplayName("Проверка кнопки Create shop")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckButtonCreateShop() {
        step("Ввести в поле наименование магазина - название магазина, поставить отметку публичный, нажать кнопку " +
                "Create shop", () -> {
            baseUiTest.PlaceholderEnterShopNameSetValue();
            baseUiTest.CheckboxClick();
            baseUiTest.Button_CreateshopClick();
            actions().keyDown(Keys.ENTER).click();
        });

        step("Подтвердить действие на странице, проверить добавление магазина в список магазинов", () -> {
            actions().keyDown(Keys.ENTER).click();
            baseUiTest.Body_TableText();
        });

    }

    //Test №5
    @Test
    @DisplayName("Проверка кнопки All shops")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckButtonAllShop() {
        step("Проверить переход по кнопке-ссылке All shops, к списку магазинов", () -> {
            baseUiTest.Button_Href_AllShopsClick();
            baseUiTest.Form_AlreadyCreatedShopsVisible();
        });
    }

    //Test №6
    @Test
    @DisplayName("Проверка кнопки Delete shop")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckButtonDeleteShop() {
        step("Ввести в поле Enter shop id - id магазина, нажать кнопку Delete shop", () -> {
            baseUiTest.placeholderEnterShopIdSetValue();
            baseUiTest.Button_DeleteShopClick();
        });

        step("Подтвердить действие на странице", () -> {
            actions().keyDown(Keys.ENTER).click();
        });
    }

    //Test №7
    @Test
    @DisplayName("Проверка кнопки refresh")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckRefreshButton() {
        step("Проверить рабоспособность кнопки refresh, проверить что на главной странице отображаетя адрес," +
                "приветствие, наличие логотипа", () -> {
            baseUiTest.Button_RefreshClick();
            baseUiTest.CheckmainURL();
            baseUiTest.CheckGreetingsHave();
            baseUiTest.CheckMainPictureHave();

        });
    }

    //Test №8
    @Test
    @DisplayName("Проверка кнопки Telegram. Flaky Test")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckTelegramButton() {
        step("Нажать на кнопку Telegram", () -> {
            baseUiTest.Button_TelegramClick();
        });
        step("Проверить переход на страницу Telegram", () -> {
            baseUiTest.TelegramURL();
        });

    }

    //Test №9
    @Test
    @DisplayName("Проверка кнопки VK. Тест падает.")
    @Feature("Меню")
    @Story("Главная страница")
    public void ShouldCheckVKButton() {
        step("Нажать на кнопку VK", () -> {
            baseUiTest.Button_VKClick();
        });
        step("Проверить переход на страницу VK", () -> {
            baseUiTest.VKURL();
            Thread.sleep(5000);
        });
    }
}