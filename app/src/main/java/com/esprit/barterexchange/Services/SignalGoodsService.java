package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Classes.Goods;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SignalGoodsService {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    ArrayList<Goods> goods = new ArrayList<>();

    public ArrayList<Goods> getAllGoods() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/getGoods")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                Gson gson = new Gson();
                Goods[] goodsArray = gson.fromJson(response.body().string(), Goods[].class);
                Collections.addAll(goods, goodsArray);

            }
        });

        return goods;

    }
}
