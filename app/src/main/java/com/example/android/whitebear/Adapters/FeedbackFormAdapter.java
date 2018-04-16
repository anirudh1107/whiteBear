package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.whitebear.FeedBackForm;
import com.example.android.whitebear.Models.feedback;
import com.example.android.whitebear.R;

import java.util.Collections;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by hp on 10-04-2018.
 */

public class FeedbackFormAdapter extends Adapter<FeedbackFormAdapter.myViewHolder> {
    private final LayoutInflater inflater;
    List<feedback> data= Collections.emptyList();
    Context context;

    public FeedbackFormAdapter(Context context, List<feedback>data) {
        inflater= LayoutInflater.from(context);
        this.data=data;
        this.context=context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.feedback_form_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        final myViewHolder holder1=holder;
        final feedback current=data.get(position);
        holder.title.setText(current.getTitleid());
        holder.sad.setImageResource(current.getSadid());
        holder.normal.setImageResource(current.getNormalid());
        holder.happy.setImageResource(current.getHappyid());
        holder.aag.setImageResource(current.getAagid());
        holder.sad.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                holder1.sad.setBackgroundColor(context.getResources().getColor(R.color.green));
                holder1.normal.setBackgroundColor(Color.TRANSPARENT);
                holder1.happy.setBackgroundColor(Color.TRANSPARENT);
                holder1.aag.setBackgroundColor(Color.TRANSPARENT);
                if(current.getTitleid()=="Cuisine")
                    FeedBackForm.setCuisine(3);
                else if(current.getTitleid()=="Decorations")
                    FeedBackForm.setdecoration(3);
                else if (current.getTitleid()=="Hospitality & Services")
                    FeedBackForm.setHospitality(3);
            }
        });

        holder.normal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                holder1.normal.setBackgroundColor(context.getResources().getColor(R.color.green));
                holder1.sad.setBackgroundColor(Color.TRANSPARENT);
                holder1.happy.setBackgroundColor(Color.TRANSPARENT);
                holder1.aag.setBackgroundColor(Color.TRANSPARENT);
                if(current.getTitleid()=="Cuisine")
                    FeedBackForm.setCuisine(5);
                else if(current.getTitleid()=="Decorations")
                    FeedBackForm.setdecoration(5);
                else if (current.getTitleid()=="Hospitality & Services")
                    FeedBackForm.setHospitality(5);
            }
        });

        holder.happy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                holder1.happy.setBackgroundColor(context.getResources().getColor(R.color.green));
                holder1.normal.setBackgroundColor(Color.TRANSPARENT);
                holder1.sad.setBackgroundColor(Color.TRANSPARENT);
                holder1.aag.setBackgroundColor(Color.TRANSPARENT);
                if(current.getTitleid()=="Cuisine")
                    FeedBackForm.setCuisine(8);
                else if(current.getTitleid()=="Decorations")
                    FeedBackForm.setdecoration(8);
                else if (current.getTitleid()=="Hospitality & Services")
                    FeedBackForm.setHospitality(8);
            }
        });

        holder.aag.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                holder1.aag.setBackgroundColor(context.getResources().getColor(R.color.green));
                holder1.normal.setBackgroundColor(Color.TRANSPARENT);
                holder1.happy.setBackgroundColor(Color.TRANSPARENT);
                holder1.sad.setBackgroundColor(Color.TRANSPARENT);
                if(current.getTitleid()=="Cuisine")
                    FeedBackForm.setCuisine(10);
                else if(current.getTitleid()=="Decorations")
                    FeedBackForm.setdecoration(10);
                else if (current.getTitleid()=="Hospitality & Services")
                    FeedBackForm.setHospitality(10);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends ViewHolder {
        TextView title;
        ImageView sad;
        ImageView normal;
        ImageView happy;
        ImageView aag;
        public myViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            sad=(ImageView)itemView.findViewById(R.id.sad);
            normal=(ImageView)itemView.findViewById(R.id.normal);
            happy=(ImageView)itemView.findViewById(R.id.happy);
            aag=(ImageView)itemView.findViewById(R.id.aaglagadi);
        }
    }
}



