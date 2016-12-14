package com.david.fastdevandroid.okgohttp;

import com.david.fastdevandroid.utils.LogUtil;

import java.util.Map;

/**
 * Created by David on 2016/8/11.
 */
public class FormPrintUtil {
    public static void printParams(String tag,Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                LogUtil.e(tag, entry.getKey().toString() + ":" + entry.getValue().toString());
            }
        }
    }
}


