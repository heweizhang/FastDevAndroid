package com.david.fastdevandroid.okgohttp.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/28.
 */

public class BannerBean implements Serializable {

    private String mysql_id;
    private String banner_image;
    private String banner_page_url;
    private String banner_title;

    @Override
    public String toString() {
        return "BannerBean{" +
                "mysql_id='" + mysql_id + '\'' +
                ", banner_image='" + banner_image + '\'' +
                ", banner_page_url='" + banner_page_url + '\'' +
                ", banner_title='" + banner_title + '\'' +
                '}';
    }

    public String getBanner_title() {
        return banner_title;
    }

    public String getMysql_id() {
        return mysql_id;
    }

    public void setMysql_id(String mysql_id) {
        this.mysql_id = mysql_id;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getBanner_page_url() {
        return banner_page_url;
    }

    public void setBanner_page_url(String banner_page_url) {
        this.banner_page_url = banner_page_url;
    }
}
