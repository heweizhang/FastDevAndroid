package com.david.fastdevandroid.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.mvp.base.MVPBaseActivity;
import com.david.fastdevandroid.mvp.presenter.impl.GreenDaoPresenter;

/**
 * Created by Administrator on 2017/1/5.
 */

public class GreenDaoActivity extends MVPBaseActivity<GreenDaoActivity,GreenDaoPresenter> {

    private GreenDaoPresenter presenter = new GreenDaoPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
    }

    @Override
    protected GreenDaoPresenter createPresenter() {
        return presenter;
    }
}
