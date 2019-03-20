package com.heyi.consumptiondemo.net.component;

import com.heyi.consumptiondemo.MainActivity;

import dagger.Component;

/**
 * Created by Administrator on 2019/3/20.
 */
@Component(dependencies = AppComponent.class)
public interface MainComponent {
    MainActivity inject(MainActivity mainActivity);
}
