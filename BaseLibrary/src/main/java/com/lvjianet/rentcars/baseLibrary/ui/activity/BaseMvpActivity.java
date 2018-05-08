package com.lvjianet.rentcars.baseLibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lvjianet.rentcars.baseLibrary.common.BaseApplication;
import com.lvjianet.rentcars.baseLibrary.injection.component.ActivityComponent;
import com.lvjianet.rentcars.baseLibrary.injection.component.DaggerActivityComponent;
import com.lvjianet.rentcars.baseLibrary.injection.module.ActivityModule;
import com.lvjianet.rentcars.baseLibrary.injection.module.LifecycleProviderModule;
import com.lvjianet.rentcars.baseLibrary.presenter.BasePresenter;
import com.lvjianet.rentcars.baseLibrary.presenter.view.BaseView;

import javax.inject.Inject;

/**
 * @author Cheng
 * @date 2018-05-07 15:16
 * @desc : Activity基类，业务相关
 */

public abstract class BaseMvpActivity<T extends BasePresenter>
        extends BaseActivity implements BaseView {

    @Inject
    T mPresenter;

    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initActivityInjection();
        injectComponent();
        initARouter();
    }

    /**
     * 初始Activity Component
     */
    private void initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(((BaseApplication) getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .lifecycleProviderModule(new LifecycleProviderModule(this))
                .build();
    }

    /**
     * ARouter注册
     */
    private void initARouter() {
        ARouter.getInstance().inject(this);
    }

    /**
     * Dagger注册
     * 子类必须实现
     */
    protected abstract void injectComponent();

}
