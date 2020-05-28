package com.example.celebrum_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    ImageView mButton;
    TextView mTextButton;

    FirebaseAuth mAuth;
    EditText mUserName, mUserPassword, mUserEmail;
    String mStringUserName, mStringUserEmail, mStringUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        mUserEmail = findViewById(R.id.user_email);
        mUserPassword = findViewById(R.id.user_password);

        mTextButton = findViewById(R.id.register_text_button);
        mTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mStringUserEmail = mUserEmail.getText().toString().trim();
                mStringUserPassword = mUserPassword.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(mStringUserEmail, mStringUserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(RegisterActivity.this, BaseActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Something wrong. Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}