package com.lvjianet.rentcars.baseLibrary.presenter;

import android.content.Context;

import com.lvjianet.rentcars.baseLibrary.presenter.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;

/**
 * @author Cheng
 * @date 2018-05-07 14:49
 * @desc : Presenter层基类
 */

public abstract class BasePresenter<T extends BaseView> {

    T mView;

    @Inject
    LifecycleProvider lifecycleProvider;

    @Inject
    Context context;
}
