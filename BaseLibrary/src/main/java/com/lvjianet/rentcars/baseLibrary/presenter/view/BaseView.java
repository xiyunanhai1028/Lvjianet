package com.lvjianet.rentcars.baseLibrary.presenter.view;

/**
 * @author Cheng
 * @date 2018-05-07 14:46
 * @desc : View层回调基类
 */

public interface BaseView {

    /**
     * 数据源异常时回调
     *
     * @param message 错误信息
     */
    void onError(String message);

}
