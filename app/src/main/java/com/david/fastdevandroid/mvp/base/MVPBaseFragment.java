package com.david.fastdevandroid.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.david.fastdevandroid.BaseFragment;
import com.lzy.okgo.OkGo;


public abstract class MVPBaseFragment<V, T extends BasePresenter<V>> extends BaseFragment {

    protected T mPresenter; // Presenter对象

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPresenter = createPresenter(); // 创建Presenter
        mPresenter.attachView((V) this);

        mPresenter.onCreateView((V) this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        /**
         *  子activity退出时 取消相应网络请求
         */
        OkGo.getInstance().cancelTag(this.getClass().getSimpleName());

        if (mPresenter.isViewAttached()) {
            mPresenter.detachView();
            mPresenter.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onResult(requestCode, resultCode, data);
    }

    protected abstract T createPresenter();
}
