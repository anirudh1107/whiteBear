package com.example.android.whitebear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by dellpc on 4/17/2018.
 */

public class eventDetail extends AppCompatActivity {


    private String customerId;
    private String eventId;
    private String EventType;
    private String venue;
    private String packType;
    private String guestsN;
    private boolean Nonveg;
    private TextView cusId;
    private TextView eventi;
    private TextView eventT;
    private TextView address;
    private TextView Pack;
    private TextView guests;
    private TextView nonveg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        cusId=findViewById(R.id.event_detail_customerId);
        eventi=findViewById(R.id.event_detail_eventId);
        eventT=findViewById(R.id.event_detail_event);
        address=findViewById(R.id.event_detail_address);
        Pack=findViewById(R.id.event_detail_pack_type);
        guests=findViewById(R.id.event_detail_guests_no_);
        nonveg=findViewById(R.id.event_detail_Nonveg);
        Bundle extra=getIntent().getExtras();
        customerId=extra.getString("cusId");
        eventId=extra.getString("eventId");
        EventType=extra.getString("eventType");
        venue=extra.getString("address");
        packType=extra.getString("pack");
        guestsN=extra.getString("guests");
        Nonveg=extra.getBoolean("nonveg");
        cusId.setText(customerId);
        eventi.setText(eventId);
        eventT.setText(EventType);
        address.setText(venue);
        Pack.setText(packType);
        guests.setText(guestsN);
        if(Nonveg)
            nonveg.setText("TRUE");
        else
            nonveg.setText("False");

    }
}
