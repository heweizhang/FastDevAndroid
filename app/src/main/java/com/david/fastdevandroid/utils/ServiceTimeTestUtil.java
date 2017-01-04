package com.david.fastdevandroid.utils;

/**
 * Created by Administrator on 2016/8/19.
 */
public class ServiceTimeTestUtil {

    /**
     * 判断服务是否在有效期内
     * 服务到期时间戳如果小于当前时间戳，则为过期
     * @param serviceTime
     * @return
     */
    public static boolean ServiceIsValid(long serviceTime){
        if(serviceTime < DateUtils.getCurrentTime()){
            return false;
        }
        return true;
    }
}
