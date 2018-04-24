package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;
import com.example.android.whitebear.Models.EventsModel;
import com.example.android.whitebear.R;
import com.example.android.whitebear.eventDetail;
import com.github.lzyzsd.circleprogress.CircleProgress;

import java.util.List;

/**
 * Created by dellpc on 4/13/2018.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.Event_View_Holder> {
    private LayoutInflater inflater;
    private List<EventsModel> list;
    private Context context;

    public EventsAdapter(Context context,List<EventsModel> list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public EventsAdapter.Event_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.event_element,parent,false);

        return new Event_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(final EventsAdapter.Event_View_Holder holder, int position) {
        final EventsModel current=list.get(position);
        holder.cusId.setText(current.getCusId());
        holder.eventId.setText(current.getEventId());
       holder.EventDetail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent i=new Intent(context,eventDetail.class);
               i.putExtra("cusId",current.getCusId());
               i.putExtra("eventId",current.getEventId());
               i.putExtra("eventType",current.getEventType());
               i.putExtra("address",current.getVenue());
               i.putExtra("pack",current.getPack());
               i.putExtra("guests",current.getGuestN());
               i.putExtra("nonveg",current.isNonVeg());
               context.startActivity(i);
           }
       });
       double prog=(Double.parseDouble(current.getAdMoney())/Double.parseDouble(current.getTotal()))*100;
        holder.circularProgress.setFinishedColor(R.color.green);
       holder.circularProgress.setProgress(((int)prog));

       holder.eventDetailGo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(context,PayAmount.class);
               i.putExtra("total",current.getTotal());
               i.putExtra("payed",current.getAdMoney());
               i.putExtra("key",current.getKey());
               context.startActivity(i);
           }
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Event_View_Holder extends RecyclerView.ViewHolder{
        public TextView cusId;
        public TextView eventId;
        public LinearLayout eventDetailGo;
        public LinearLayout EventDetail;
        public CircleProgress circularProgress;


        public Event_View_Holder(View itemView) {
            super(itemView);
            cusId=itemView.findViewById(R.id.customer_UID);
            eventId=itemView.findViewById(R.id.event_id);
            eventDetailGo=itemView.findViewById(R.id.event_pay_button);
            EventDetail=itemView.findViewById(R.id.event_detail_button);
            circularProgress=itemView.findViewById(R.id.event_element_progress);

        }
    }
}