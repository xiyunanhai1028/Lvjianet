package com.lvjianet.rentcars.baseLibrary.injection.module;

import android.content.Context;

import com.lvjianet.rentcars.baseLibrary.common.BaseApplication;
import com.lvjianet.rentcars.baseLibrary.ui.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Cheng
 * @date 2018-05-07 13:45
 * @desc : Application级别Module
 */

@Module
public class AppModule {

    private final BaseApplication context;

    public AppModule(BaseApplication context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return this.context;
    }

    @Singleton
    @Provides
    public ToastUtil provideToast(){
        return new ToastUtil(context);
    }
}
