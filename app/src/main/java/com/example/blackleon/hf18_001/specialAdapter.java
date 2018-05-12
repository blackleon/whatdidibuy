package com.example.blackleon.hf18_001;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class specialAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<pickAnImage.Item> itemList;

    public specialAdapter(Activity activity, List<pickAnImage.Item> list)
    {
        inflater = (LayoutInflater)activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        itemList = list;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lineView;

        lineView = inflater.inflate(R.layout.layout, null);
        TextView textView = (TextView) lineView.findViewById(R.id.text);
        ImageView imageView = (ImageView) lineView.findViewById(R.id.symbol);
        //ImageView imageView2 = (ImageView) lineView.findViewById(R.id.symbol4);

        pickAnImage.Item item = itemList.get(position);
        textView.setText(item.type + " " + item.price + " " + item.buydate);

        //To be continued... if(item.type==)

        imageView.setImageResource(android.R.drawable.star_on);


        return lineView;
    }

    public void clearArray()
    {
        itemList.clear();
    }
}
