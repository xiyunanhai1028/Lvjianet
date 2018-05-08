package com.lvjianet.rentcars.baseLibrary.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Cheng
 * @date 2018-05-07 15:48
 * @desc : Fragment基类，业务无关
 */

public abstract class BaseFragment extends RxFragment {

    private View mRootView;
    private Unbinder mRootViewUnbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRootView == null) {
            int layoutId = getContentLayoutId();
            View rootView = inflater.inflate(layoutId, container, false);
            initWidget(rootView);
            mRootView = rootView;
        } else {
            if (mRootView.getParent() != null) {
                //将当前rootView的父布局中移除
                ((ViewGroup) mRootView.getParent()).removeView(mRootView);
            }
        }

        return mRootView;
    }

    /**
     * 获取当前界面对应的资源文件Id
     *
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     */
    protected void initWidget(View rootView) {
        mRootViewUnbinder = ButterKnife.bind(this, rootView);
    }
}
