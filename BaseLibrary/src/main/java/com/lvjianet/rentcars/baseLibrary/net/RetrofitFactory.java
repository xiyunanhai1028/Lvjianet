package com.lvjianet.rentcars.baseLibrary.net;

import com.lvjianet.rentcars.baseLibrary.common.BaseConstant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Cheng
 * @date 2018-05-07 11:13
 * @desc : Retrofit工厂
 */

public class RetrofitFactory {

    private Interceptor interceptor;
    private Retrofit retrofit;

    private static RetrofitFactory instance;

    /**
     * 外部获取单例
     *
     * @return RetrofitFactory
     */
    public static synchronized RetrofitFactory getInstance() {
        if (instance == null) {
            instance = new RetrofitFactory();
        }
        return instance;
    }

    private RetrofitFactory() {
        initInterceptor();
        initRetrofit();
    }

    /**
     * 初始化Retrofit
     */
    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build();
    }

    /**
     * okHttp客户端创建
     * 添加了通用拦截器和日志拦截器
     * 连接超时时间为 12S
     * 响应超时时间为 12S
     */
    private OkHttpClient initClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(12, TimeUnit.SECONDS)
                .readTimeout(12, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 初始化日志拦截器
     *
     * @return HttpLoggingInterceptor 日志拦截器
     */
    private HttpLoggingInterceptor initLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }


    /**
     * 初始化通用拦截器
     * 请求头中添加了token
     */
    private void initInterceptor() {
        interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content_Type", "application/json")
                        .addHeader("charset", "UTF-8")
//                        .addHeader("token",AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                        .build();
                return chain.proceed(request);
            }
        };
    }

    /**
     * 具体服务实例化
     *
     * @param service 网络服务接口
     * @return 具体实例
     */
    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}
