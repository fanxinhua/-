package com.example.dell.ykz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.ykz.R;
import com.example.dell.ykz.utils.SetTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/12/19.
 */

public class Fragment1 extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPage;
    private List<Fragment> frags;
    private List<String> titles;
    private Fragment[] f;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.fragment1_item, null);
        viewPage=  v.findViewById(R.id.viewPage);
        tabLayout=  v.findViewById(R.id.frg1_tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.post(new Runnable() {
            @Override
            public void run() { SetTab tab=new SetTab();
                tab.setIndicator(tabLayout, 50, 50);
            }
        });

        tabLayout.invalidate();
        frags=new ArrayList<>();
        frags.add(new FragmentOne());
        frags.add(new FragmentOne());
        titles=new ArrayList<>();
        titles.add("热门");
        titles.add("关注");
        Myadapter adapter=new Myadapter(getChildFragmentManager());
        //联动
        viewPage.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPage);
        return v;
    }




    //适配器
    class Myadapter extends FragmentPagerAdapter {

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frags.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }


}
