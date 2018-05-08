package com.lvjianet.rentcars.baseLibrary.injection.module;

import android.app.Activity;

import com.lvjianet.rentcars.baseLibrary.injection.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author Cheng
 * @date 2018-05-07 13:59
 * @desc : Activity级别Module
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity() {
        return this.activity;
    }
}
