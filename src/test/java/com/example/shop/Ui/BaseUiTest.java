package com.example.shop.Ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getFocusedElement;

public class BaseUiTest {

    public SelenideElement Greetings = $("#greetings > h1");

    public SelenideElement MainPicture = $("html > body > header > img");

    public SelenideElement Button_Href_CREATE_SHOP = $("#links > a:first-of-type");

    public SelenideElement Button_Href_AllShops = $("#links > a:nth-of-type(2)");

    public SelenideElement Button_Href_DeleteShop = $("#links > a:nth-of-type(3)");

    public SelenideElement Button_Refresh = $("#shops_div > button");

    public SelenideElement Button_Createshop = $("#create > div > button");

    public SelenideElement checkbox = $("#public");

    public SelenideElement placeholderEnterShopName = $("#name");

    public SelenideElement Button_DeleteShop = $("#delete > div > button");

    public SelenideElement placeholderEnterShopId = $("#id");

    public SelenideElement Form_CreateShop = $("#create > div > h2");

    public SelenideElement Form_DeleateShop = $("#delete > div > h2");

    public SelenideElement Form_AlreadyCreatedShops = $("#shops_div > h2");

    public SelenideElement Body_Table = $("#response");

    public SelenideElement Button_Telegram =$("html > body > footer > div > a:first-of-type");

    public SelenideElement Button_VK = $("html > body > footer > div > a:nth-of-type(2)");



    public void CheckmainURL(){
        WebDriverRunner.url().equals("http://localhost:4000/");
    }
    public void CheckGreetingsHave(){
        Greetings.shouldHave(Condition.text("Welcome to our shop constructor!"));
    }
    public void CheckMainPictureHave(){
        MainPicture.shouldBe(Condition.visible);
    }
    public void Button_Href_CREATE_SHOPVisible(){
        Button_Href_CREATE_SHOP.shouldBe(Condition.visible);
    }
    public void Button_Href_AllShopsVisible(){
        Button_Href_AllShops.shouldBe(Condition.visible);
    }
    public void Button_Href_DeleteShopVisible(){
        Button_Href_DeleteShop.shouldBe(Condition.visible);
    }
    public void Button_Href_CREATE_SHOPClic(){
        Button_Href_CREATE_SHOP.click();
    }
    public void Form_CreateShopVisible(){
        Form_CreateShop.shouldBe(Condition.visible);
    }

    public void Button_Href_AllShopsClick(){
        Button_Href_AllShops.click();
    }
    public void Form_AlreadyCreatedShopsVisible(){
        Form_AlreadyCreatedShops.shouldBe(Condition.visible);
    }

    public void Button_Href_DeleteShopClick(){
        Button_Href_DeleteShop.click();
    }
    public void Form_DeleateShopVisible(){
        Form_DeleateShop.shouldBe(Condition.visible);
    }

    public void PlaceholderEnterShopNameSetValue(){
        placeholderEnterShopName.setValue("Create New Online shop№1");
    }
    public void CheckboxClick(){
        checkbox.click();
    }
    public void Button_CreateshopClick(){
        Button_Createshop.click();
    }
    public void Body_TableText(){
        Body_Table.shouldHave(Condition.text("Create New Online shop№1"));
    }
    public void placeholderEnterShopIdSetValue(){
        placeholderEnterShopId.setValue("8752");
    }
    public void Button_DeleteShopClick(){
        Button_DeleteShop.click();
    }
    public void Button_RefreshClick(){
        Button_Refresh.click();
    }

    public void Button_TelegramClick(){
        Button_Telegram.click();
    }

    public void TelegramURL(){
        WebDriverRunner.url().equals("https://web.telegram.org/a/");
    }

    public void Button_VKClick(){
        Button_VK.scrollTo().click();
    }
    public void VKURL(){
        WebDriverRunner.url().equals("https://m.vk.com/");
    }
}

