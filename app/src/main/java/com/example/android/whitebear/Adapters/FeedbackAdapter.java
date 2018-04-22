package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.whitebear.FeedBackForm;
import com.example.android.whitebear.Models.FeedbackModel;
import com.example.android.whitebear.Otp;
import com.example.android.whitebear.R;

import java.util.List;
import java.util.Random;

/**
 * Created by dellpc on 4/15/2018.
 */

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<FeedbackModel> list;
    public FeedbackAdapter(Context context,List<FeedbackModel> list){
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
        final FeedbackModel current=list.get(position);
        holder.eventId.setText(current.getEventId());
        holder.clientId.setText(current.getCusId());
        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand=new Random();
                int o=rand.nextInt(8888)+1111;
                Intent i =new Intent(context,Otp.class);
                i.putExtra("otp",o);
                i.putExtra("CustomerId",current.getCusId());
                i.putExtra("EventId",current.getEventId());
                i.putExtra("key",current.getKey());
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"+current.getPhone()));
                context.startActivity(i);
                sendIntent.putExtra("sms_body", "your OTP is "+o);
                context.startActivity(sendIntent);
            }
        });




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