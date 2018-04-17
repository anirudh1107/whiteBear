package com.example.android.whitebear;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;

public class AddCustomer extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout name;
    private TextInputLayout address;
    private TextInputLayout emailId;
    private TextInputLayout phone;
    private EditText name_edit;
    private EditText address_edit;
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
        emailId=findViewById(R.id.customer_add_email_wrapper);
        phone=findViewById(R.id.customer_add_phone_wrapper);
        name_edit=findViewById(R.id.customer_add_name);
        address_edit=findViewById(R.id.customer_add_address);
        email_edit=findViewById(R.id.customer_add_email);
        phone_edit=findViewById(R.id.customer_add_phone);
        submit=findViewById(R.id.add_customer_submit);

        name.setHint("NAME");
        address.setHint("ADDRESS");
        emailId.setHint("EMAIL ID");
        phone.setHint("PHONE no.");
    }

    @Override
    public void onClick(View view) {

        int counta=0;
        int countd=0;
        for(int i=0;i<email_edit.getText().toString().length();i++)
        {
            if(email_edit.getText().toString().charAt(i)=='@')
                counta++;
            else if(email_edit.getText().toString().charAt(i)=='.')
                countd++;
        }
        if(name_edit.getText().toString().contains("0")||name_edit.getText().toString().contains("1")||name_edit.getText().toString().contains("2")||name_edit.getText().toString().contains("3")||name_edit.getText().toString().contains("4")||name_edit.getText().toString().contains("5")||name_edit.getText().toString().contains("6")||name_edit.getText().toString().contains("7")||name_edit.getText().toString().contains("8")||name_edit.getText().toString().contains("9"))
            Toast.makeText(this,"Name Box contains number",Toast.LENGTH_SHORT).show();

        else if(counta!=1 && countd==0)
            Toast.makeText(this,"Invalid Email Address",Toast.LENGTH_SHORT).show();

        else if(phone_edit.getText().toString().length()<10)
            Toast.makeText(this,"Invalid Phone Number",Toast.LENGTH_SHORT).show();

        else
        {
            reference=database.getReference().child("Users").push();
            reference.child("name").setValue(name_edit.getText().toString());
            reference.child("address").setValue(address_edit.getText().toString());
            reference.child("emailId").setValue(email_edit.getText().toString());
            reference.child("phone").setValue(phone_edit.getText().toString());

            Random random=new Random();
            int x=random.nextInt(1000);
            String s=""+name_edit.getText().toString().substring(0,2)+x;
            reference.child("cusId").setValue(s);

            startActivity(new Intent(AddCustomer.this,MainActivity.class));
            finish();
        }

    }
}
