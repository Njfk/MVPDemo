package com.heyi.consumptiondemo.net;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2019/3/20.
 */

public abstract class ApiCallBack<T> implements FlowableSubscriber<T> {
    public abstract void onSuccess(T t);
    public abstract void onFailure(String msg);
    public abstract void onFinish();

    @Override
    public void onSubscribe(@NonNull Subscription s) {
        s.request(2);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        onFailure(t.getMessage());
        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
