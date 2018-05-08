package com.lvjianet.rentcars.baseLibrary.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Cheng
 * @date 2018-05-07 13:54
 * @desc : Activity级作用域
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
