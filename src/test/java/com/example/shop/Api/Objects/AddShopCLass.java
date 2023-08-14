package com.example.shop.Api.Objects;

public class AddShopCLass extends SupportingClass {

    public String shopName;

    public Boolean shopPublic;

    public AddShopCLass() {
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public AddShopCLass(String shopName, boolean shopPublic) {

        this.shopName = shopName;
        this.shopPublic = shopPublic;
    }
}
