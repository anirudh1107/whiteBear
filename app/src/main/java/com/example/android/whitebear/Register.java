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

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private Button submit;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth=FirebaseAuth.getInstance();
        username=findViewById(R.id.register_username);
        password=findViewById(R.id.register_password);
        usernameWrapper=findViewById(R.id.register_username_wrapper);
        usernameWrapper.setHint("USERNAME");
        passwordWrapper=findViewById(R.id.register_password_wrapper);
        passwordWrapper.setHint("PASSWORD");

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
                                            startActivity(new Intent(Register.this,MainActivity.class));
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
