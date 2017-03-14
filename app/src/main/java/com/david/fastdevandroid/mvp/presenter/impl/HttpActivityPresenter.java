package com.david.fastdevandroid.mvp.presenter.impl;

import com.david.fastdevandroid.mvp.base.BasePresenter;
import com.david.fastdevandroid.mvp.model.BannerModel;
import com.david.fastdevandroid.mvp.model.UserModel;
import com.david.fastdevandroid.mvp.view.HttpActivity;
import com.david.fastdevandroid.okgohttp.HttpApis;
import com.david.fastdevandroid.okgohttp.HttpHandler;
import com.david.fastdevandroid.okgohttp.callback.JsonCallback;
import com.david.fastdevandroid.okgohttp.callback.JsonDialogCallback;
import com.david.fastdevandroid.okgohttp.callback.RequestCallback;
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

        new BannerModel().postRequest(getView(), new RequestCallback<List<BannerBean>>() {
            @Override
            public void onSuccess(List<BannerBean> bannerBeen) {
                getView().setReustText("Post" + bannerBeen.get(0).toString());

            }
        });

    }


    public void postWithDialogRequest() {

        new UserModel().getUserInfo(getView(), new RequestCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                getView().setReustText("Post with Dialog" + users.get(0).toString());

            }
        });

    }
}
