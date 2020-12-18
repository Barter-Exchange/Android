package com.esprit.barterexchange.Services;

import android.widget.Toast;

import com.esprit.barterexchange.Classes.CurrentUser;
import com.esprit.barterexchange.Classes.User;
import com.esprit.barterexchange.Profil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
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



public class UserServices {




    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public void login(String email, String password) {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();
        try {
            obj.put("email", email);
            obj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/login")
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

                }
                JsonElement userElement =  new JsonParser().parse(response.body().string());
                JsonObject userObject = userElement.getAsJsonObject();

                int id = userObject.get("ID").getAsInt();
                String FirstName = userObject.get("FirstName").getAsString();
                String LastName = userObject.get("LastName").getAsString();
                String Username = userObject.get("Username").getAsString();
                String email = userObject.get("email").getAsString();
                String password = userObject.get("password").getAsString();
                CurrentUser.setId(id);
                CurrentUser.setFirstName(FirstName);
                CurrentUser.setLastName(LastName);
                CurrentUser.setUsername(Username);
                CurrentUser.setEmail(email);
                CurrentUser.setPassword(password);
            }
        });

    }

    public void register(String FirstName,String LastName,String Username,String email, String password) {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();
        try {
            obj.put("FirstName", FirstName);
            obj.put("LastName", LastName);
            obj.put("Username", Username);
            obj.put("email", email);
            obj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/register")
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

    public void delete() {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();

        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/"+ CurrentUser.getId())
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


    public void getUser()
    {
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
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                   // System.out.println(myResponse);
                }
            }
        });
    }



    public void update(String FirstName,String LastName,String Username,String email, String password) {
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();
        try {
            obj.put("FirstName", FirstName);
            obj.put("LastName", LastName);
            obj.put("Username", Username);
            obj.put("email", email);
            obj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/"+ CurrentUser.getId())
                .put(body)
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
    //////////////////////////////////////////////////ADMIN SERVICES///////////////////////////////////////////////////////////////////////////////
    ArrayList<User> users = new ArrayList<>();
    public ArrayList<User> getAllUser()
    {
        OkHttpClient client = new OkHttpClient();
        String url = "http://10.0.2.2:3000/all";
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
                User[] userArray = gson.fromJson(response.body().string(), User[].class);
                Collections.addAll(users, userArray);


                //System.out.println(users);
            }
        });
        return users;

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
}
