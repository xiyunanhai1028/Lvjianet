package com.lvjianet.rentcars.injection.component;

import com.lvjianet.rentcars.MainActivity;
import com.lvjianet.rentcars.baseLibrary.injection.ActivityScope;
import com.lvjianet.rentcars.baseLibrary.injection.component.ActivityComponent;
import com.lvjianet.rentcars.baseLibrary.injection.component.AppComponent;
import com.lvjianet.rentcars.baseLibrary.injection.module.ActivityModule;
import com.lvjianet.rentcars.baseLibrary.injection.module.LifecycleProviderModule;

import dagger.Component;

/**
 * @author dufeihu
 * @date 2018/5/8 0008.
 * @desc:
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = {ActivityModule.class, LifecycleProviderModule.class})
public interface MainComponent extends ActivityComponent{
    void inject(MainActivity mainActivity);
}
