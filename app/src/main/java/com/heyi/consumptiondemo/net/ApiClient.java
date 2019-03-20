package com.heyi.consumptiondemo.net;

import com.heyi.consumptiondemo.config.Config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/3/20.
 */

public class ApiClient {
    public static ApiClient apiClient;
    private ApiStore apiStore;

    public ApiClient(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BASE_URL)
                .build();
        apiStore = retrofit.create(ApiStore.class);

    }

    public static ApiClient getInstance(OkHttpClient okHttpClient){
        if (apiClient == null){
            apiClient = new ApiClient(okHttpClient);
        }
        return apiClient;
    }
}
