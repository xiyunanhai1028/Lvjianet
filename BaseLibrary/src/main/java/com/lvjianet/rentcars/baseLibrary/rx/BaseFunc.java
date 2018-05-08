package com.lvjianet.rentcars.baseLibrary.rx;

import com.lvjianet.rentcars.baseLibrary.net.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * @author Cheng
 * @date 2018-05-07 14:32
 * @desc : 通用数据类型转换封装
 */

public class BaseFunc<T> implements Function<BaseResponse<T>, Observable<T>> {

    @Override
    public Observable<T> apply(BaseResponse<T> response) throws Exception {
        // TODO: 2018/5/7 0007 暂未做任何处理
        return Observable.just(response.data);
    }
}
