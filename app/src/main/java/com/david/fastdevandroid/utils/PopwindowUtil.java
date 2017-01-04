package com.david.fastdevandroid.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.networking.R;

/**
 * Created by Administrator on 2016/12/7.
 */

public class PopwindowUtil {

    private PopPositiveButtonListener listener;

    public void setPopPositiveButtonListener(PopPositiveButtonListener listener) {
        this.listener = listener;
    }

    public interface PopPositiveButtonListener {
        void setPopPositiveButtonListener();
    }

    public void showEasyPop(Context context, int layout_id, int titleId, int positiveBtnId, int negaticeBtnId, String title) {

        View contentView = LayoutInflater.from(context).inflate(layout_id, null);
        final PopupWindow popWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popWindow.setBackgroundDrawable(new ColorDrawable(0));
        //设置popwindow出现和消失动画
        popWindow.setAnimationStyle(R.style.AnimPopWondows);
        popWindow.setFocusable(true);
        //设置popwindow如果点击外面区域，便关闭。
        popWindow.setOutsideTouchable(false);
//        popWindow.update();
        popWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);

        TextView tv_title = (TextView) contentView.findViewById(titleId);
        tv_title.setText(title);
        TextView tv_positive = (TextView) contentView.findViewById(positiveBtnId);
        TextView tv_neagtice = (TextView) contentView.findViewById(negaticeBtnId);
        tv_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindow.dismiss();
                if (listener != null) {
                    listener.setPopPositiveButtonListener();
                }
            }
        });
        tv_neagtice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popWindow.dismiss();
            }
        });
    }
}
