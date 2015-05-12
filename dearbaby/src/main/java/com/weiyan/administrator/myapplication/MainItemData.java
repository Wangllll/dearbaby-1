package com.weiyan.administrator.myapplication;

/**
 * Created by Administrator on 2015/4/27.
 */
public class MainItemData {
    public int item_Head;
    public int item_State;
    public int item_Praise;
    public int item_Comment;
    public int item_Transmit;
    public String item_Name;
    public String item_Time;
    public String item_Text;

    // private GridView gridView;
    public MainItemData(int item_Head, int item_State, int item_Praise, int item_Comment, int item_Transmit, String item_Name, String item_Time, String item_Text) {
        this.item_Head = item_Head;
        this.item_Name = item_Name;
        this.item_Text = item_Text;
        this.item_Time = item_Time;
        this.item_State = item_State;
        this.item_Praise = item_Praise;
        this.item_Comment = item_Comment;
        this.item_Transmit = item_Transmit;
    }
}
