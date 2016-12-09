package com.david.fastdevandroid.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.david.fastdevandroid.BaseActivity;


public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends BaseActivity {
    protected T mPresenter; // Presenter对象
    private boolean isFirstCreate = true;   // 是否是第一次创建

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter(); // 创建Presenter
        mPresenter.attachView((V) this);

        mPresenter.onCreate((V) this, savedInstanceState);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mPresenter.onCreateView((V) this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter.isViewAttached()) {
            mPresenter.detachView();
            mPresenter.onDestroy();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onResult(requestCode, resultCode, data);
    }

    protected abstract T createPresenter();
}
