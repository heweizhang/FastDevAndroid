package com.david.fastdevandroid.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.mvp.base.MVPBaseActivity;
import com.david.fastdevandroid.mvp.presenter.impl.MainActivityPresenter;


public class MainActivity extends MVPBaseActivity<MainActivity, MainActivityPresenter> {

    private MainActivityPresenter presenter = new MainActivityPresenter();

    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_msg = (TextView) findViewById(R.id.tv_msg);
        findViewById(R.id.btn_show_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadImage("GOOD MORNINIG~");
            }
        });

    }

    public void setText(String s) {
        tv_msg.setText(s);
    }


    @Override
    protected MainActivityPresenter createPresenter() {
        return presenter;
    }
}
