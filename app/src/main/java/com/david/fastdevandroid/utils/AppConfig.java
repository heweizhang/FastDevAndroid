package com.david.fastdevandroid.utils;

import com.networking.http.entity.BannerBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class AppConfig {
    public  static int view_status = 0;//0 可见，1 不可见

    public static List<BannerBean> bannerBeanList;
    public static int BATCH_CONTACTS_INPUT_ROW_NUM = 8;
    public static int BATH_INPUT_BY_UN_LOGINED_NUM = 50;
    public static int MAX_UPLOAD_IMAGE = 5;//发布产品可上传图片最大值
    public static int WX_PAY_CODE = 100;
    public static long Banner_Reresh_time= 7000;
    public static int Divce_Width;
    public static String SharedPreferencesFileName = "wechat_renmaiwang";
    public static String HOW_TO_USE_URL = "http://mytuyou.com/index.php/Article/tutorial";//如何使用
    public static String CONTACTS_TO_SERVICE_URL = "http://mytuyou.com/index.php/Article/contact";//联系客服
    public static String APP_DOWNLOAD_URL = "http://mytuyou.com/index.php/article/share.html";
    public static String APP_PROTOCAL_URL = "http://mytuyou.com/index.php/article/agreement.html";//用户协议
    public static String headerPortraitsPath = "/sdcard/weixinrenmaiwang/image/";
    public static String OtherQR_Image_Path = "/sdcard/DCIM/Camera/";
    public static String APP_UPDATA_PATH = "/sdcard/weixinrenmaiwang/apk/";

    public static String U_PHONE = "u_phone";
    public static String U_CODE = "u_code";
    public static String U_PASSWORD = "u_password";
    public static String U_PORTRAIT = "u_portrait";
    public static String U_NAME = "u_name";
    public static String U_SESSION = "u_session";
    public static String GENDER = "gender";
    public static String WECHAT_NUM = "wechat_num";
    public static String CARD_NAME = "card_name";
    public static String CARD_ADDR = "card_addr";
    public static String CARD_DESCRIBE = "card_describe";
    public static String CARD_QR_URL = "card_qr_url";
    public static String IMPORTED_NUM = "imported_num";
    public static String PRIVILEGE_UP = "privilege_up";
    public static String PRIVILEGE_VIP = "privilege_vip";
    public static String PRIVILEGE_GOD = "privilege_god";
    public static String FREE_TOUP_MARGIN = "free_toup_margin";
    public static String CONTRACT_IMPORT_NUM = "contract_import_num";
    public static String head_name = "head.jpg";
    public static String qr_image = "wechat_qr_image.png";
    public static String qr_image_save = "_qr.png";
    public static String pro_image_save = "_pro.png";
    public static String SERVICE_TYPE = "service_type";
    public static String ENCODESTR = "encodestr";
    public static String CODE = "code";
    public static String GRANT_TYPE = "grant_type";
    public static String WX_STATE_RANDOM = "";

    public static String noticeUrl = "";
    public static String noticeTitle = "";


}
