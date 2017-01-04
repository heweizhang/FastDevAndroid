package com.david.fastdevandroid.mvp.presenter.impl;



import com.david.fastdevandroid.mvp.base.BasePresenter;
import com.david.fastdevandroid.mvp.presenter.IMainActivityPresenter;
import com.david.fastdevandroid.mvp.view.MainActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;


/**
 * Created by Administrator on 2016/12/7.
 */

public class MainActivityPresenter extends BasePresenter<MainActivity> implements IMainActivityPresenter {

    @Override
    public void delaytask(final String str) {
        Observable.timer(3000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .map(new Func1<Long, Object>() {
                    @Override
                    public Object call(Long aLong) {
                        if (getView() == null) {
                            return null;
                        } else
                            getView().setText(str);
                        return null;
                    }
                }).subscribe();

    }

}
