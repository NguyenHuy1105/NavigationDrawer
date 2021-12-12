package com.example.navigationdrawer;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class menuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<itemMenu> list;

    public menuAdapter(Context context,int layout,List<itemMenu>list){
        this.context=context;
        this.layout=layout;
        this.list=list;
    }
        @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class Viewholder {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertViewm, ViewGroup parent) {
        Viewholder viewholder;
        if(convertViewm==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertViewm=inflater.inflate(layout, null);
            viewholder=new Viewholder();

            viewholder.tv=(TextView) convertViewm.findViewById(R.id.tvItem);
            viewholder.img=(ImageView) convertViewm.findViewById(R.id.imgicon);

            convertViewm.setTag(viewholder);
        }
        else{
            viewholder=(Viewholder) convertViewm.getTag();
        }
        viewholder.tv.setText(list.get(position).tenItem);
        viewholder.img.setImageResource(list.get(position).Icon);
        return convertViewm;
    }
}
