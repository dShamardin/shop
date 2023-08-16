package com.example.shop.Api.Objects;

import com.example.shop.Api.BaseApiTest;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiUtil extends BaseApiTest {

    private final static String baseUrl = MAIN_URL;

    public static Object createOnlineShopByApi() throws IOException {
        OkHttpClient client = new OkHttpClient();

        final String name = "New Online Shop Created By API";

        final Long Id = 123L;

        final Boolean Public_status = true;

        FormBody formBody = new FormBody(
                List.of("New Online Shop Created By API",
                        "123L",
                        "true"),
                List.of(name
                ));

        Request postRequest = new Request.Builder()
                .url(MAIN_URL + "/api/createOnlineShop")
                .post(formBody)
                .build();

        Call call = client.newCall(postRequest);

        Response r = call.execute();
        assertTrue(r.isSuccessful());

        return new JSONObject()
                .put("New Online Shop Created By API", name)
                .put("123L", Id)
                .put("true", Public_status);
    }
}