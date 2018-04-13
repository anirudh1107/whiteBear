package com.example.android.whitebear;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;

public class AddEvent extends AppCompatActivity implements View.OnClickListener{

    ImageView calender;
    Calendar c;
    int year,month,day;
    private String mYear,mMonth,mDay;
    private EditText cusId;
    private EditText venue;
    private TextView updateDisplay;
    private long estimate;
    private int multi;
    private Spinner type;
    private Spinner pack;
    private RadioGroup food;
    private RadioGroup celebrity;
    private boolean preceleb;
    private int prefood;
    private TextInputLayout cusInWrapper;
    private TextInputLayout venueWrapper;
    private TextView guestNo;
    private TextView dateDisplay;
    private Button addGuests;
    private Button subGuests;
    private int guests;
    private Button submit;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        init();

        food.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.event_add_veg)
                {
                    if ((estimate*guests)!=0)
                    {
                        if(prefood==0)
                            estimate+=10000;

                        else if (prefood==2)
                            estimate-=10000;

                        prefood=1;
                    }
                }
                else
                {
                    if ((estimate*guests)!=0)
                    {
                        if(prefood==0)
                            estimate+=20000;
                        else if(prefood==1)
                            estimate+=10000;

                        prefood=2;
                    }
                }
                display();
            }
        });

        //add button
        addGuests.setOnClickListener(this);

        subGuests.setOnClickListener(this);

        submit.setOnClickListener(this);

        celebrity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.event_add_YES)
                {
                    if(!preceleb &&((estimate*guests)>0))
                    {
                        estimate+=500000;
                        preceleb=true;
                        display();
                    }
                }
                else
                {
                    if(preceleb)
                    {
                        estimate-=500000;
                        preceleb=false;
                        display();
                    }
                }
            }
        });

        final DatePickerDialog date=new DatePickerDialog(AddEvent.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mYear=String.valueOf(i);
                mMonth=String.valueOf(i1);
                mDay=String.valueOf(i2);
                dateDisplay();
            }
        },year,month,day);


        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.show();
            }
        });

    }

    void init()
    {
        cusInWrapper=findViewById(R.id.event_cus_id_wrapper);
        venueWrapper=findViewById(R.id.event_add_venue_wrapper);
        guestNo=findViewById(R.id.event_add_guest);
        cusInWrapper.setHint("Customer ID");
        venueWrapper.setHint("Venue");
        calender=findViewById(R.id.event_add_date);
        estimate=0;
        multi=1;
        type=findViewById(R.id.event_add_event_type);
        pack=findViewById(R.id.event_add_package);
        food=findViewById(R.id.event_add_food);
        celebrity=findViewById(R.id.event_add_celebrity);
        addGuests=findViewById(R.id.event_add_plus);
        subGuests=findViewById(R.id.event_add_minus);
        dateDisplay=findViewById(R.id.event_add_date_display);
        submit=findViewById(R.id.event_add_submit);
        cusId=findViewById(R.id.event_cus_id);
        venue=findViewById(R.id.event_add_venue);

        updateDisplay=findViewById(R.id.add_event_estimate);
        c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        mDay="";
        preceleb=false;
        prefood=0;
        guests=0;

        //spinner for event type
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                    estimate=0;
                else if (i==1)
                    estimate=25000;
                else if(i==2)
                    estimate=50000;
                else if(i==3)
                    estimate=100000;
                else
                    estimate=150000;

                display();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //spinner for package type
        pack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    multi=1;
                else if(i==1)
                    multi=2;
                else if(i==2)
                    multi=3;
                else
                    multi=4;

                display();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        display();
    }

    @Override
    public void onClick(View view) {

        if(view==findViewById(R.id.event_add_plus))
        {
            if(guests<2000)
                guests+=100;
        }
        else if(view.getId()==R.id.event_add_minus)
        {
            if(guests!=0)
                guests-=100;
        }
        displayguuests();

        if(view.getId()==R.id.event_add_submit)
        {
            if(cusId.getText().toString().isEmpty())
                Toast.makeText(this,"Please Enter CusId",Toast.LENGTH_SHORT).show();
            else if(mDay.isEmpty())
                Toast.makeText(this,"Please Select the Date",Toast.LENGTH_SHORT).show();
            else if(estimate*guests*multi==0)
                Toast.makeText(this,"Please Select all the fields",Toast.LENGTH_SHORT).show();
            else if(venue.getText().toString().isEmpty())
                Toast.makeText(this,"Please enter venue field",Toast.LENGTH_SHORT).show();
            else if(prefood==0)
                Toast.makeText(this,"Please Select veg or non veg food type",Toast.LENGTH_SHORT).show();
            else
            {

                ref= FirebaseDatabase.getInstance().getReference().child("events").push();
                ref.child("cusId").setValue(cusId.getText().toString());
                ref.child("eventType").setValue(type.getSelectedItem().toString());
                ref.child("venue").setValue(venue.getText().toString());
                ref.child("day").setValue(mDay);
                ref.child("month").setValue(mMonth);
                ref.child("year").setValue(mYear);
                ref.child("guestN").setValue(String.valueOf(guests));
                if(prefood==1)
                    ref.child("nonVeg").setValue(false);
                else if(prefood==2)
                    ref.child("nonVeg").setValue(true);
                ref.child("pack").setValue(pack.getSelectedItem().toString());
                ref.child("celeb").setValue(preceleb);
                ref.child("total").setValue(String.valueOf(estimate*guests*multi));

                startActivity(new Intent(this,MainActivity.class));
                finish();
            }


        }
    }

    void display()
    {
        updateDisplay.setText(String.valueOf(estimate*guests*multi));
    }

    void displayguuests()
    {
        guestNo.setText(String.valueOf(guests));
        display();
    }

    public void dateDisplay()
    {
        dateDisplay.setText(""+mDay+"\\"+mMonth+"\\"+mYear);
    }
}
