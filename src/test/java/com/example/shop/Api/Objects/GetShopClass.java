package com.example.shop.Api.Objects;

import okhttp3.ResponseBody;

import java.util.List;

public class GetShopClass extends SupportingClass {

     static Long shopId;

     static String shopName;

     static Boolean shopPublic;

    public void setShopId(Long shopId) {
        this.shopId = faker.random().nextLong();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopName(String shopName) {
        this.shopName = faker.name().username();
    }

    public String getShopName() {
        return shopName;
    }

    public void  setShopPublic(boolean shopPublic) {
        this.shopPublic = faker.random().nextBoolean();
    }

    public Boolean isShopPublic() {
        return shopPublic;
    }

    public void GetShopClass(Long shopId, String shopName, Boolean shopPublic) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopPublic = shopPublic;
    }



}
