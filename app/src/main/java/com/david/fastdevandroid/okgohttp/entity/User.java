package com.david.fastdevandroid.okgohttp.entity;

import java.io.Serializable;

/**
 * Created by zhanghewei on 17/1/21.
 */

public class User implements Serializable{

    /**
     * {
     "errcode":0,
     "data":[
     {
     "u_id":"2",
     "u_name":"David",
     "u_gender":"0",
     "u_account":"123457",
     "u_psw":"123456"
     }
     ]
     }
     */

    private String u_id;
    private String u_name;
    private String u_gender;
    private String u_account;
    private String u_psw;

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_gender='" + u_gender + '\'' +
                ", u_account='" + u_account + '\'' +
                ", u_psw='" + u_psw + '\'' +
                '}';
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_gender() {
        return u_gender;
    }

    public void setU_gender(String u_gender) {
        this.u_gender = u_gender;
    }

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getU_psw() {
        return u_psw;
    }

    public void setU_psw(String u_psw) {
        this.u_psw = u_psw;
    }
}
