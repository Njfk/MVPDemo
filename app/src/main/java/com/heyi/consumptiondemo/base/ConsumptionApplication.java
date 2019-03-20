package com.heyi.consumptiondemo.base;

import android.app.Application;

import com.heyi.consumptiondemo.net.component.AppComponent;
import com.heyi.consumptiondemo.net.component.DaggerAppComponent;
import com.heyi.consumptiondemo.net.module.ApiModule;
import com.heyi.consumptiondemo.net.module.AppModule;

/**
 * Created by Administrator on 2019/3/20.
 */

public class ConsumptionApplication extends Application{
    private static ConsumptionApplication consumptionApplication;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }
    public void initComponent(){
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static ConsumptionApplication getConsumptionApplication() {
        return consumptionApplication;
    }
}
