package com.lvjianet.rentcars.baseLibrary.injection.component;

import android.content.Context;

import com.lvjianet.rentcars.baseLibrary.injection.module.AppModule;
import com.lvjianet.rentcars.baseLibrary.ui.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Cheng
 * @date 2018-05-07 13:44
 * @desc : Application级别Component
 */


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

     Context context();
     ToastUtil toastUtil();
}
