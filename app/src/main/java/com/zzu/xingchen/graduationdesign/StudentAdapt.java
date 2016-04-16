package com.zzu.xingchen.graduationdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xingchen on 2016/3/23.
 */
public class StudentAdapt extends BaseAdapter{

private LinkedList<StudentEnty> mData;

private Context mContext;


    public StudentAdapt(LinkedList<StudentEnty> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        TextView text_Name= (TextView) convertView.findViewById(R.id.xingming);
        TextView text_id= (TextView) convertView.findViewById(R.id.xuehao);

        text_id.setText(mData.get(position).getId());

        text_Name.setText(mData.get(position).getName());


        return convertView;
    }
}
