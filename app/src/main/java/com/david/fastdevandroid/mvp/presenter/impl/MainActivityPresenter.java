package com.david.fastdevandroid.mvp.presenter.impl;


import com.david.fastdevandroid.mvp.base.BasePresenter;
import com.david.fastdevandroid.mvp.presenter.IMainActivityPresenter;
import com.david.fastdevandroid.mvp.view.MainActivity;
import com.david.fastdevandroid.utils.LogUtil;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


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
                  /*      if (getView() == null) {
                            return null;
                        } else*/
                        getView().setText(str);
                        return null;
                    }
                })
//                .compose(getView().bindToLifecycle())//完成Observable发布的事件和当前的组件绑定，实现生命周期同步。从而实现当前组件生命周期结束时，自动取消对Observable订阅。
                .compose(getView().bindUntilEvent(ActivityEvent.DESTROY))//绑定到lifeCycle后，Activity Ondestory时 会自动停止订阅，
                .subscribe();

    }



}
