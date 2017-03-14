package com.david.fastdevandroid.mvp.model;

import android.app.Activity;
import android.content.Context;

import com.david.fastdevandroid.okgohttp.HttpApis;
import com.david.fastdevandroid.okgohttp.HttpHandler;
import com.david.fastdevandroid.okgohttp.callback.JsonDialogCallback;
import com.david.fastdevandroid.okgohttp.callback.RequestCallback;
import com.david.fastdevandroid.okgohttp.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by zhanghewei on 17/3/14.
 */

public class UserModel {

    public void getUserInfo(Context context, final RequestCallback<List<User>> requestCallback) {

        Map<String, String> map = new HashMap<>();
        map.put("name", "David");

        HttpHandler.getInstance(context).postRequest(map, HttpApis.MYSERVICETEST, new JsonDialogCallback<List<User>>((Activity) context) {
            @Override
            public void onSuccess(List<User> bannerBeen, Call call, Response response) {
                requestCallback.onSuccess(bannerBeen);
            }
        });
    }
}
