package com.weiyan.administrator.pager3Function;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.weiyan.administrator.myapplication.R;
import com.weiyan.administrator.viewpagers.MainViewPagerFragment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/8.
 */
public class Pager3MakeMoney extends Fragment implements View.OnClickListener{
    private View view;
    private Button topBt1,topBt2,topBt3;
    private ListView lv1,lv2,lv3;
    private List<ListItem1> lvData1;
    private List<ListItem2> lvData2;
    private List<ListItem3> lvData3;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager3_makemoney,container,false);

        initView();
        initData();
        return view;
    }

    private void initData() {
        ListItem1 item1Data1 = new ListItem1(R.drawable.test_pager3_makemoney_listitem1_1,"宝贝去哪儿六一儿童摄影","收益￥1元","仅售188元，价值1888元的儿童摄影儿童写真，男女不限，限12周岁以下的儿童使用","价格：￥188.00","去购买");
        ListItem1 item1Data2 = new ListItem1(R.drawable.test_pager3_makemoney_listitem1_2,"[五一路]绽放视觉","收益￥1元","仅售188元，价值1888元的儿童摄影儿童写真，男女不限，限12周岁以下的儿童使用","价格：￥399.00","去购买");
        ListItem1 item1Data3 = new ListItem1(R.drawable.test_pager3_makemoney_listitem1_3,"宝贝去哪儿六一儿童摄影","收益￥1元","仅售188元，价值1888元的儿童摄影儿童写真，男女不限，限12周岁以下的儿童使用","价格：￥188.00","去购买");
        ListItem1 item1Data4 = new ListItem1(R.drawable.test_pager3_makemoney_listitem1_4,"宝贝去哪儿六一儿童摄影","收益￥1元","仅售188元，价值1888元的儿童摄影儿童写真，男女不限，限12周岁以下的儿童使用","价格：￥188.00","去购买");
        ListItem1 item1Data5 = new ListItem1(R.drawable.test_pager3_makemoney_listitem1_1,"宝贝去哪儿六一儿童摄影","收益￥1元","仅售188元，价值1888元的儿童摄影儿童写真，男女不限，限12周岁以下的儿童使用","价格：￥188.00","去购买");
        ListItem1 item1Data6 = new ListItem1(R.drawable.test_pager3_makemoney_listitem1_2,"宝贝去哪儿六一儿童摄影","收益￥1元","仅售188元，价值1888元的儿童摄影儿童写真，男女不限，限12周岁以下的儿童使用","价格：￥188.00","去购买");

        ListItem2 item2Data1 = new ListItem2(R.drawable.test_pager3_makemoney_listitem2_1,"收益￥1元");
        ListItem2 item2Data2 = new ListItem2(R.drawable.test_pager3_makemoney_listitem2_2,"收益￥1元");
        ListItem2 item2Data3 = new ListItem2(R.drawable.test_pager3_makemoney_listitem2_3,"收益￥1元");
        ListItem2 item2Data4 = new ListItem2(R.drawable.test_pager3_makemoney_listitem2_4,"收益￥1元");
        ListItem2 item2Data5 = new ListItem2(R.drawable.test_pager3_makemoney_listitem2_5,"收益￥1元");
        ListItem2 item2Data6 = new ListItem2(R.drawable.test_pager3_makemoney_listitem2_1,"收益￥1元");

        ListItem3 item3Data1 = new ListItem3(R.drawable.test_pager3_makemoney_listitem3_1,"秀发保卫战","时间：11月21 中午 19.00-20.00","地点：山西微言科技","费用：免费","进行中....","收益￥:1.00");
        ListItem3 item3Data2 = new ListItem3(R.drawable.test_pager3_makemoney_listitem3_2,"秀发保卫战","时间：11月21 中午 19.00-20.00","地点：山西微言科技","费用：免费","进行中....","收益￥:1.00");
        ListItem3 item3Data3 = new ListItem3(R.drawable.test_pager3_makemoney_listitem3_3,"秀发保卫战","时间：11月21 中午 19.00-20.00","地点：山西微言科技","费用：免费","进行中....","收益￥:1.00");
        ListItem3 item3Data4 = new ListItem3(R.drawable.test_pager3_makemoney_listitem3_4,"秀发保卫战","时间：11月21 中午 19.00-20.00","地点：山西微言科技","费用：免费","进行中....","收益￥:1.00");
        ListItem3 item3Data5 = new ListItem3(R.drawable.test_pager3_makemoney_listitem3_1,"秀发保卫战","时间：11月21 中午 19.00-20.00","地点：山西微言科技","费用：免费","进行中....","收益￥:1.00");
        ListItem3 item3Data6 = new ListItem3(R.drawable.test_pager3_makemoney_listitem3_2,"秀发保卫战","时间：11月21 中午 19.00-20.00","地点：山西微言科技","费用：免费","进行中....","收益￥:1.00");

        lvData1.add(item1Data1);
        lvData1.add(item1Data2);
        lvData1.add(item1Data3);
        lvData1.add(item1Data4);
        lvData1.add(item1Data5);
        lvData1.add(item1Data6);

        lvData2.add(item2Data1);
        lvData2.add(item2Data2);
        lvData2.add(item2Data3);
        lvData2.add(item2Data4);
        lvData2.add(item2Data5);
        lvData2.add(item2Data6);

        lvData3.add(item3Data1);
        lvData3.add(item3Data2);
        lvData3.add(item3Data3);
        lvData3.add(item3Data4);
        lvData3.add(item3Data5);
        lvData3.add(item3Data6);

    }

    private void initView() {
        lvData1 = new ArrayList<>();
        lvData2 = new ArrayList<>();
        lvData3 = new ArrayList<>();

        topBt1 = (Button)view.findViewById(R.id.id_pager3_makemoney_topbt1);
        topBt2 = (Button)view.findViewById(R.id.id_pager3_makemoney_topbt2);
        topBt3 = (Button)view.findViewById(R.id.id_pager3_makemoney_topbt3);

        lv1 = (ListView)view.findViewById(R.id.id_pager3_makemoney_lv1);
        lv2 = (ListView)view.findViewById(R.id.id_pager3_makemoney_lv2);
        lv3 = (ListView)view.findViewById(R.id.id_pager3_makemoney_lv3);


        topBt1.setOnClickListener(this);
        topBt2.setOnClickListener(this);
        topBt3.setOnClickListener(this);

        lv1.setAdapter(new Myadapter1());
        lv2.setAdapter(new Myadapter2());
        lv3.setAdapter(new Myadapter3());

        topBt1.setBackgroundResource(R.drawable.pager1_topstate);
        topBt1.setTextColor(getResources().getColor(R.color.accent_material_dark));
        topBt2.setBackgroundColor(0xffffff);
        topBt3.setBackgroundColor(0xffffff);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_pager3_makemoney_topbt1:
                topBt2.setBackgroundColor(0xffffff);
                topBt2.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                topBt3.setBackgroundColor(0xffffff);
                topBt3.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                topBt1.setBackgroundResource(R.drawable.pager1_topstate);
                topBt1.setTextColor(getResources().getColor(R.color.accent_material_dark));
                lv1.setVisibility(View.VISIBLE);
                lv2.setVisibility(View.GONE);
                lv3.setVisibility(view.GONE);
                break;
            case R.id.id_pager3_makemoney_topbt2:
                topBt1.setBackgroundColor(0xffffff);
                topBt1.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                topBt3.setBackgroundColor(0xffffff);
                topBt3.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                topBt2.setBackgroundResource(R.drawable.pager1_topstate);
                topBt2.setTextColor(getResources().getColor(R.color.accent_material_dark));
                lv1.setVisibility(View.GONE);
                lv2.setVisibility(View.VISIBLE);
                lv3.setVisibility(view.GONE);
                break;
            case R.id.id_pager3_makemoney_topbt3:
                topBt2.setBackgroundColor(0xffffff);
                topBt2.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                topBt1.setBackgroundColor(0xffffff);
                topBt1.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                topBt3.setBackgroundResource(R.drawable.pager1_topstate);
                topBt3.setTextColor(getResources().getColor(R.color.accent_material_dark));
                lv1.setVisibility(View.GONE);
                lv2.setVisibility(View.GONE);
                lv3.setVisibility(View.VISIBLE);
                break;
        }
    }

    public class Myadapter1 extends BaseAdapter{

        @Override
        public int getCount() {
            return lvData1.size();
        }

        @Override
        public Object getItem(int position) {
            return lvData1.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder1 viewHolder1;
            if(convertView==null){
                viewHolder1 = new ViewHolder1();
                convertView = View.inflate(getActivity().getApplicationContext(),R.layout.pager3_makemoney_listitem1,null);
                viewHolder1.img1 = (ImageView)convertView.findViewById(R.id.id_pager3_makemoney_listitem1_img1);
                viewHolder1.tv1 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem1_text1);
                viewHolder1.tv2 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem1_text2);
                viewHolder1.tv3 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem1_text3);
                viewHolder1.tv4 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem1_text4);
                viewHolder1.tv5 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem1_text5);
                convertView.setTag(viewHolder1);
            }else {
             viewHolder1 = (ViewHolder1)convertView.getTag();
            }

            ListItem1 data = lvData1.get(position);
            viewHolder1.img1.setImageResource(data.img1);
            viewHolder1.tv1.setText(data.text1);
            viewHolder1.tv2.setText(data.text2);
            viewHolder1.tv3.setText(data.text3);
            viewHolder1.tv4.setText(data.text4);
            viewHolder1.tv5.setText(data.text5);

            return convertView;
        }
    }

    public class Myadapter2 extends BaseAdapter{

        @Override
        public int getCount() {
            return lvData2.size();
        }

        @Override
        public Object getItem(int position) {
            return lvData2.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder2 viewHolder2;
            if(convertView==null){
                viewHolder2 = new ViewHolder2();
                convertView = View.inflate(getActivity().getApplicationContext(),R.layout.pager3_makemoney_listitem2,null);
                viewHolder2.img1 = (ImageView)convertView.findViewById(R.id.id_pager3_makemoney_listitem2_img1);
                viewHolder2.tv1 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem2_text1);

                convertView.setTag(viewHolder2);
            }else {
                viewHolder2 = (ViewHolder2)convertView.getTag();
            }

            ListItem2 data = lvData2.get(position);
            viewHolder2.img1.setImageResource(data.img1);
            viewHolder2.tv1.setText(data.text1);

            return convertView;
        }
    }

    public class Myadapter3 extends BaseAdapter{

        @Override
        public int getCount() {
            return lvData3.size();
        }

        @Override
        public Object getItem(int position) {
            return lvData3.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder3 viewHolder3;
            if(convertView==null){
                viewHolder3 = new ViewHolder3();
                convertView = View.inflate(getActivity().getApplicationContext(),R.layout.pager3_makemoney_listitem3,null);
                viewHolder3.img1 = (ImageView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_img1);
                viewHolder3.tv1 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text1);
                viewHolder3.tv2 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text2);
                viewHolder3.tv3 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text3);
                viewHolder3.tv4 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text4);
                viewHolder3.tv5 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text5);
                viewHolder3.tv6 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text5);
                viewHolder3.tv6 = (TextView)convertView.findViewById(R.id.id_pager3_makemoney_listitem3_text6);
                convertView.setTag(viewHolder3);
            }else {
                viewHolder3 = (ViewHolder3)convertView.getTag();
            }

            ListItem3 data = lvData3.get(position);
            viewHolder3.img1.setImageResource(data.img1);
            viewHolder3.tv1.setText(data.text1);
            viewHolder3.tv2.setText(data.text2);
            viewHolder3.tv3.setText(data.text3);
            viewHolder3.tv4.setText(data.text4);
            viewHolder3.tv5.setText(data.text5);
            viewHolder3.tv6.setText(data.text6);

            return convertView;
        }
    }

    public class ListItem1{
        int img1;
       private String text1,text2,text3,text4,text5;
        public ListItem1(int img1,String t1,String t2,String t3,String t4,String t5){
            this.img1 = img1;
            this.text1 = t1;
            this.text2 = t2;
            this.text3 = t3;
            this.text4 = t4;
            this.text5 = t5;
        }

    }

    public class ViewHolder1{
        private ImageView img1;
        private   TextView tv1;
        private TextView tv2;
        private  TextView tv3;
        private  TextView tv4;
        private  TextView tv5;
    }

    public class ListItem2{
        int img1;
        private String text1;
        public ListItem2(int img1,String t1){
            this.img1 = img1;
            this.text1 = t1;
        }

    }

    public class ViewHolder2{
        private ImageView img1;
        private   TextView tv1;

    }

    public class ListItem3{
        int img1;
        private String text1,text2,text3,text4,text5,text6;
        public ListItem3(int img1,String t1,String t2,String t3,String t4,String t5,String t6){
            this.img1 = img1;
            this.text1 = t1;
            this.text2 = t2;
            this.text3 = t3;
            this.text4 = t4;
            this.text5 = t5;
            this.text6 = t6;
        }

    }

    public class ViewHolder3{
        private ImageView img1;
        private   TextView tv1;
        private TextView tv2;
        private  TextView tv3;
        private  TextView tv4;
        private  TextView tv5;
        private  TextView tv6;
    }

}
