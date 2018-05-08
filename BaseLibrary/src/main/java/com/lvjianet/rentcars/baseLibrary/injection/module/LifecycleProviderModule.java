package com.lvjianet.rentcars.baseLibrary.injection.module;

import com.trello.rxlifecycle2.LifecycleProvider;

import dagger.Module;
import dagger.Provides;

/**
 * @author Cheng
 * @date 2018-05-07 14:03
 * @desc : RxLifecycle专用的Module
 */

@Module
public class LifecycleProviderModule {

    private final LifecycleProvider lifecycleProvider;

    public LifecycleProviderModule(LifecycleProvider lifecycleProvider) {
        this.lifecycleProvider = lifecycleProvider;
    }

    @Provides
    public LifecycleProvider provideLifecycleProvider() {
        return this.lifecycleProvider;
    }
}
