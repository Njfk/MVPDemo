package com.heyi.consumptiondemo.net.component;

import android.content.Context;

import com.heyi.consumptiondemo.net.ApiClient;
import com.heyi.consumptiondemo.net.module.ApiModule;
import com.heyi.consumptiondemo.net.module.AppModule;

import dagger.Component;

/**
 * Created by Administrator on 2019/3/20.
 */
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    Context getContext();
    ApiClient getApiClient();
}
