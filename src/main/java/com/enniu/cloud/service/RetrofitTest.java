package com.enniu.cloud.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

/*********************************
 *                               *
 Created by daipengfei on 16/11/3.
 *                               *
 ********************************/

public class RetrofitTest {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        RetrofitTestApi adapter = retrofit.create(RetrofitTestApi.class);
        Call<Object> objectCall = adapter.testConnection("2");
        System.out.println(objectCall.execute().body());
    }


    public interface RetrofitTestApi{
        @GET(value = "user/{userId}")
        public Call<Object> testConnection(@Path("userId") String userId);

    }


}
