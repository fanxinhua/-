package com.example.dell.ykz.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.ykz.R;

/**
 * Created by dell on 2017/12/19.
 */

public class ImageUtils {
    public void showImg(Context context,String url, ImageView img){
        Glide.with(context).load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img);
    }
}
