package com.lvjianet.rentcars.baseLibrary.ui.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author dufeihu
 * @date 2018/5/8 0008.
 * @desc:
 */
public class ToastUtil {
    private Context context;

    public ToastUtil(Context context) {
        this.context = context;
    }

    public void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
