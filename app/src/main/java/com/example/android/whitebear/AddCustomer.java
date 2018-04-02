package com.example.android.whitebear;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;

public class AddCustomer extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout name;
    private TextInputLayout address;
    private TextInputLayout uid;
    private TextInputLayout emailId;
    private TextInputLayout phone;
    private EditText name_edit;
    private EditText address_edit;
    private EditText uid_edit;
    private EditText email_edit;
    private EditText phone_edit;
    private Button submit;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        database=FirebaseDatabase.getInstance();
        init();
        submit.setOnClickListener(this);





    }

    void init()
    {
        name=findViewById(R.id.customer_add_name_wrapper);
        address = findViewById(R.id.customer_add_address_wrapper);
        uid=findViewById(R.id.customer_add_eventid_wrapper);
        emailId=findViewById(R.id.customer_add_email_wrapper);
        phone=findViewById(R.id.customer_add_phone_wrapper);
        name_edit=findViewById(R.id.customer_add_name);
        address_edit=findViewById(R.id.customer_add_address);
        uid_edit=findViewById(R.id.customer_add_eventid);
        email_edit=findViewById(R.id.customer_add_email);
        phone_edit=findViewById(R.id.customer_add_phone);
        submit=findViewById(R.id.add_customer_submit);

        name.setHint("NAME");
        address.setHint("ADDRESS");
        uid.setHint("EVENT ID");
        emailId.setHint("EMAIL ID");
        phone.setHint("PHONE no.");
    }

    @Override
    public void onClick(View view) {

        reference=database.getReference().child("Users").push();
        reference.child("name").setValue(name_edit.getText().toString());
        reference.child("address").setValue(address_edit.getText().toString());
        reference.child("eventId").setValue(uid_edit.getText().toString());
        reference.child("emailId").setValue(email_edit.getText().toString());
        reference.child("phone").setValue(phone_edit.getText().toString());

        Random random=new Random(1000);
        int x=random.nextInt();
        String s="AB"+x;
        reference.child("cusId").setValue(s);

        startActivity(new Intent(AddCustomer.this,MainActivity.class));
        finish();
    }
}
