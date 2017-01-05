package com.david.fastdevandroid.adapter.base;

/**
 * 点击事件的接口
 * Created by david
 */
public interface OnViewClickListener<V> {

    /**
     * 当item被点击的时候进行事件分发
     *
     * @param itemValue 点击的item传递的值
     * @param viewID    点击控件的id
     * @param position  被点击的item的位置
     */
    void onViewClick(V itemValue, int viewID, int position);
}
