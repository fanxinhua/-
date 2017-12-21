package com.example.dell.ykz.present;

import com.example.dell.ykz.moudle.BannerModel;
import com.example.dell.ykz.view.BannerView;

/**
 * Created by dell on 2017/12/20.
 */

public class BannerPreseter implements BannerModel.IBannerModel {
    private BannerModel model;
    private BannerView view;

    public BannerPreseter(BannerView view) {
        this.view = view;
        model=new BannerModel();
        model.setiBannerModel(this);
    }
  public void   getdata(){
      model.getBannerData();
    }

    @Override
    public void netsceesc(String msg) {
        view.Success(msg);

    }

    @Override
    public void netError(String msg) {
        view.Error(msg);

    }
}
