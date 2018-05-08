package com.lvjianet.rentcars.baseLibrary.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * @author Cheng
 * @date 2018-05-07 09:40
 * @desc : Activity管理器
 */

public class AppManager {

    private static AppManager instance;
    private Stack<Activity> activityStack;

    private AppManager() {
        this.activityStack = new Stack<Activity>();
    }

    /**
     * 外部获取单例
     *
     * @return Application
     */
    public static AppManager getInstance() {
        return instance;
    }

    /**
     * Activity入栈
     */
    public void addActivity( Activity activity) {
        this.activityStack.add(activity);
    }

    /**
     * Activity出栈
     */
    public void finishActivity(Activity activity) {
        activity.finish();
        this.activityStack.remove(activity);
    }

    /**
     * 获取当前栈顶Activity
     */
    public final Activity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 清理栈
     */
    private void finishAllActivity() {
        for (Activity activity : activityStack) {
            activity.finish();
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public final void exitApp(Context context) {
        this.finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            throw new ClassCastException("null cannot be cast to non-null type android.app.ActivityManager");
        } else {
            activityManager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        }
    }
}
