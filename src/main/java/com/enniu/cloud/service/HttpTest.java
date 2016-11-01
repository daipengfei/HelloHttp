package com.enniu.cloud.service;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*********************************
 *                               *
 Created by daipengfei on 16/10/27.
 *                               *
 ********************************/

public class HttpTest {
    public static void main(String[] args) throws IOException {
        final OkHttpClient client = new OkHttpClient.Builder().
                readTimeout(5, TimeUnit.SECONDS).build();

        Request request = new Request.Builder()
                .url("http://localhost:8080/user/1")
                .build();

        Response response = client.newCall(request).execute();

        record(client);

        exeAsync(client, request);

    }

    private static void record(final OkHttpClient client) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    System.out.println(client.dispatcher().queuedCallsCount());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        //ignore
                    }
                }
            }
        }).start();
    }

    private static void exeAsync(OkHttpClient client, Request request) {
        for(int i=0;i<600000000;i++){
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                       //ignore
                    }
                    System.out.println(response.body().string());
                }
            });
        }
    }
}
