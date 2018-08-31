package com.timmy.wanandroid.core.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Banner加载使用的Loader
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        // TODO
        Glide.with(context).load(path).into(imageView);
    }
}
