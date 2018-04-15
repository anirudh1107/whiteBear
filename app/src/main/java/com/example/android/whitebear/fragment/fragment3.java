package com.example.android.whitebear.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.whitebear.Adapters.FeedbackAdapter;
import com.example.android.whitebear.Models.FeedbackModel;
import com.example.android.whitebear.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dellpc on 3/17/2018.
 */

public class fragment3 extends Fragment {

    private Calendar c;
    private int day;
    private int month;
    private int year;
    private RecyclerView feedbackRecycle;
    private DatabaseReference ref;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment3,container,false);
        feedbackRecycle=view.findViewById(R.id.feedback_recycle);
        feedbackRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        ref= FirebaseDatabase.getInstance().getReference().child("events");
        c=Calendar.getInstance();
        day=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);

        final List<FeedbackModel> list=new ArrayList<>();
        final FeedbackAdapter adapter=new FeedbackAdapter(getContext(),list);
        feedbackRecycle.setAdapter(adapter);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                FeedbackModel event=dataSnapshot.getValue(FeedbackModel.class);
                if(Integer.parseInt(event.getDay())<day && Integer.parseInt(event.getMonth())<=month && Integer.parseInt(event.getYear())<=year)
                {
                    list.add(event);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;


    }



}
