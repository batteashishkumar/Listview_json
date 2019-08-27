package com.example.listview_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class List_adapter extends BaseAdapter {
    Context context;
    List<Obj> mylist_obj;
    TextView t1,t2;
    int i=999;
    public List_adapter(Context context,List<Obj> mylist_obj){
        this.context=context;
        this.mylist_obj=mylist_obj;


    }
public void seti(int i){
    this.i=i;
}
    @Override
    public int getCount() {

        if(i==999){ return mylist_obj.size(); }
        else{return 1;}
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
if(i!=999){position=i;}
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.activity_listview,null);
        t1=convertView.findViewById(R.id.label1);
        t2=convertView.findViewById(R.id.label2);
        t1.setText(mylist_obj.get(position).getId());
        t2.setText(mylist_obj.get(position).getTitle());
        return convertView;
    }
}
