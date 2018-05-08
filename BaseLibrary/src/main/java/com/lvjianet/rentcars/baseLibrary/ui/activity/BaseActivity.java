package com.lvjianet.rentcars.baseLibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.lvjianet.rentcars.baseLibrary.common.AppManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;

/**
 * @author Cheng
 * @date 2018-05-07 14:57
 * @desc : Activity基类，业务无关
 */

public abstract class BaseActivity extends RxAppCompatActivity {
    private ImmersionBar mImmersionBar;

    /**
     * 做了最基本的初始化
     * 设置布局资源ID
     * 绑定ButterKnife
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建ImmersionBar（状态栏设置）
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();   //所有子类都将继承这些相同的属性

        int layoutId = getContentLayoutId();
        setContentView(layoutId);
        initWidget();

        AppManager.getInstance().addActivity(this);

        //Umeng统计应用启动数据
        PushAgent.getInstance(this).onAppStart();
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
    protected void initWidget() {
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销ImmersionBar
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        AppManager.getInstance().finishActivity(this);

    }
}
