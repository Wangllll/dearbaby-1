package com.weiyan.administrator.viewpagers;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/30.
 */
public class MainViewPagerFragment4 extends Fragment {

    private View view;
    private ListView mListView;
    private List<Pager4ItemData> pager4ItemDatas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager_4, container, false);

        initDatas();
        initListView();
        return view;

    }

    private void initDatas() {
        pager4ItemDatas = new ArrayList<Pager4ItemData>();
        Pager4ItemData pager4ItemData1 = new Pager4ItemData(R.drawable.pager4_listview_item_1,R.drawable.pager4_listview_item_3,"每日按一句话","发送的方式");
        Pager4ItemData pager4ItemData2 = new Pager4ItemData(R.drawable.pager4_listview_item_2,R.drawable.pager4_listview_item_4,"每日按一句话","发送的方式");
        Pager4ItemData pager4ItemData3 = new Pager4ItemData(R.drawable.pager4_listview_item_1,R.drawable.pager4_listview_item_3,"每日按一句话","发送的方式");
        Pager4ItemData pager4ItemData4 = new Pager4ItemData(R.drawable.pager4_listview_item_2,R.drawable.pager4_listview_item_4,"每日按一句话","发送的方式");

        pager4ItemDatas.add(pager4ItemData1);
        pager4ItemDatas.add(pager4ItemData2);
        pager4ItemDatas.add(pager4ItemData3);
        pager4ItemDatas.add(pager4ItemData4);

    }

    private void initListView() {
        mListView = (ListView) view.findViewById(R.id.id_pager4ListView);

        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return pager4ItemDatas.size();
            }

            @Override
            public Object getItem(int position) {
                return pager4ItemDatas.get(position);
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
                convertView = View.inflate(getActivity().getApplicationContext(),R.layout.pager4_list_item,null);
                holder.pager4_ListView_activityIcon = (ImageView)convertView.findViewById(R.id.id_pager4ListView_item_img_1);
                holder.pager4_ListView_activityStatus = (ImageView)convertView.findViewById(R.id.id_pager4ListView_item_img_2);
                holder.pager4_ListView_activityName = (TextView)convertView.findViewById(R.id.id_pager4ListView_item_tx_1);
                holder.pager4_ListView_activityMessage = (TextView)convertView.findViewById(R.id.id_pager4ListView_item_tx_2);
                    convertView.setTag(holder);
                }else {
                    holder = (ViewHolder)convertView.getTag();
                }
                Pager4ItemData pager4Itemdata = pager4ItemDatas.get(position);
                holder.pager4_ListView_activityIcon.setImageResource(pager4Itemdata.pager4Item_img1);
                holder.pager4_ListView_activityStatus.setImageResource(pager4Itemdata.pager4Item_img2);
                holder.pager4_ListView_activityName.setText(pager4Itemdata.pager4Item_tx1);
                holder.pager4_ListView_activityMessage.setText(pager4Itemdata.pager4Item_tx2);
                return convertView;
            }

        });
    }


    public class Pager4ItemData{
        private int pager4Item_img1;
        private int pager4Item_img2;
        private String pager4Item_tx1;
        private String pager4Item_tx2;



        public  Pager4ItemData(int pager4Item_img1,int pager4Item_img2,String pager4Item_tx1,String pager4Item_tx2){
            this.pager4Item_img1 = pager4Item_img1;
            this.pager4Item_img2 = pager4Item_img2;
            this.pager4Item_tx1 = pager4Item_tx1;
            this.pager4Item_tx2 = pager4Item_tx2;

        }
    }
    public class ViewHolder{
        private ImageView pager4_ListView_activityIcon;
        private ImageView pager4_ListView_activityStatus;
        private TextView pager4_ListView_activityName;
        private TextView pager4_ListView_activityMessage;
    }





}
