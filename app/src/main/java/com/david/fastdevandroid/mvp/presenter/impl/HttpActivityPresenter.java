package com.david.fastdevandroid.mvp.presenter.impl;

import com.david.fastdevandroid.mvp.base.BasePresenter;
import com.david.fastdevandroid.mvp.view.HttpActivity;
import com.david.fastdevandroid.okgohttp.HttpApis;
import com.david.fastdevandroid.okgohttp.HttpHandler;
import com.david.fastdevandroid.okgohttp.callback.JsonCallback;
import com.david.fastdevandroid.okgohttp.callback.JsonDialogCallback;
import com.david.fastdevandroid.okgohttp.entity.BannerBean;
import com.david.fastdevandroid.okgohttp.entity.User;
import com.david.fastdevandroid.utils.MD5Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/18.
 */

public class HttpActivityPresenter extends BasePresenter<HttpActivity> {

    public void postRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("encodestr", MD5Utils.ecodeTwice("get_bannerview"));
        HttpHandler.getInstance(getView()).postRequest(map, HttpApis.GET_BANNERVIEW, new JsonCallback<List<BannerBean>>(getView()) {
            @Override
            public void onSuccess(List<BannerBean> beans, Call call, Response response) {
                getView().setReustText("Post" + beans.get(0).toString());
            }
        });
    }


    public void postWithDialogRequest() {
        Map<String, String> map = new HashMap<>();

        map.put("name", "Davids");
        HttpHandler.getInstance(getView()).postRequest(map, HttpApis.MYSERVICETEST, new JsonDialogCallback<List<User>>(getView()) {
            @Override
            public void onSuccess(List<User> bannerBeen, Call call, Response response) {
                getView().setReustText("Post with Dialog" + bannerBeen.get(0).toString());
            }
        });
    }
}
