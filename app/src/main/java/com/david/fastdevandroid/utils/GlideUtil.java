package com.david.fastdevandroid.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.david.fastdevandroid.AppContext;
import com.david.fastdevandroid.R;

import java.io.File;

/**
 * Created by Administrator on 2016/12/13.
 */

public class GlideUtil {

    /**
     * 从内存卡中异步加载本地图片
     *
     * @param filePath
     * @param imageView
     */
    public static void loadFile(String filePath, ImageView imageView) {
        Glide.with(AppContext.getInstance())
                .load(new File(filePath))
                .into(imageView);
    }

    public static void loadFile(Context context,String filePath, ImageView imageView) {
        Glide.with(context)
                .load(new File(filePath))
                .dontAnimate()
                .into(imageView);
    }


    /**
     * 从网络中异步加载本地图片
     *
     * @param url
     * @param imageView
     */
    public static void loadFromNet(String url, ImageView imageView) {
        Glide.with(AppContext.getInstance())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)//加载中动画
                .error(R.mipmap.ic_launcher)
                .crossFade(300)//图片显示效果：淡入淡出  可以加时间int /ms
//                .dontAnimate()//关闭动画效果
                .into(imageView);

    }

    /**
     * 加载gif图片  url后缀只能是gif?
     *
     * @param url
     * @param imageView
     */
    public static void loadGif(String url, ImageView imageView) {
        Glide.with(AppContext.getInstance())
                .load(url)
                .thumbnail(0.1f)
                //.asBitmap()//显示第一帧
                .into(imageView);
    }

    /**
     * 不使用缓存
     *
     * @param url
     * @param imageView DiskCacheStrategy.NONE 什么都不缓存
     *                  DiskCacheStrategy.SOURCE 仅仅只缓存原来的全分辨率的图像。
     *                  DiskCacheStrategy.RESULT 仅仅缓存最终的图像，即，降低分辨率后的（或者是转换后的）
     *                  DiskCacheStrategy.ALL 缓存所有版本的图像（默认行为）
     */
    public static void loadFromNetUnCache(String url, ImageView imageView) {
        Glide.with(AppContext.getInstance())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)// 不使用磁盘缓存
                .skipMemoryCache(true) //跳过内存缓存
                .into(imageView);
    }

    /**
     * 设置优先级来尽可能控制图片加载顺序
     * @param url
     * @param imageView
     * @param priority  IMMEDIATE,
     *                  HIGH,
     *                  NORMAL,
     *                  LOW, priority,
     */
    public static void loadImageWithPriority(String url, ImageView imageView, Priority priority) {
        Glide.with(AppContext.getInstance())
                .load(url)
                .priority(priority)
                .into(imageView);
    }


    /**
     *
     * 从网络中下载bitmap
     * @param url
     * @return 如果加载的图片是 1000x1000 像素的，但是 ImageView 只有 250x250 像素，
     * Glide 将会减少图片的尺寸去节省时间和内存。很显然，在和 target 协作的
     * 时候并没有这么做，因为我们并没有已知的大小。然而，如果你有一个指定的
     * 大小，你可以提高回调。如果你知道这种图片应该要多大，你应该在你的回调
     * 声明中指定它以节省一些内存。
     * 如：new SimpleTarget<Bitmap>( 250, 250 )
     */
    public static Bitmap getBitmapFromNet(String url) {
        final Bitmap[] bitmap = {null};
        Glide.with(AppContext.getInstance())
                .load(url)
                .asBitmap()//Glide 也可以加载 Gif 或 video 的。为了防止 target 的冲突（我们需要 Bitmap） 和未知资源在网络背后的 URL(可能是一个 Gif)，我们可以调用 .asBitmap() 告诉 Glide 我们需要一个图像。
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        LogUtil.e("info", "onResourceReady");
                        if (resource != null) {
                            LogUtil.e("info", "bitmap != null");
                            bitmap[0] = resource;
                        }
                    }
                });
        if (bitmap != null && bitmap.length != 0) {
            return bitmap[0];
        } else
            return null;
    }
}
