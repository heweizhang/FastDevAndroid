package com.david.fastdevandroid.mvp.presenter.impl;


import com.david.fastdevandroid.mvp.base.BasePresenter;
import com.david.fastdevandroid.mvp.presenter.IMainActivityPresenter;
import com.david.fastdevandroid.mvp.view.GreenDaoActivity;
import com.david.fastdevandroid.mvp.view.HttpActivity;
import com.david.fastdevandroid.mvp.view.MainActivity;
import com.david.fastdevandroid.utils.LogUtil;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by david on 2016/12/7.
 */

public class MainActivityPresenter extends BasePresenter<MainActivity> implements IMainActivityPresenter {

    private List<String> funcData = new ArrayList<>();

    @Override
    public void getFuncData() {
        funcData.add("GREEN DAO");
        funcData.add("RxJava Demo");
        funcData.add("http Demo");

        getView().setData(funcData);
    }

    @Override
    public void getIntentTarget(int position) {
        switch (position) {
            case 0:
                getView().navigataIntent(GreenDaoActivity.class);
                break;
            case 2:
                getView().navigataIntent(HttpActivity.class);

                break;

        }

    }
}
