package com.lvjianet.rentcars;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.lvjianet.rentcars.baseLibrary.presenter.BasePresenter;
import com.lvjianet.rentcars.baseLibrary.ui.activity.BaseMvpActivity;
import com.lvjianet.rentcars.baseLibrary.ui.utils.ToastUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<BasePresenter> {
    @Inject
    ToastUtil toastUtil;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.share)
    Button share;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void injectComponent() {

    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            toastUtil.showToast("成功了");
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            toastUtil.showToast("失败" + t.getMessage());
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            toastUtil.showToast("取消了");

        }
    };

    @Override
    public void onError(String message) {

    }

    @OnClick(R.id.share)
    public void onClick() {
        new ShareAction(MainActivity.this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).open();
    }
}
