package com.david.fastdevandroid.utils;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.networking.R;


public class LoadingDialogUtil {
    /**
     * 得到自定义的progressDialog
     *
     * @param context
     * @param msg
     * @return
     */
    public static Dialog createLoadingDialog(Context context, String msg) {

        View v = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);// 得到加载view
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        tipTextView.setText(msg);// 设置加载信息
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.setCancelable(true);// 可以用“返回键”取消
        loadingDialog.setContentView(v, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        return loadingDialog;
    }

    public static void showDialog(Dialog dialog) {
        if (null == dialog) {
            return;
        }
        dialog.show();
    }

    public static void dissMissDialog(Dialog dialog) {
        if (null == dialog) {
            return;
        }
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
