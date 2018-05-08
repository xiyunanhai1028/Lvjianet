package com.lvjianet.rentcars.baseLibrary.rx;

/**
 * @author Cheng
 * @date 2018-05-07 14:28
 * @desc : 自定义通用异常
 */

public class BaseException extends Throwable {

    public final int status;
    public final String message;

    public BaseException(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
