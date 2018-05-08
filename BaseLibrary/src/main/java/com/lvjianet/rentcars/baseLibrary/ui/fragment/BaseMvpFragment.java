package com.lvjianet.rentcars.baseLibrary.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lvjianet.rentcars.baseLibrary.common.BaseApplication;
import com.lvjianet.rentcars.baseLibrary.injection.component.ActivityComponent;
import com.lvjianet.rentcars.baseLibrary.injection.component.DaggerActivityComponent;
import com.lvjianet.rentcars.baseLibrary.injection.module.ActivityModule;
import com.lvjianet.rentcars.baseLibrary.injection.module.LifecycleProviderModule;
import com.lvjianet.rentcars.baseLibrary.presenter.BasePresenter;
import com.lvjianet.rentcars.baseLibrary.presenter.view.BaseView;

import java.util.Objects;

import javax.inject.Inject;

/**
 * @author Cheng
 * @date 2018-05-07 15:55
 * @desc : Fragment基类，业务相关
 */

public abstract class BaseMvpFragment<T extends BasePresenter>
        extends BaseFragment implements BaseView {

    @Inject
    T mPresenter;

    ActivityComponent mActivityComponent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        initActivityInjection();
        injectComponent();

        return rootView;
    }

    /**
     * Dagger注册
     * 子类必须实现
     */
    protected abstract void injectComponent();

    /**
     * 初始化Activity级别Component
     */
    private void initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(((BaseApplication) Objects.requireNonNull(getActivity()).getApplication()).appComponent)
                .activityModule(new ActivityModule(getActivity()))
                .lifecycleProviderModule(new LifecycleProviderModule(this))
                .build();
    }

}
