package com.example.dell.ykz.moudle;

import com.example.dell.ykz.utils.HttpUtils;

/**
 * Created by dell on 2017/12/20.
 */

public class BannerModel {
    private String url="https://www.zhaoapi.cn/quarter/getAd";
    private IBannerModel iBannerModel;
    public void setiBannerModel(IBannerModel iBannerModel) {
        this.iBannerModel = iBannerModel;
    }
    /**
     * 解析方法
     */
    public void getBannerData(){
        HttpUtils.getInstance().getJson(url, new HttpUtils.HttpCallBack() {
            @Override
            public void onSusscess(String data) {
                iBannerModel.netsceesc(data);
            }
            @Override
            public void onError(String meg) {
                super.onError(meg);
                iBannerModel.netError(meg);
            }
        });
    }
    public  interface IBannerModel{
        void netsceesc(String msg);
        void netError(String msg);
    }
}
