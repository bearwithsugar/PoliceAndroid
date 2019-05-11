package com.demo.mayixuan.myapplication;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mayixuan on 2018/7/27.
 */

public class SetupListAdapter extends BaseAdapter {

    String[] list;
    LayoutInflater inflater = null;

    public SetupListAdapter(String[] list, Context context){
        this.list=list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        view = inflater.inflate(R.layout.set_up_item, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        textView.setText(list[position ]);

        return view;

    }
}
