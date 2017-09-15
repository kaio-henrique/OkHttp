package br.com.geq.ggti.okhttp.handler;

import android.os.AsyncTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 750371415 on 15/09/2017.
 */

public class OkHttpHandler extends AsyncTask<String, Void, byte[]> {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected byte[] doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);

        Request request = builder.build();

        try{

            Response response = client.newCall(request).execute();
            return response.body().bytes();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
