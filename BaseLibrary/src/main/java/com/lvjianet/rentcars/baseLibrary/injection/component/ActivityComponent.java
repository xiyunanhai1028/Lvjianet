package com.lvjianet.rentcars.baseLibrary.injection.component;

import android.app.Activity;
import android.content.Context;

import com.lvjianet.rentcars.baseLibrary.injection.ActivityScope;
import com.lvjianet.rentcars.baseLibrary.injection.module.ActivityModule;
import com.lvjianet.rentcars.baseLibrary.injection.module.LifecycleProviderModule;
import com.trello.rxlifecycle2.LifecycleProvider;

import dagger.Component;

/**
 * @author Cheng
 * @date 2018-05-07 13:44
 * @desc : Activity级别Component
 */


@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, LifecycleProviderModule.class})
public interface ActivityComponent {

    Activity activity();

    Context context();

    LifecycleProvider lifecycleProvider();
}
