package com.david.fastdevandroid.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by hasee on 2016/7/17.
 */
public abstract class BasePresenter<T> {

    /**
     * View接口类型的弱引用
     */
    protected Reference<T> mViewRef;

    /**
     * 建立关联
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    protected T getView() {
        return mViewRef == null ? null : mViewRef.get();//当Activity/Fragment被销毁的时候 ，BaseActivity 会调用 mPresenter.detachView();导致mViewRef = null
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected void onCreate(T view, Bundle saveState) {
    }

    protected void onCreateView(T view) {
    }

    protected void onResume() {
    }

    protected void onPause() {
    }

    protected void onStop() {
    }

    protected void onDestroy() {
    }

    protected void onSave(Bundle outState) {
    }

    protected void onResult(int requestCode, int resultCode, Intent data) {
    }
}
