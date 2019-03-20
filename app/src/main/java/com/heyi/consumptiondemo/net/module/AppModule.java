package com.heyi.consumptiondemo.net.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2019/3/20.
 */
@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context getContext(){
        return context;
    }
}
