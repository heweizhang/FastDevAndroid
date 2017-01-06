# FastDevAndroid
*慢慢打造适合自己的快速开发模型*

#### 1、项目架构
使用mvp架构，从而达到界面与业务分离，减少耦合

#### 2、网络框架
使用基于当前火热的OkHttp,RxJava,RxAndroid二次封装的OkGo
```
compile 'com.lzy.net:okgo:+'
```
自定义网络请求CallBack：  
1、带Dialog提示的post请求  
2、不带Dialog提示的post请求  


#### 3、图片框架使用谷歌亲儿子 Glide
```
compile 'com.github.bumptech.glide:glide:3.7.0'
```

#### 4、使用 rxlifecycle 管理生命周期
```
compile 'com.trello:rxlifecycle-components:1.0'
```

#### 5、使用 ButterKnife 注解来快速绑定view，从而避免无止境的findViewById();
ButterKnife github 地址:[https://github.com/JakeWharton/butterknife/](https://github.com/JakeWharton/butterknife/)

框架引入：

```
一、app gradle中添加：
apply plugin: 'com.jakewharton.butterknife'

dependencies {
    compile 'com.jakewharton:butterknife:8.4.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'
}


二、Project gradle中添加：
dependencies {
    classpath 'com.jakewharton:butterknife-gradle-plugin:8.4.0'
}

```
#### 6、封装BaseAdapter，BaseViewHolder，使用RecycleView变得轻松;
目前仅支持单种item的Adapter


#### 7、接入greenDAO3,数据库操作更优雅，配置迁移，版本更新数据不再丢失;
[greenDAO3接入教程](http://www.jianshu.com/p/793f77feeb89)
本项目更新中...
