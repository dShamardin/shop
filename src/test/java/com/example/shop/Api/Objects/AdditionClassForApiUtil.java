package com.example.shop.Api.Objects;

public class AdditionClassForApiUtil {
    static Long Id;

    static String name;

    static Boolean Public;
    public void setId(Long Id) {
        AdditionClassForApiUtil.Id = Id;
    }

    public Long getId() {
        return Id;
    }

    public void setName(String name) {
        AdditionClassForApiUtil.name = name;
    }

    public String getName() {
        return name;
    }

    public void  setPublic(boolean Public) {
        AdditionClassForApiUtil.Public = Public;
    }

    public Boolean isShopPublic() {
        return Public;
    }

    public AdditionClassForApiUtil(Long Id, String name, Boolean Public) {
        AdditionClassForApiUtil.Id = Id;
        AdditionClassForApiUtil.name = name;
        AdditionClassForApiUtil.Public = Public;
    }

}

