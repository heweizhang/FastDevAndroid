package com.david.fastdevandroid.okgohttp;

import android.content.Context;


import com.david.fastdevandroid.okgohttp.callback.JsonCallback;
import com.david.fastdevandroid.okgohttp.callback.JsonDialogCallback;
import com.david.fastdevandroid.utils.LogUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/21.
 */

public class HttpHandler {
    private static HttpHandler instance;
    private static Context context;
    private static String TAG;

    public static HttpHandler getInstance(Context contex) {
        context = contex;
        TAG = context.getClass().getSimpleName();
        if (instance == null) {
            instance = new HttpHandler();
        }
        return instance;
    }

    /**
     * Dialog 提示
     * @param map
     * @param url
     * @param dialogCallback
     */
    public void postRequest(Map<String,String> map, String url, JsonDialogCallback dialogCallback){
        LogUtil.e("info","cacheKey:"+ TAG);
        OkGo.post(url)
                .tag(TAG)
                .params(map)
                .cacheKey(TAG)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)    /** 先使用缓存，不管是否存在，仍然请求网络 */
                .execute(dialogCallback);

    }

    /**
     * 不含Dialog 提示
     * @param map
     * @param url
     * @param callback
     */
    public void postRequest(Map<String,String> map, String url, JsonCallback callback){
        OkGo.post(url)
                .tag(TAG)
                .params(map)
                .cacheKey(TAG)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)    /** 先使用缓存，不管是否存在，仍然请求网络 */
                .execute(callback);

    }
}
