package com.heyi.consumptiondemo.net.module;

import com.heyi.consumptiondemo.config.Config;
import com.heyi.consumptiondemo.net.ApiClient;
import com.heyi.consumptiondemo.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2019/3/20.
 */
@Module
public class ApiModule {

    @Provides
    public OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Config.OUT_TIME_SECOND, TimeUnit.SECONDS);
        builder.writeTimeout(Config.OUT_TIME_SECOND, TimeUnit.SECONDS);
        builder.readTimeout(Config.OUT_TIME_SECOND, TimeUnit.SECONDS);
        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.e("net", message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));
        return builder.build();
    }

    @Provides
    public ApiClient getApiClient(OkHttpClient okHttpClient) {
        return ApiClient.getInstance(okHttpClient);
    }
}
