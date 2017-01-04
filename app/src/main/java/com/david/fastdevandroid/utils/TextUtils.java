package com.david.fastdevandroid.utils;

/**
 * Created by Administrator on 2016/8/18.
 */
public class TextUtils {
    /**
     * 将讲话号码处理成中间带*号
     * 如：1865****333
     * @param tel
     * @return
     */
    public static String telPhoneHandle(String tel) {
        if (tel.length() < 4) return "";
        String telFirst = tel.substring(0, 4);
        String telEnd = tel.substring(tel.length() - 3, tel.length());
        return telFirst + "****" + telEnd;
    }
}
