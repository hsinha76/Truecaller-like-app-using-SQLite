package com.hsdroid.harish.truecallerusingsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomMod extends BaseAdapter {

    private Context context;
    private ArrayList<Model> modelArrayList;

    public CustomMod(Context context, ArrayList<Model> modelArrayList) {

        this.context = context;
        this.modelArrayList = modelArrayList;
    }


    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model_teacher_mod, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.teachers_name);
            holder.tvphone = (TextView) convertView.findViewById(R.id.teachers_phone);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Name: "+ modelArrayList.get(position).getName());
        holder.tvphone.setText("Phone: "+ modelArrayList.get(position).getPhone());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvphone;
    }

}