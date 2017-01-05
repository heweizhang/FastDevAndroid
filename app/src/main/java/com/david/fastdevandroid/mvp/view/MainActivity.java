package com.david.fastdevandroid.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.adapter.FuncAdapter;
import com.david.fastdevandroid.adapter.base.OnViewClickListener;
import com.david.fastdevandroid.mvp.base.MVPBaseActivity;
import com.david.fastdevandroid.mvp.presenter.impl.MainActivityPresenter;
import com.david.fastdevandroid.utils.LogUtil;

import java.util.List;

import butterknife.BindView;


public class MainActivity extends MVPBaseActivity<MainActivity, MainActivityPresenter> {

    private MainActivityPresenter presenter = new MainActivityPresenter();

    @BindView(R.id.rv_recyclerView)
    RecyclerView recyclerView;
    private FuncAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new FuncAdapter();
        adapter.setOnClickListener(new OnViewClickListener<String>() {
            @Override
            public void onViewClick(String itemValue, int viewID, int position) {

                presenter.getIntentTarget(position);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        presenter.getFuncData();
    }

    public void setData(List<String> list){
        adapter.refreshData(list);
    }

    public void navigataIntent(Class s){
        startActivity(new Intent(this,s));
    }

    @Override
    protected MainActivityPresenter createPresenter() {
        return presenter;
    }
}
