package com.david.fastdevandroid.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.mvp.base.MVPBaseActivity;
import com.david.fastdevandroid.mvp.presenter.impl.GreenDaoPresenter;
import com.david.fastdevandroid.utils.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/5.
 */

public class GreenDaoActivity extends MVPBaseActivity<GreenDaoActivity, GreenDaoPresenter> {

    private GreenDaoPresenter presenter = new GreenDaoPresenter();
    @BindView(R.id.tv_datas)
    TextView tv_datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);

    }

    @OnClick({R.id.btn_insert, R.id.btn_delete,R.id.btn_update,R.id.btn_query})
    void myOnClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_insert:
                presenter.insertData();
                break;
            case R.id.btn_delete:
                presenter.deleteData();
                break;
            case R.id.btn_update:
                presenter.update();
                break;
            case R.id.btn_query:
                presenter.query();
                break;
        }

    }

    public void showDatas(String datas){
        tv_datas.setText(datas);
    }

    @Override
    protected GreenDaoPresenter createPresenter() {
        return presenter;
    }
}
