package com.example.android.whitebear.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.whitebear.Models.CustomerModel;
import com.example.android.whitebear.R;


import java.util.List;

/**
 * Created by dellpc on 3/19/2018.
 */

public class Customers_adapter extends RecyclerView.Adapter<Customers_adapter.CustomerViewHolder> {

    private LayoutInflater inflater;
    private List<CustomerModel> list;
    Context context;

    public Customers_adapter(Context context, List<CustomerModel> list) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.list=list;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.customer_element,parent,false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomerViewHolder holder, int position) {

        CustomerModel current=list.get(position);
        holder.cusId.setText(current.getCusId());
        holder.name.setText(current.getName());
        holder.phone.setText(String.valueOf(current.getPhone()));
        holder.eventId.setText(current.getEventId());
        holder.address.setText(current.getAddress());
        holder.emailId.setText(current.getEmailId());

        holder.hiddenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.hidden.getVisibility()==View.VISIBLE)
                {
                    holder.hidden.setVisibility(View.GONE);
                }
                else if(holder.hidden.getVisibility()==View.GONE)
                {
                    holder.hidden.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder{

        public TextView cusId;
        public TextView name;
        public TextView phone;
        public TextView address;
        public TextView eventId;
        public TextView emailId;
        public LinearLayout hidden;
        public LinearLayout hiddenButton;
        public CustomerViewHolder(View itemView) {
            super(itemView);
            cusId=itemView.findViewById(R.id.customer_cus_id);
            name=itemView.findViewById(R.id.customer_name);
            phone=itemView.findViewById(R.id.customer_phone);
            address=itemView.findViewById(R.id.customer_address);
            eventId=itemView.findViewById(R.id.customer_event_id);
            emailId=itemView.findViewById(R.id.customer_email_id);
            hidden=itemView.findViewById(R.id.customer_hide_view);
            hiddenButton=itemView.findViewById(R.id.customer_hidden_button);
        }
    }
}
