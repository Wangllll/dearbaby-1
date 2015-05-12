package com.weiyan.administrator.myapplication;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.nineoldandroids.view.ViewHelper;
import com.weiyan.administrator.adapter.ViewPagerAdapter;
import com.weiyan.administrator.viewpagers.MainViewPagerFragment1;
import com.weiyan.administrator.viewpagers.MainViewPagerFragment2;
import com.weiyan.administrator.viewpagers.MainViewPagerFragment3;
import com.weiyan.administrator.viewpagers.MainViewPagerFragment4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2015/4/18.
 */
public class MainActivity extends FragmentActivity {

    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private List fragmentList = new ArrayList<Fragment>();
    private Fragment mFragment1, mFragment2, mFragment3, mFragment4;
    private PagerAdapter mPgAdapter;
    public TextView topTitle;
    private ImageView topImage;
    private int year1, month1, day1, year2, month2, day2;
    private LinearLayout slidingLeave, slidingCommunication, mainLinearLayout, slidingCommunicationAddfirends, slidingHealth, slidingGrow,pager3MakeMoney;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViewPager();
        initView();
        initEvents();

    }

    private void initEvents() {
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;

                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;
                float leftAlpha = 0.6f + 0.4f * (1 - scale);

                ViewHelper.setTranslationX(mContent,
                        -mMenu.getMeasuredWidth() * slideOffset);
                ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                ViewHelper.setPivotY(mContent,
                        mContent.getMeasuredHeight() / 2);
                mContent.invalidate();
                ViewHelper.setScaleX(mContent, rightScale);
                ViewHelper.setScaleY(mContent, rightScale);

                ViewHelper.setAlpha(mMenu, leftAlpha);
                ViewHelper.setPivotX(mContent, 0);
                ViewHelper.setPivotY(mContent, mContent.getHeight() / 2);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }
        });
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.id_topTitle);
        topImage = (ImageView) findViewById(R.id.id_topLeftImage);
        slidingLeave = (LinearLayout) findViewById(R.id.id_fragment_leave);
        slidingCommunication = (LinearLayout) findViewById(R.id.id_fragmentCommunication);
        mainLinearLayout = (LinearLayout) findViewById(R.id.id_activity_main);
        slidingCommunicationAddfirends = (LinearLayout) findViewById(R.id.id_fragmentCommunicationAddfriends);
        slidingHealth = (LinearLayout) findViewById(R.id.id_fragmentHealth);
        slidingGrow = (LinearLayout) findViewById(R.id.id_fragmentGrow);
        pager3MakeMoney = (LinearLayout)findViewById(R.id.id_pager3_ll_makemoney);

        topTitle.setText("新鲜事");
        topImage.setImageResource(R.drawable.main_top_2_1);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);//侧栏初始化
        // mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);    //在android抽屉Drawer_layout开发中，需要关闭手势滑动，来滑出弹出框--关闭手势滑动
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        topTitle.setText("新鲜事");
                        topImage.setImageResource(R.drawable.main_top_2_1);
                        break;
                    case 1:
                        topTitle.setText("聊天");
                        topImage.setImageResource(R.drawable.main_top_2_1);
                        break;
                    case 2:
                        topTitle.setText("探索");
                        topImage.setImageResource(R.drawable.main_top_2_1);
                        break;
                    case 3:
                        topTitle.setText(("我的资料"));
                        topImage.setImageResource(R.drawable.main_top_4_1);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mFragment1 = new MainViewPagerFragment1();          //fragmentPager
        mFragment2 = new MainViewPagerFragment2();
        mFragment3 = new MainViewPagerFragment3();
        mFragment4 = new MainViewPagerFragment4();


        fragmentList = new ArrayList<Fragment>();           //用来装fragmentPager

        fragmentList.add(mFragment1);
        fragmentList.add(mFragment2);
        fragmentList.add(mFragment3);
        fragmentList.add(mFragment4);

        mPgAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);

        mViewPager.setAdapter(mPgAdapter);

    }

    public void slidingMenu(View view) {
        mDrawerLayout.openDrawer(Gravity.RIGHT);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                Gravity.RIGHT);
    }       //侧栏菜单按键触发

    public void jumpInterface(View view) {                      //跳转界面
        switch (view.getId()) {
            case R.id.main_bottom_1:
                mViewPager.setCurrentItem(0);
                topTitle.setText("新鲜事");

                break;
            case R.id.main_bottom_2:
                mViewPager.setCurrentItem(1);
                topTitle.setText("聊天");
                break;
            case R.id.main_bottom_4:
                mViewPager.setCurrentItem(2);
                topTitle.setText("探索");
                break;
            case R.id.main_bottom_5:
                mViewPager.setCurrentItem(3);
                topTitle.setText("我的资料");
                topImage.setImageResource(R.drawable.main_top_4_1);
                break;
        }
    }

    public void slidingFunction(View view) {
        switch (view.getId()) {
            case R.id.id_slidingMenu_item1:
                slidingGrow.setVisibility(View.GONE);
                mainLinearLayout.setVisibility(View.GONE);
                slidingCommunication.setVisibility(View.VISIBLE);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                slidingHealth.setVisibility(View.GONE);
                pager3MakeMoney.setVisibility(View.GONE);
                break;
            case R.id.id_slidingMenu_item2:
                slidingCommunication.setVisibility(View.GONE);
                mainLinearLayout.setVisibility(View.GONE);
                slidingHealth.setVisibility(View.GONE);
                slidingGrow.setVisibility(View.VISIBLE);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                pager3MakeMoney.setVisibility(View.GONE);
                break;
            case R.id.id_slidingMenu_item3:
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                mDrawerLayout.setVisibility(View.GONE);
                slidingLeave.setVisibility(View.VISIBLE);
                mainLinearLayout.setVisibility(View.GONE);
                pager3MakeMoney.setVisibility(View.GONE);
                break;
            case R.id.id_slidingMenu_item6:
                slidingCommunication.setVisibility(View.GONE);
                slidingGrow.setVisibility(View.GONE);
                mainLinearLayout.setVisibility(View.GONE);
                slidingHealth.setVisibility(View.VISIBLE);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                pager3MakeMoney.setVisibility(View.GONE);
                break;


        }
    }

    public void slidingmenuLeaveOnClick(View view) {
        switch (view.getId()) {
            case R.id.id_fragmentLeaveImage1:
                slidingLeave.setVisibility(View.GONE);
                slidingCommunication.setVisibility(View.GONE);
                mDrawerLayout.setVisibility(View.VISIBLE);
                mainLinearLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.id_fragmentLeaveImage2:
                final Calendar c1 = Calendar.getInstance();       //用来采集请假界面的日期
                final EditText fragmentLeaveEt1 = (EditText) findViewById(R.id.id_fragmentLeaveEt1);                //请假界面的日期获取

                DatePickerDialog dialog1 = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        c1.set(year, monthOfYear, dayOfMonth);
                        fragmentLeaveEt1.setText(DateFormat.format("yyy-MM-dd", c1));
                        year1 = year;
                        month1 = monthOfYear;
                        day1 = dayOfMonth;

                    }

                }, c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH));
                dialog1.show();
                break;
            case R.id.id_fragmentLeaveImage3:
                final Calendar c2 = Calendar.getInstance();       //用来采集请假界面的日期
                final EditText fragmentLeaveEt2 = (EditText) findViewById(R.id.id_fragmentLeaveEt2);                //请假界面的日期获取
                DatePickerDialog dialog2 = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        c2.set(year, monthOfYear, dayOfMonth);
                        year2 = year;
                        month2 = monthOfYear;
                        day2 = dayOfMonth;
                        if (toCompare(year1, year2, month1, month2, day1, day2)) {
                            fragmentLeaveEt2.setText(DateFormat.format("yyy-MM-dd", c2));
                        } else {
                            Toast.makeText(MainActivity.this, "你请假的天数不能为负", Toast.LENGTH_SHORT).show();
                        }

                    }

                    private boolean toCompare(int year1, int year2, int month1, int month2, int day1, int day2) {        //用来优化日期选择提示
                        if (year1 > year2 || (year1 <= year2 && month1 > month2) || (year1 <= year2 && month1 <= month2 && day1 > day2))
                            return false;
                        return true;
                    }

                }, c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                dialog2.show();
                break;
        }
    }

    public void slidingmenuCommunicationOnClick(View view) {
        slidingCommunication.setVisibility(View.GONE);
        mDrawerLayout.setVisibility(View.GONE);
        slidingLeave.setVisibility(View.GONE);
        slidingCommunicationAddfirends.setVisibility(View.VISIBLE);

    }

    public void slidingmenuCommunicationAddfriendsOnClick(View view) {
        slidingCommunicationAddfirends.setVisibility(View.GONE);
        mDrawerLayout.setVisibility(View.VISIBLE);
        slidingCommunication.setVisibility(View.VISIBLE);
    }

    public void slidingmenuHealthOnClick(View view) {
        slidingLeave.setVisibility(View.GONE);
        slidingCommunication.setVisibility(View.GONE);
        slidingHealth.setVisibility(View.GONE);
        mDrawerLayout.setVisibility(View.VISIBLE);
        mainLinearLayout.setVisibility(View.VISIBLE);
    }

    public void slidingmenuGrowOnClick(View view) {
        slidingGrow.setVisibility(View.GONE);
        mainLinearLayout.setVisibility(view.VISIBLE);
        mDrawerLayout.setVisibility(view.VISIBLE);
    }

    public void pager3MakeMoneyOnClick(View view){
        switch (view.getId())
        {
            case R.id.id_pager3_makemoney:
                mainLinearLayout.setVisibility(View.GONE);
                pager3MakeMoney.setVisibility(View.VISIBLE);
                break;
            case R.id.id_pager3_makemoney_return:
                pager3MakeMoney.setVisibility(View.GONE);
                mainLinearLayout.setVisibility(View.VISIBLE);
        }

    }

}

