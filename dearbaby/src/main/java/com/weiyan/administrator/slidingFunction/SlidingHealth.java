package com.weiyan.administrator.slidingFunction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.weiyan.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/6.
 */
public class SlidingHealth extends Fragment {
    private View view;
    private ListView slindingMenuHealthListView;
    private List<SlidingMenuHealthDate> slidingMenuHealthDates;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.slidingmenu_health,container,false);
        initSlidingMenuHealth();

        return view;
    }

    private void initSlidingMenuHealth() {

        slindingMenuHealthListView = (ListView)view.findViewById(R.id.id_slidingMenu_health);

        slidingMenuHealthDates = new ArrayList<SlidingMenuHealthDate>();
        SlidingMenuHealthDate SlidingMenuHealthDate1 = new SlidingMenuHealthDate("今天");
        SlidingMenuHealthDate SlidingMenuHealthDate2 = new SlidingMenuHealthDate("昨天");
        SlidingMenuHealthDate SlidingMenuHealthDate3 = new SlidingMenuHealthDate("5/6");
        SlidingMenuHealthDate SlidingMenuHealthDate4 = new SlidingMenuHealthDate("5/5");
        SlidingMenuHealthDate SlidingMenuHealthDate5 = new SlidingMenuHealthDate("5/4");
        SlidingMenuHealthDate SlidingMenuHealthDate6 = new SlidingMenuHealthDate("5/3");
        slidingMenuHealthDates.add(SlidingMenuHealthDate1);
        slidingMenuHealthDates.add(SlidingMenuHealthDate2);
        slidingMenuHealthDates.add(SlidingMenuHealthDate3);
        slidingMenuHealthDates.add(SlidingMenuHealthDate4);
        slidingMenuHealthDates.add(SlidingMenuHealthDate5);
        slidingMenuHealthDates.add(SlidingMenuHealthDate6);
        slindingMenuHealthListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return slidingMenuHealthDates.size();
            }

            @Override
            public Object getItem(int position) {

                return slidingMenuHealthDates.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(getActivity().getApplicationContext(),R.layout.slidingmenu_health_listitem,null);
                    holder.textViewSlidingMenuHealthDate = (TextView)convertView.findViewById(R.id.id_slidingMenu_health_date);
                    convertView.setTag(holder);
                }
                else {
                    holder = (ViewHolder)convertView.getTag();
                }
                SlidingMenuHealthDate slidingMenuHealthDate = slidingMenuHealthDates.get(position);
                holder.textViewSlidingMenuHealthDate.setText(slidingMenuHealthDate.Date);
                return convertView;
            }
        });

    }

    public class SlidingMenuHealthDate {
        private String Date;

        public SlidingMenuHealthDate(String s) {
            this.Date = s;
        }
    }

    public class ViewHolder {
        private TextView textViewSlidingMenuHealthDate;
    }
}
