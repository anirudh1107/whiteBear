package com.example.android.whitebear;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText name;
    private EditText phone;
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private TextInputLayout name_wrapper;
    private TextInputLayout phone_wrapper;
    private Button submit;
    private TextInputLayout EmployeeidWrapper;
    private EditText employeeeId;
    private DatabaseReference ref;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth=FirebaseAuth.getInstance();
        username=findViewById(R.id.register_username);
        password=findViewById(R.id.register_password);
        name=findViewById(R.id.register_name);
        phone=findViewById(R.id.register_phone);
        usernameWrapper=findViewById(R.id.register_username_wrapper);
        usernameWrapper.setHint("USERNAME");
        passwordWrapper=findViewById(R.id.register_password_wrapper);
        passwordWrapper.setHint("PASSWORD");
        name_wrapper=findViewById(R.id.register_name_wrapper);
        name_wrapper.setHint("NAME");
        phone_wrapper=findViewById(R.id.register_phone_wrapper);
        phone_wrapper.setHint("PHONE");
        EmployeeidWrapper=findViewById(R.id.register_employee_wrapper);
        EmployeeidWrapper.setHint("Employee Id");
        employeeeId=findViewById(R.id.register_employee);


        submit=findViewById(R.id.register_register);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.register_register);
                {
                    auth.createUserWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                auth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if(task.isSuccessful())
                                        {
                                            ref= FirebaseDatabase.getInstance().getReference().child("employee").child(employeeeId.getText().toString());
                                            ref.child("name").setValue(name.getText().toString());
                                            ref.child("phone").setValue(phone.getText().toString());
                                            ref.child("EmpId").setValue(employeeeId.getText().toString());
                                            startActivity(new Intent(Register.this,MainActivity.class));
                                            finish();
                                        }
                                    }
                                });
                            }
                            else
                                Toast.makeText(Register.this,"Network not found",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
