package com.david.fastdevandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.networking.http.entity.LoginDataBean;

/**
 * Created by Administrator on 2016/8/11.
 */
public class SharedPreferencesUtils {
    public static SharedPreferencesUtils instance;
    public static Context context;
    private static SharedPreferences sharedPreferences;

    public SharedPreferencesUtils(Context context) {
        this.context = context;
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtils(context);
        }
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(AppConfig.SharedPreferencesFileName, context.MODE_PRIVATE);
        }
        return instance;
    }

    public void setToLogined(LoginDataBean bean) {
        if (sharedPreferences == null || bean == null) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("u_phone", bean.getU_phone() + "");
        editor.putString("u_portrait", bean.getU_portrait() + "");
        editor.putString("u_name", bean.getU_name() + "");
        editor.putString("u_session", bean.getU_session() + "");
        editor.putString("gender", bean.getGender() + "");
        editor.putString("wechat_num", bean.getWechat_num() + "");
        editor.putString("card_name", bean.getCard_name() + "");
        editor.putString("card_addr", bean.getCard_addr() + "");
        editor.putString("card_describe", bean.getCard_describe() + "");
        editor.putString("card_qr_url", bean.getCard_qr_url() + "");
        editor.putLong("privilege_up", bean.getPrivilege_up());
        editor.putLong("privilege_vip", bean.getPrivilege_vip());
        editor.putLong("privilege_god", bean.getPrivilege_god());
        editor.putLong("privilege_free", bean.getPrivilege_free());
        editor.putInt("free_toup_margin", bean.getFree_toup_margin());
        editor.putInt("contract_import_num", bean.getContract_import_num());
        editor.commit();
    }

    public void setToUnLogined() {
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("u_phone", "");
        editor.putString("u_portrait", "");
        editor.putString("u_name", "");
        editor.putString("u_session", "");
        editor.putString("gender", "1");
        editor.putString("wechat_num", "");
        editor.putString("card_name", "");
        editor.putString("card_addr", "");
        editor.putString("card_describe", "");
        editor.putString("card_qr_url", "");

        editor.putLong("privilege_up", 0);
        editor.putLong("privilege_vip", 0);
        editor.putLong("privilege_god", 0);
        editor.putLong("privilege_free", 0);

        editor.putInt("free_toup_margin", 0);
        editor.putInt("contract_import_num", 0);
        editor.commit();
    }

    public void setLongData(String key,long data){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, data);
        editor.commit();
    }
    public void setIntData(String key,long data){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, data);
        editor.commit();
    }


    public boolean isLogined() {
        if (sharedPreferences == null) {
            return false;
        }
        if (!sharedPreferences.getString("u_session", "").equals("")) {
            return true;
        }
        return false;
    }

    public String getStringByKey(String key) {
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(key, "");
    }

    public long getLongByKey(String key) {
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong(key, 0);
    }

    public int getIntByKey(String key) {
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(key, 0);
    }

    public void updata_unLogined_contacts_inputed_num(int addNum) {
        if (sharedPreferences == null) {
            return;
        }
        int inputed_num = getIntByKey("inputed_num");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("inputed_num", addNum + inputed_num);
        editor.commit();
    }


    public void setLastPopTime(String time){
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("last_pop_time", time);
        editor.commit();
    }
}
