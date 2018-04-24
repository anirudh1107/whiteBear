package com.example.android.whitebear.Adapters;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.whitebear.MainActivity;
import com.example.android.whitebear.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PayAmount extends AppCompatActivity {

    DatabaseReference ref;
    private String total;
    private String payed;
    private  String key;
    private long left;
    private TextView leftView;
    private Button pay;
    private EditText amount;
    private TextInputLayout amount_wrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_amount);

        leftView=findViewById(R.id.left_amount);
        Bundle extra=getIntent().getExtras();
        total=extra.getString("total");
        payed=extra.getString("payed");
        key=extra.getString("key");
        left=Long.parseLong(total)-Long.parseLong(payed);
        leftView.setText(String.valueOf(left));
        amount_wrapper=findViewById(R.id.amount_pay_wrapper);
        amount_wrapper.setHint("AMOUNT");
        amount=findViewById(R.id.amount_pay);
        pay=findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount.getText().toString().isEmpty())
                    Toast.makeText(PayAmount.this,"Please enter the amount to be paid",Toast.LENGTH_SHORT).show();
                else if((Long.parseLong(amount.getText().toString())+Long.parseLong(payed))>Long.parseLong(total))
                    Toast.makeText(PayAmount.this,"Please enter sensible amount",Toast.LENGTH_SHORT).show();
                else
                {
                    ref=FirebaseDatabase.getInstance().getReference().child("events").child(key);
                    ref.child("adMoney").setValue(String.valueOf(Long.parseLong(amount.getText().toString())+Long.parseLong(payed)));
                    startActivity(new Intent(PayAmount.this, MainActivity.class));
                    finish();
                }


            }
        });






    }
}
