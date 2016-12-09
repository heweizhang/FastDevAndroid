package com.david.fastdevandroid.okgohtp.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.view.Window;


import com.david.fastdevandroid.okgohtp.ApiException;
import com.david.fastdevandroid.utils.ToastUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.request.BaseRequest;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 带Loading Dialog ..
 * 带Json 解析
 * Created by Administrator on 2016/10/11.
 */

public abstract class JsonDialogCallback<T> extends AbsCallback<T> {
    private ProgressDialog dialog;
    private Activity activity;

    public JsonDialogCallback(final Activity activity) {
        this.activity = activity;
        dialog = new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                /**
                 * 用户点击取消按钮时 取消对应请求任务
                 */
                OkGo.getInstance().cancelTag(activity.getClass().getSimpleName());
            }
        });
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //网络请求前显示对话框
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable T t, @Nullable Exception e) {
        super.onAfter(t, e);
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public T convertSuccess(Response response) throws Exception {

        //获取后台返回的json字符串
        String s = StringConvert.create().convertSuccess(response);
        response.close();

        //以下代码是通过泛型解析实际参数,泛型必须传
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        JSONObject jsonObject = new JSONObject(s);
        int code = jsonObject.getInt("errcode");
        if (code != 0) {
            throw new ApiException("xindong" + jsonObject.getString("error_message"));
//            throw new ApiException(jsonObject.getString("error_message"));
            /*ToastUtils.show(activity, jsonObject.getString("error_message"));
            return null;*/
        }

        Gson gson = new Gson();
        //传入TypeToken
        T a = gson.fromJson(jsonObject.getString("data"), params[0]);
        return (T) a;
    }

    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
//        LogUtil.e("info", "code:" + response.code());
        if (e != null) {
            if ((response != null && response.code() == 404) || (response != null && response.code() == 500)) {
                ToastUtils.show(activity, "服务器未响应，请联系管理员...");

            } else if (e.getMessage().startsWith("xindong")) {
                ToastUtils.show(activity, e.getMessage().substring(7, e.getMessage().length()));
                if( e.getMessage().substring(7, e.getMessage().length()).equals("身份过期，请重新登录")){
//                    SharedPreferencesUtils.getInstance(activity).setToUnLogined();
                }
            } else {
                ToastUtils.show(activity, "连接中断，请检查网络...");
            }

        }
    }
}
