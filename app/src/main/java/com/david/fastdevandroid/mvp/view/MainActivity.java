package com.david.fastdevandroid.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.mvp.base.MVPBaseActivity;
import com.david.fastdevandroid.mvp.presenter.impl.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MVPBaseActivity<MainActivity, MainActivityPresenter> {

    private MainActivityPresenter presenter = new MainActivityPresenter();

    private TextView tv_msg;
    private String TAG = "MainActivity";
    @BindView(R.id.rv_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_)
    TextView tv_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_.setText("wahah");
    }

    public void setText(String s) {
        tv_msg.setText(s);
    }

    @Override
    protected MainActivityPresenter createPresenter() {
        return presenter;
    }
}
