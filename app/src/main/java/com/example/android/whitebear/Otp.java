package com.example.android.whitebear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Otp extends AppCompatActivity {

    EditText getOtp;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        final Bundle extra=getIntent().getExtras();
        final int otp=extra.getInt("otp");
        getOtp=findViewById(R.id.otp_send);
        submit=findViewById(R.id.otp_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(getOtp.getText().toString())==otp)
                {
                    Intent i=new Intent(Otp.this,FeedBackForm.class);
                    i.putExtra("CustomerId",extra.getString("CustomerId"));
                    i.putExtra("EventId",extra.getString("EventId"));
                    i.putExtra("key",extra.getString("key"));
                    startActivity(i);
                }
                else
                    Toast.makeText(Otp.this,"Wrong OTP",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
