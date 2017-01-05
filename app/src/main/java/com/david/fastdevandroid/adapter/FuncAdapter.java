package com.david.fastdevandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.david.fastdevandroid.R;
import com.david.fastdevandroid.adapter.base.BaseAdapter;
import com.david.fastdevandroid.adapter.base.BaseViewHolder;
import com.david.fastdevandroid.adapter.base.OnViewClickListener;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/5.
 */

public class FuncAdapter extends BaseAdapter<String> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new SampleViewHolder(context, parent, R.layout.item_rv_funcs);
    }

    class SampleViewHolder extends BaseViewHolder<String> {

        @BindView(R.id.tv_func_name)
        Button func_name;


        public SampleViewHolder(Context context, ViewGroup root, int layoutRes) {
            super(context, root, layoutRes);
        }

        @Override
        protected void bindData(final String itemValue, final int position, final OnViewClickListener listener) {
            func_name.setText(itemValue);
            func_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onViewClick(itemValue, view.getId(), position);
                    }
                }
            });
        }
    }
}
