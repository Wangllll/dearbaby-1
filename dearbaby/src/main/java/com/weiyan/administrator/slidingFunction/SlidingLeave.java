package com.weiyan.administrator.slidingFunction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiyan.administrator.myapplication.R;

/**
 * Created by Administrator on 2015/5/6.
 */
public class SlidingLeave extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.slidingmenu_leave,container,false);
        return view;
    }
}
