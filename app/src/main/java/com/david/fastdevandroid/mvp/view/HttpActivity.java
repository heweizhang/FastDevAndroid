package com.david.fastdevandroid.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.mvp.base.MVPBaseActivity;
import com.david.fastdevandroid.mvp.presenter.impl.HttpActivityPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18.
 */

public class HttpActivity extends MVPBaseActivity<HttpActivity,HttpActivityPresenter> {

    HttpActivityPresenter presenter = new HttpActivityPresenter();

    @BindView(R.id.tv_show_result)
    TextView showResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

    }

    @OnClick({R.id.btn_post_request,R.id.btn_post_request_dia})
    void myOnClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.btn_post_request:
                setReustText("");
                presenter.postRequest();
                break;
            case R.id.btn_post_request_dia:
                setReustText("");
                presenter.postWithDialogRequest();
                break;
        }
    }

    public void setReustText(String str){
        showResult.setText(str);
    }

    @Override
    protected HttpActivityPresenter createPresenter() {
        return presenter;
    }
}
