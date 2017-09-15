package br.com.geq.ggti.okhttp.handler;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 750371415 on 15/09/2017.
 */

public class OkHttp extends AsyncTask<String, Void, String> {

    OkHttpClient client = new OkHttpClient();
    String username, pass;

    public OkHttp(String username, String pass){
        this.username = username;
        this.pass = pass;
    }

    @Override
    protected String doInBackground(String... params) {

        RequestBody body = new FormBody.Builder()
                .add("name", username)
                .add("pass", pass)
                .build();

        Request request = new Request.Builder()
                .url(params[0]).post(body).build();

        try {
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                throw new IOException("Unexpected code" + response.toString());
            }
            return response.body().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
