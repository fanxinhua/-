package com.example.dell.ykz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dell.ykz.activity.BaseActivity;
import com.example.dell.ykz.fragment.Fragment1;
import com.example.dell.ykz.fragment.Fragment2;
import com.example.dell.ykz.fragment.Fragment3;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_fl_fl)
    FrameLayout mainFlFl;
    @BindView(R.id.main_rb_rb1)
    RadioButton mainRbRb1;
    @BindView(R.id.main_rb_rb2)
    RadioButton mainRbRb2;
    @BindView(R.id.main_rb_rb3)
    RadioButton mainRbRb3;
    @BindView(R.id.main_rg_rg)
    RadioGroup mainRgRg;
    @BindView(R.id.re)
    DrawerLayout re;
    @BindView(R.id.bar_imgleft)
    ImageView barImgleft;
    @BindView(R.id.bar_title)
    TextView barTitle;
    @BindView(R.id.bar_imgright)
    ImageView barImgright;
    @BindView(R.id.left_img)
    ImageView leftImg;
    @BindView(R.id.left_name)
    TextView leftName;
    @BindView(R.id.left_qm)
    TextView leftQm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        re.setScrimColor(Color.TRANSPARENT);
        startFragment(new Fragment1());
    }

    @OnClick({R.id.main_rb_rb1, R.id.main_rb_rb2, R.id.main_rb_rb3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_rb_rb1:
               // re.openDrawer(Gravity.LEFT);//弹出侧滑菜单
                barTitle.setText("推荐");
                startFragment(new Fragment1());
                break;
            case R.id.main_rb_rb2:
                barTitle.setText("段子");
                startFragment(new Fragment2());
                break;
            case R.id.main_rb_rb3:
                barTitle.setText("视频");
                startFragment(new Fragment3());
                break;
        }
    }
    public void startFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl_fl, f).commit();
    }
}
