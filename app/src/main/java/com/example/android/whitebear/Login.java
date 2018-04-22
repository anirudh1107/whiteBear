package com.example.android.whitebear;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth auth;
    private EditText user;
    private EditText password;
    private TextInputLayout user_wrapper;
    private TextInputLayout password_wrapper;
    private Button login;
    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user=findViewById(R.id.login_username);
        password=findViewById(R.id.login_password);
        user_wrapper=findViewById(R.id.login_username_wrapper);
        user_wrapper.setHint("USERNAME");
        password_wrapper=findViewById(R.id.login_password_wrapper);
        password_wrapper.setHint("PASSWORD");
        login=findViewById(R.id.login_login);
        register=findViewById(R.id.login_register);



        auth=FirebaseAuth.getInstance();

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.login_login && !user.getText().toString().isEmpty() && !password.getText().toString().isEmpty())
        {
            auth.signInWithEmailAndPassword(user.getText().toString(),password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        startActivity(new Intent(Login.this,MainActivity.class));
                        finish();
                    }
                    else
                        Toast.makeText(Login.this,"Wrong UserName or Password",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if(view.getId()==R.id.login_register) {
            startActivity(new Intent(Login.this, Register.class));
        }

    }
}
