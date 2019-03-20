package com.heyi.consumptiondemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.heyi.consumptiondemo.R;
import com.heyi.consumptiondemo.net.component.AppComponent;
import com.heyi.consumptiondemo.net.component.DaggerAppComponent;
import com.heyi.consumptiondemo.view.LoadingDialog;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2019/3/20.
 */

public abstract class BaseAcitivity extends AppCompatActivity {

    Toolbar layout_toobar;
    TextView layout_title;

    LoadingDialog loadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        layout_toobar = ButterKnife.findById(this, R.id.layout_toobar);
        layout_title = ButterKnife.findById(this, R.id.layout_title);
        if (layout_toobar != null) {
            setSupportActionBar(layout_toobar);
            layout_title.setText(getToolbarTitle());
        }

        setupComponent(ConsumptionApplication.getConsumptionApplication().getAppComponent());

        initView();
        initData();

    }

    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView();

    public abstract void setupComponent(AppComponent appComponent);

    public abstract String getToolbarTitle();


    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this, R.style.loadingStyle);
        }
        loadingDialog.show();
    }

    public void dismissLoading() {
        loadingDialog.dismiss();
        loadingDialog.cancel();
    }


}
