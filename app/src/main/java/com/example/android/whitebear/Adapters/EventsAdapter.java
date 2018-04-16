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

import com.example.android.whitebear.Models.EventsModel;
import com.example.android.whitebear.R;
import com.example.android.whitebear.eventDetail;

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
        holder.eventType.setText(current.getEventType());
        holder.eventVenue.setText(current.getVenue());
        holder.guestCount.setText(current.getGuestN());
        if(current.isNonVeg())
            holder.cuisineType.setText("Non - Veg");
       else
           holder.cuisineType.setText("Veg");

       holder.eventHiddenButton.setOnClickListener(new View.OnClickListener() {
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

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Event_View_Holder extends RecyclerView.ViewHolder{
        public TextView cusId;
        public TextView cusname;
        public TextView eventId;
        public TextView eventType;
        public TextView eventVenue;
        public TextView guestCount;
        public TextView cuisineType;
        public LinearLayout eventHiddenView;
        public LinearLayout eventHiddenButton;
        public ImageView expansion;

        public Event_View_Holder(View itemView) {
            super(itemView);
            cusId=itemView.findViewById(R.id.customer_UID);
            cusname=itemView.findViewById(R.id.customer_name);
            eventId=itemView.findViewById(R.id.event_id);
            eventType=itemView.findViewById(R.id.event_type);
            eventVenue=itemView.findViewById(R.id.event_venue);
            guestCount=itemView.findViewById(R.id.guest_count);
            cuisineType=itemView.findViewById(R.id.cuisine_type);
            eventHiddenView=itemView.findViewById(R.id.event_hidden_view);
            eventHiddenButton=itemView.findViewById(R.id.event_hidden_button);
            expansion=itemView.findViewById(R.id.expansion);
        }
    }
}