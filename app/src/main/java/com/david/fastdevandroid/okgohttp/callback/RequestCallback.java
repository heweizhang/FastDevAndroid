package com.david.fastdevandroid.okgohttp.callback;

/**
 * Created by zhanghewei on 17/3/14.
 */

//网络请求成功结果回调
public interface RequestCallback<T> {
    void onSuccess(T t);
}
