package com.weiyan.administrator.viewpagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.weiyan.administrator.myapplication.MainActivity;
import com.weiyan.administrator.myapplication.MainItemData;
import com.weiyan.administrator.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/4/27.
 */
public class MainViewPagerFragment1 extends Fragment {
    private MyBaseAdapter myBaseAdapter;
    private ArrayList<MainItemData> mItems;                     //存放Item中的数据，当前由自己自动生成
    private ListView mListView;
    private View view;
    private ImageView mImageView;
    private Button bt_ToClass, bt_ToSchool;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager_1, container, false);
        initListView();
        return view;
    }

    public void initListView() {
        mListView = (ListView) view.findViewById(R.id.main_listview);
        mImageView = (ImageView) view.findViewById(R.id.id_pager1_2);
        bt_ToClass = (Button) view.findViewById(R.id.id_pager1Change1);
        bt_ToSchool = (Button) view.findViewById(R.id.id_pager1Change2);

        bt_ToClass.setBackgroundResource(R.drawable.pager1_topstate);
        bt_ToClass.setTextColor(getResources().getColor(R.color.accent_material_dark));


        bt_ToClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_ToSchool.setBackgroundColor(0xffffff);
                bt_ToClass.setBackgroundResource(R.drawable.pager1_topstate);
                bt_ToClass.setTextColor(getResources().getColor(R.color.accent_material_dark));
                bt_ToSchool.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                mListView.setVisibility(View.VISIBLE);
                mImageView.setVisibility(View.GONE);
            }
        });
        bt_ToSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_ToClass.setBackgroundColor(0xffffff);
                bt_ToSchool.setBackgroundResource(R.drawable.pager1_topstate);
                bt_ToClass.setTextColor(getResources().getColor(R.color.abc_primary_text_material_light));
                bt_ToSchool.setTextColor(getResources().getColor(R.color.accent_material_dark));
                mListView.setVisibility(View.GONE);
                mImageView.setVisibility(View.VISIBLE);
            }
        });
        //自己添加Items~~~
        MainItemData mItemData = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "微言", "1小时以前  来自IPhone4S", "分手时候内疚的你一转脸。");
        MainItemData mItemData1 = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "SP", "1分钟前  来自IPhone4", "为日后不想有什么牵连。");
        MainItemData mItemData2 = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "德邦", "1分钟前  来自IPhone3", "呵呵呵。");
        MainItemData mItemData3 = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "艾希", "1分钟前  来自IPhone2", "今晚开Lu啊。");
        MainItemData mItemData4 = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "Love", "1分钟前  来自IPhone1", "6点下班。");
        MainItemData mItemData5 = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "SP", "1分钟前  来自IPhone11", "7点上。");
        MainItemData mItemData6 = new MainItemData(R.drawable.sliding_head, R.drawable.main_item_recommend, R.drawable.main_item_praise, R.drawable.main_item_comment, R.drawable.main_item_transmit, "SP", "1分钟前  来自IPhone12", "不见不散。");


        mItems = new ArrayList<MainItemData>();
        mItems.add(mItemData);
        mItems.add(mItemData1);
        mItems.add(mItemData2);
        mItems.add(mItemData3);
        mItems.add(mItemData4);
        mItems.add(mItemData5);
        mItems.add(mItemData6);

        if (myBaseAdapter == null) {
            myBaseAdapter = new MyBaseAdapter(mItems);
        }

        mListView.setAdapter(myBaseAdapter);
    }

    public class MyBaseAdapter extends BaseAdapter {

        private ArrayList<MainItemData> items;

        public MyBaseAdapter(ArrayList<MainItemData> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items == null ? 0 : items.size();                  //返回有几个Item，如果为空返回0 否则返回Item的数量
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);                           //返回当前ListViwe 被选中的Item;
        }

        @Override
        public long getItemId(int position) {
            return position;                                       //返回被选中的ListView中Item的序号;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getActivity().getApplicationContext(), R.layout.main_llist_item, null);      //先将整体的Item主布局放在converView中，这样子的话 可以提升ListView的效率
                holder.iv_item_Head = (ImageView) convertView.findViewById(R.id.item_head);              //为holder中的所有view实例化
                holder.tv_item_Name = (TextView) convertView.findViewById(R.id.item_name);
                holder.tv_item_Time = (TextView) convertView.findViewById(R.id.item_time);
                holder.iv_item_State = (ImageView) convertView.findViewById(R.id.item_state);
                holder.tv_item_Text = (TextView) convertView.findViewById(R.id.item_text);
                holder.iv_item_Praise = (ImageView) convertView.findViewById(R.id.item_praise);
                holder.iv_item_Comment = (ImageView) convertView.findViewById(R.id.item_comment);
                holder.iv_item_Transmit = (ImageView) convertView.findViewById(R.id.item_transmit);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //  接下来 为各个View赋值
            MainItemData itemdata = items.get(position);                                //取得LiveView中的posiong所在item;
            holder.iv_item_Head.setImageResource(itemdata.item_Head);
            holder.tv_item_Name.setText(itemdata.item_Name);
            holder.tv_item_Time.setText(itemdata.item_Time);
            holder.iv_item_State.setImageResource(itemdata.item_State);
            holder.tv_item_Text.setText(itemdata.item_Text);
            holder.iv_item_Praise.setImageResource(itemdata.item_Praise);
            holder.iv_item_Comment.setImageResource(itemdata.item_Comment);
            holder.iv_item_Transmit.setImageResource(itemdata.item_Transmit);

            holder.iv_item_Transmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Transmit_转发",Toast.LENGTH_SHORT).show();
                }
            });
            holder.iv_item_Comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Comment_评论",Toast.LENGTH_SHORT).show();
                }
            });
            holder.iv_item_Praise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Praise_赞",Toast.LENGTH_SHORT).show();
                }
            });



            return convertView;
        }

        public class ViewHolder {                                                                   //存放View
            private ImageView iv_item_Head;
            private ImageView iv_item_State;
            private ImageView iv_item_Praise;
            private ImageView iv_item_Comment;
            private ImageView iv_item_Transmit;
            private TextView tv_item_Name;
            private TextView tv_item_Time;
            private TextView tv_item_Text;
            //  private GridView gridView;
        }
    }


}
