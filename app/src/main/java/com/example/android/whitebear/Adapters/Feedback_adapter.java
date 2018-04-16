package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.whitebear.Models.FeedbackModel;
import com.example.android.whitebear.R;

import java.util.List;

public class Feedback_adapter extends RecyclerView.Adapter<Feedback_adapter.FeedbackViewHolder> {
    private LayoutInflater inflater;
    private Context context;

    private List<FeedbackModel> list;
    public Feedback_adapter(Context context,List<FeedbackModel> list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);

    }
    @Override
    public FeedbackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.feedback_element,parent,false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedbackViewHolder holder, int position) {
        FeedbackModel current=list.get(position);
        holder.eventId.setText(current.getEventId());
        holder.clientId.setText(current.getClientId());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class FeedbackViewHolder extends RecyclerView.ViewHolder {
        public TextView eventId;
        public TextView clientId;
        public LinearLayout main;
        public FeedbackViewHolder(View itemView) {
            super(itemView);
            eventId=itemView.findViewById(R.id.event_id);
            clientId=itemView.findViewById(R.id.client_id);
            main=itemView.findViewById(R.id.main);

        }



    }

}
