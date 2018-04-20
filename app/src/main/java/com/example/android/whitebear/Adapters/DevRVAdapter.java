package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.whitebear.HomeCategory;
import com.example.android.whitebear.Models.CategoryModel;
import com.example.android.whitebear.R;

import java.util.ArrayList;

/**
 * Created by Abhishek on 03-Feb-18.
 */

public class DevRVAdapter extends RecyclerView.Adapter<DevRVAdapter.Myviewholder> {

    private Context context;
    private ArrayList<CategoryModel> list;


    public DevRVAdapter(Context context, ArrayList<CategoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.element_dev_page, parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, final int position) {
        final CategoryModel mod=list.get(position);
        holder.name.setText(mod.GetName());
        holder.image.setImageResource(mod.getImgres());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeCategory.setDevData(mod.getImgres(),mod.GetName());
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public Myviewholder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_element_dev_img);
            name = itemView.findViewById(R.id.tv_element_dev_name);
        }

    }
}
