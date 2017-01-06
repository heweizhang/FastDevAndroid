package com.david.fastdevandroid.mvp.presenter.impl;

import com.david.fastdevandroid.greendao.GreenDaoHelper;
import com.david.fastdevandroid.greendao.entity.User;
import com.david.fastdevandroid.mvp.base.BasePresenter;
import com.david.fastdevandroid.mvp.view.GreenDaoActivity;
import com.david.fastdevandroid.utils.LogUtil;
import com.david.fastdevandroid.utils.ToastUtils;

import java.util.List;

import greendao.UserDao;


/**
 * Created by Administrator on 2017/1/5.
 */

public class GreenDaoPresenter extends BasePresenter<GreenDaoActivity> {

    private UserDao mUserDao = GreenDaoHelper.getDaoSession().getUserDao();

    public void insertData() {
        //数据库的增删改查我们都将通过UserDao来进行，插入操作如下：
        mUserDao.insert(new User(null, "david", 23, "male","12341234","computer science"));//id传null 即自增。==> 这里是Long类型而不是long
        query();
    }

    public void deleteData() {
        LogUtil.e("info", "deleteData()");
 /*       //查询id等于3的所有行
        User user = mUserDao.queryBuilder().where(UserDao.Properties.Id.eq(3)).build().unique();

        if (user == null) {
            ToastUtils.show(getView(), "用户不存在!");
        }else{
            mUserDao.deleteByKey(user.getId());
        }*/

     /*   //查询id小于5的集合
        List<User> userList = (List<User>) mUserDao.queryBuilder().where(UserDao.Properties.Id.le(5)).build().list();
        for (User user : userList) {
            mUserDao.delete(user);
        }*/

        //删除所有数据
        mUserDao.deleteAll();
        query();
    }

    public void update() {

       /*
        //修改id为2的行
        User user = new User((long) 2, "Nancy", 23, "female");
        mUserDao.update(user);*/

        //查询id>= 3 且like ("%david%")
        User user = mUserDao.queryBuilder()
                .where(UserDao.Properties.Id.ge(3), UserDao.Properties.UserName.like("%david%")).build().unique();
        if (user == null) {
            ToastUtils.show(getView(), "用户不存在!");
        } else {
            user.setUserName("王五");
            mUserDao.update(user);
        }

        query();
    }

    public void query() {

        //查询所有数据
        List<User> users = mUserDao.loadAll();
        //查询id为1~4之间的数，查出前2个
//        List<User> users = mUserDao.queryBuilder()
//                .where(UserDao.Properties.Id.between(1, 4)).limit(2).build().list();


        StringBuilder sb = new StringBuilder();
        for (User bean : users) {
            sb.append(bean.toString() + "\n");
        }
        getView().showDatas(sb.toString());
    }
}
