package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Classes.CurrentUser;
import com.esprit.barterexchange.Classes.Goods;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GoodsService {

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

    public void deleteOfAdmin(int a) {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();

        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/"+ a)
                .delete(body)
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
                    //System.out.println(response.body().string());
                }


            }
        });

    }

    public  ArrayList<Goods> getGoodsOfUser (){
        OkHttpClient client = new OkHttpClient();
        String url = "http://10.0.2.2:3000/"+ CurrentUser.getId();
        Request request = new Request.Builder()
                .url(url)
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
