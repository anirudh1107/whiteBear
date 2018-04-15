package com.example.android.whitebear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.whitebear.Adapters.FeedbackFormAdapter;
import com.example.android.whitebear.Models.feedback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FeedBackForm extends AppCompatActivity implements View.OnClickListener{

    private FeedbackFormAdapter adapter;
    private List<feedback> data;
    private RecyclerView recyclerView;
    private static int deco;
    private static int cuisine;
    private static int hospitality;
    private static float overall;
    private Button submit;
    private String eventId;
    private String customerId;
    private DatabaseReference ref;
    private EditText feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_form);
        submit=findViewById(R.id.feed_back_form_submit);
        feedbackText=findViewById(R.id.feedback_text);
        submit.setOnClickListener(this);

        data = new ArrayList<>();

        data.add(new feedback("Cuisine",R.drawable.sad1,R.drawable.confused1,R.drawable.happy1,R.drawable.fire1));

        data.add(new feedback("Decorations",R.drawable.sad1,R.drawable.confused1,R.drawable.happy1,R.drawable.fire1));
        data.add(new feedback("Hospitality & Services",R.drawable.sad1,R.drawable.confused1,R.drawable.happy1,R.drawable.fire1));

        Bundle extra=getIntent().getExtras();
        eventId=extra.getString("EventId");
        customerId=extra.getString("CustomerId");
        recyclerView=findViewById(R.id.feedback_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new FeedbackFormAdapter(this,data);
        recyclerView.setAdapter(adapter);

    }

    public static void setdecoration(int rating)
    {

        deco=rating;
    }

    public static void setCuisine(int rating)
    {
        cuisine=rating;
    }

    public static void setHospitality(int rating)
    {
        hospitality=rating;
    }

    @Override
    public void onClick(View view) {

        ref= FirebaseDatabase.getInstance().getReference().child("FeedBack").push();
        ref.child("cusId").setValue(customerId);
        ref.child("eventId").setValue(eventId);
        ref.child("decoration").setValue(String.valueOf(deco));
        ref.child("cuisine").setValue(String.valueOf(cuisine));
        ref.child("hospitality").setValue(String.valueOf(hospitality));
        overall=(deco+cuisine+hospitality)/3.0f;
        ref.child("overall").setValue(String.valueOf(overall));
        if(!feedbackText.getText().toString().isEmpty())
            ref.child("feedbacktext").setValue(feedbackText.getText().toString());
        else
            ref.child("feedbacktext").setValue("");


        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}
