package com.lvjianet.rentcars.baseLibrary.net;

/**
 * @author Cheng
 * @date 2018-05-07 11:55
 * @desc : 响应结果基类
 */

public abstract class BaseResponse<T> {

    public final int status;
    public final String message;
    public final T data;

    /**
     * 构造函数
     *
     * @param status  响应状态码
     * @param message 响应文字消息
     * @param data    具体响应数据类对象
     */
    public BaseResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
