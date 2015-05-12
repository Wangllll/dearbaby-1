package com.weiyan.administrator.slidingFunction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.weiyan.administrator.myapplication.R;
import com.weiyan.administrator.viewpagers.MainViewPagerFragment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/7.
 */
public class SlidingGrow extends Fragment {
    private ListView mListView;
    private List<ItemData> mListItems;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.slidingmenu_grow, container, false);
        initView();
        return view;
    }

    private void initView() {
        mListView = (ListView) view.findViewById(R.id.id_slidingMenu_grow_Lv);
        mListItems = new ArrayList<>();

        ItemData itemData1 = new ItemData("2015 5/7","今天是个好日子，新想的事儿都能成");
        ItemData itemData2 = new ItemData("2015 5/6",R.drawable.test_sliding_grow_img_03);
        ItemData itemData3 = new ItemData("2015 5/5",R.drawable.test_sliding_grow_img_01,R.drawable.test_sliding_grow_img_02);
        ItemData itemData4 = new ItemData("2015 5/4","怀念单车给你我，唯一有过的拥抱",R.drawable.test_sliding_grow_img_01,R.drawable.test_sliding_grow_img_02);
        ItemData itemData5 = new ItemData("2015 5/3","天空灰的像哭过，离开你以后，并没有更自由",R.drawable.test_sliding_grow_img_01,R.drawable.test_sliding_grow_img_02);
        ItemData itemData6 = new ItemData("2015 5/2","夸孩子少用你真棒，教你如何夸孩子，大家都要学哦",R.drawable.test_sliding_grow_img_01,R.drawable.test_sliding_grow_img_02);

        mListItems.add(itemData1);
        mListItems.add(itemData2);
        mListItems.add(itemData3);
        mListItems.add(itemData4);
        mListItems.add(itemData5);
        mListItems.add(itemData6);

        mListView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mListItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mListItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
               holder = new ViewHolder();
                convertView = View.inflate(getActivity(),R.layout.slidingmenu_grow_listitem,null);
                holder.tVdate = (TextView)convertView.findViewById(R.id.id_slidingMenu_grow_date);
                holder.tVtext = (TextView)convertView.findViewById(R.id.id_slidingMenu_grow_text);
                holder.iVimage1 = (ImageView)convertView.findViewById(R.id.id_slidingMenu_grow_img1);
                holder.iVimage2 = (ImageView)convertView.findViewById(R.id.id_slidingMenu_grow_img2);
                convertView.setTag(holder);
            }else{
                holder =(ViewHolder)convertView.getTag();
            }

            ItemData itemData = mListItems.get(position);
            holder.tVdate.setText(itemData.date);
            holder.tVtext.setText(itemData.text);
            holder.iVimage1.setImageResource(itemData.img1);
            holder.iVimage2.setImageResource(itemData.img2);

            return convertView;
        }
    }

    public class ItemData {
        String date;
        String text;
        int img1;
        int img2;

        public ItemData(String date, String text) {
            this.date = date;
            this.text = text;
        }

        public ItemData(String date, int img1) {
            this.date = date;
            this.img1 = img1;
        }

        public ItemData(String date, int img1, int img2) {
            this.date = date;
            this.img1 = img1;
            this.img2 = img2;
        }

        public ItemData(String date, String text, int img1, int img2) {
            this.date = date;
            this.text = text;
            this.img1 = img1;
            this.img2 = img2;
        }
    }

    public class ViewHolder{
        private TextView tVdate;
        private TextView tVtext;
        private ImageView iVimage1;
        private ImageView iVimage2;
    }

}
