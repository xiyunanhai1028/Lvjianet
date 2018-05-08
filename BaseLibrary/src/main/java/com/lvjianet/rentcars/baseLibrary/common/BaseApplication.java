package com.lvjianet.rentcars.baseLibrary.common;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lvjianet.rentcars.baseLibrary.injection.component.AppComponent;
import com.lvjianet.rentcars.baseLibrary.injection.component.DaggerAppComponent;
import com.lvjianet.rentcars.baseLibrary.injection.module.AppModule;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;

/**
 * @author Cheng
 * @date 2018-05-07 11:05
 * @desc : 自定义Application
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initAppInjection();

        instance = this;

        //ARouter初始化
        ARouter.openLog();  // 打印日志
        ARouter.openDebug();
        ARouter.init(this);

        //初始化Umeng
        initUmeng();
    }

    private void initUmeng() {
        UMConfigure.init(this, "5af01f38f29d98664d000109", "Lvjianet", UMConfigure.DEVICE_TYPE_PHONE, "779426f0f0928a92ec92b32952375074");

        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("df", "onSuccess: "+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("1106883868", "XP5vWg2sLGu67OTK");
    }

    /**
     * 外部获取单例
     *
     * @return Application
     */
    public static BaseApplication getInstance() {
        return instance;
    }

    /**
     * Application Component初始化
     */
    private void initAppInjection() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
