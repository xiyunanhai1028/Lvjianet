package com.lvjianet.rentcars.baseLibrary.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Cheng
 * @date 2018-05-07 14:42
 * @desc : Subscriber基类
 */

public abstract class BaseSubscriber<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

}
