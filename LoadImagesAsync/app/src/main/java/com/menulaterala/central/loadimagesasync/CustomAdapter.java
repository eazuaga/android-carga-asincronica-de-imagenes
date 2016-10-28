package com.menulaterala.central.loadimagesasync;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CustomAdapter extends BaseAdapter{

    private List<ModelCategory> mDataset;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public class ViewHolder {

        public ImageView logo;
        public TextView title;
    }

    public CustomAdapter(Context context, List<ModelCategory> items) {

        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mDataset = items;
    }

    public void setDataset(List<ModelCategory> newDataset) {

        mDataset = newDataset;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public ModelCategory getItem(int position) {
        return mDataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.simple_category_list_item, null);

            holder = new ViewHolder();
            holder.logo = (ImageView) convertView.findViewById(R.id.imageView__simple_category_list_item_logo);
            holder.title = (TextView) convertView.findViewById(R.id.textView__simple_category_list_item_title);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder)convertView.getTag();
        }

        Picasso.with(mContext).load(getItem(position).getUrl()).into(holder.logo);

        holder.title.setText(getItem(position).getTitle());

        return convertView;
    }

}
