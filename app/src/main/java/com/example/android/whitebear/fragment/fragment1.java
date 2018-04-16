package com.example.android.whitebear.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.whitebear.AddCustomer;
import com.example.android.whitebear.Models.CustomerModel;
import com.example.android.whitebear.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by dellpc on 3/17/2018.
 */

public class fragment1 extends Fragment {

    private DatabaseReference ref;
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter adapter;
    private Query query;
    private FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment1,container,false);
        recyclerView=view.findViewById(R.id.customer_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fab=view.findViewById(R.id.add_customer_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddCustomer.class));
            }
        });
        ref= FirebaseDatabase.getInstance().getReference().child("Users");
        query=ref;
        FirebaseRecyclerOptions<CustomerModel> options= new FirebaseRecyclerOptions.Builder<CustomerModel>().setQuery(query,CustomerModel.class).build();

        adapter = new FirebaseRecyclerAdapter<CustomerModel,CustomerViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CustomerViewHolder holder, int position, @NonNull CustomerModel model) {

                final CustomerViewHolder holder2=holder;
                holder.cusId.setText(model.getCusId());
                holder.name.setText(model.getName());
                holder.phone.setText(String.valueOf(model.getPhone()));
                holder.eventId.setText(model.getEventId());
                holder.address.setText(model.getAddress());
                holder.emailId.setText(model.getEmailId());

                holder.hiddenButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (holder2.hidden.getVisibility()==View.VISIBLE)
                        {
                            holder2.hidden.setVisibility(View.GONE);
                            holder.expansion.setImageResource(R.drawable.ic_expand_more_black_24dp);
                        }
                        else if(holder2.hidden.getVisibility()==View.GONE)
                        {
                            holder2.hidden.setVisibility(View.VISIBLE);
                            holder.expansion.setImageResource(R.drawable.ic_expand_less_black_24dp);
                        }
                    }
                });
                holder.expansion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(holder2.hidden.getVisibility()==View.VISIBLE){
                            holder2.hidden.setVisibility(View.GONE);
                            holder.expansion.setImageResource(R.drawable.ic_expand_more_black_24dp);
                        }
                        else if (holder2.hidden.getVisibility()==View.GONE){
                            holder2.hidden.setVisibility(View.VISIBLE);
                            holder.expansion.setImageResource(R.drawable.ic_expand_less_black_24dp);
                        }
                    }
                });

            }

            @Override
            public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view=LayoutInflater.from(getContext()).inflate(R.layout.customer_element,parent,false);
                return new CustomerViewHolder(view);
            }
        };

        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
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
        public ImageView expansion;
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
            expansion=itemView.findViewById(R.id.expansion);
        }
    }
}
