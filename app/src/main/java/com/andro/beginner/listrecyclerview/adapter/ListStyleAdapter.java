package com.andro.beginner.listrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andro.beginner.listrecyclerview.R;
import com.andro.beginner.listrecyclerview.model.Style;

import java.util.ArrayList;

/**
 * Created by amaliaqis on 3/9/2018.
 */

public class ListStyleAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Style> styleArrayList;


    public ListStyleAdapter(Context context, ArrayList<Style> styleArrayList) {

        this.context = context;
        this.styleArrayList = styleArrayList;

    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return styleArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return styleArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_style, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.tv_style_name);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_style);

            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText(styleArrayList.get(position).getStyleDesc());
        holder.iv.setImageResource(styleArrayList.get(position).getImgStyle());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname;
        private ImageView iv;

    }

}
