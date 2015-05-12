package com.weiyan.administrator.viewpagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiyan.administrator.myapplication.R;

/**
 * Created by Administrator on 2015/4/28.
 */
public class MainViewPagerFragment2 extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager_2,container,false);
        return view;
    }
}
