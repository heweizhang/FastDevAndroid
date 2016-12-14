package com.david.fastdevandroid.okgohttp.callback;

import android.app.Activity;


import com.david.fastdevandroid.okgohttp.ApiException;
import com.david.fastdevandroid.utils.ToastUtils;
import com.google.gson.Gson;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by zhanghewei on 2016/10/26.
 */

public abstract class JsonCallback<T> extends AbsCallback<T> {
    private Activity activity;

    public JsonCallback(final Activity activity) {
        this.activity = activity;
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
            throw new ApiException("wifipackage" + jsonObject.getString("error_message"));
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

            } else if (e.getMessage() != null && e.getMessage().startsWith("xindong")) {//自定义异常
                ToastUtils.show(activity, e.getMessage().substring(11, e.getMessage().length()));
                if (e.getMessage().substring(11, e.getMessage().length()).equals("身份过期，请重新登录")) {
//                    SharedPreferencesUtils.getInstance(activity).setToUnLogined();
                }
            } else {
                ToastUtils.show(activity, "连接中断，请检查网络...");
            }

        }
    }
}
