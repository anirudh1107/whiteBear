package com.example.android.whitebear.fragment;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.example.android.whitebear.Adapters.EventsAdapter;
import com.example.android.whitebear.AddEvent;
import com.example.android.whitebear.Models.EventsModel;
import com.example.android.whitebear.R;
import com.github.badoualy.datepicker.DatePickerTimeline;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dellpc on 3/17/2018.
 */

public class frragment2 extends Fragment implements View.OnClickListener {


    FloatingActionButton eventAdd;
    private RecyclerView scheduleRecycle;
    List<EventsModel> list;
    EventsAdapter adapter;
    DatabaseReference ref;
    DatePickerTimeline timeline;
    EventsModel newEvent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment2,container,false);

        init(view);

        eventAdd.setOnClickListener(this);
        scheduleRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        scheduleRecycle.setAdapter(adapter);


        timeline.setOnDateSelectedListener(new DatePickerTimeline.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day, int index) {

                final int day1=day;
                final int month1=month;
                final int year1=year;
                list.removeAll(list);
                ref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        newEvent=dataSnapshot.getValue(EventsModel.class);
                        newEvent.setKey(dataSnapshot.getKey().toString());

                        if(Integer.parseInt(newEvent.getDay())==day1 && Integer.parseInt(newEvent.getMonth())==month1&& Integer.parseInt(newEvent.getYear())==year1 )
                        {
                            list.add(newEvent);
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
            }
        });



        return view;
    }

    void init(View view)
    {
        eventAdd=view.findViewById(R.id.add_event_fab);
        scheduleRecycle=view.findViewById(R.id.schedule_recycle);
        list=new ArrayList<>();
        adapter=new EventsAdapter(getContext(),list);
        ref= FirebaseDatabase.getInstance().getReference().child("events");
        timeline=view.findViewById(R.id.date_picker);

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.add_event_fab)
            startActivity(new Intent(getContext(),AddEvent.class));
    }
}
