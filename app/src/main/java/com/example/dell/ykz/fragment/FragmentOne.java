package com.example.dell.ykz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.ykz.R;
import com.example.dell.ykz.bean.BannerBean;
import com.example.dell.ykz.present.BannerPreseter;
import com.example.dell.ykz.utils.GlideImageLoader;
import com.example.dell.ykz.view.BannerView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dell on 2017/12/20.
 */

public class FragmentOne extends Fragment implements BannerView {
    @BindView(R.id.one_banner)
    Banner oneBanner;
    Unbinder unbinder;
    private View v;
    private BannerPreseter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = View.inflate(getActivity(), R.layout.item, null);
         presenter = new BannerPreseter(this);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    //轮播图设置
    @Override
    public void Success(String data) {
        Gson gson = new Gson();
        BannerBean bannerBean = gson.fromJson(data, BannerBean.class);
        List<String> lis=new ArrayList<>();
        for(int i=0;i<bannerBean.getData().size();i++){
            lis.add(bannerBean.getData().get(i).getIcon());

        }



        oneBanner.setImages(lis).setImageLoader(new GlideImageLoader()).start();



    }

    @Override
    public void Error(String data) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {

        super.onResume();
        presenter.getdata();

    }
}