package com.example.dell.ykz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.ykz.R;

/**
 * Created by dell on 2017/12/19.
 */

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=View.inflate(getActivity(), R.layout.fragment3_item,null);
        return v;
    }
}
