package com.david.fastdevandroid.mvp.model;

import android.app.Activity;
import android.content.Context;

import com.david.fastdevandroid.okgohttp.HttpApis;
import com.david.fastdevandroid.okgohttp.HttpHandler;
import com.david.fastdevandroid.okgohttp.callback.JsonCallback;
import com.david.fastdevandroid.okgohttp.callback.RequestCallback;
import com.david.fastdevandroid.okgohttp.entity.BannerBean;
import com.david.fastdevandroid.utils.MD5Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by zhanghewei on 17/3/14.
 */

public class BannerModel {
    public void postRequest(Context context, final RequestCallback<List<BannerBean>> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("encodestr", MD5Utils.ecodeTwice("get_bannerview"));
        HttpHandler.getInstance(context).postRequest(map, HttpApis.GET_BANNERVIEW, new JsonCallback<List<BannerBean>>((Activity) context) {
            @Override
            public void onSuccess(List<BannerBean> beans, Call call, Response response) {
                callback.onSuccess(beans);
            }
        });
    }
}
