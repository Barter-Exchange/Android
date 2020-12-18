package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Classes.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignalUserService {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public void signal(int user,String date,String description,Boolean treated) {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();
        try {
            obj.put("user", 6);
            obj.put("date", date);
            obj.put("description", description);
            obj.put("treated", treated);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/signal")
                .post(body)
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
}
