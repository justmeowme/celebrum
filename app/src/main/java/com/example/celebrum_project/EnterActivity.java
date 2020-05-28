package com.example.celebrum_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EnterActivity extends AppCompatActivity {

    TextView mOpenRegister, mText;;
    EditText mUserEmail, mUserPassword;
    String mStringUserEmail, mStringUserPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        mAuth = FirebaseAuth.getInstance();

        mOpenRegister = findViewById(R.id.open_register_window);
        mText = findViewById(R.id.enter_text_button);
        mOpenRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mUserEmail = findViewById(R.id.user_email);
        mUserPassword = findViewById(R.id.user_password);

        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStringUserEmail = mUserEmail.getText().toString().trim();
                mStringUserPassword = mUserPassword.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(mStringUserEmail, mStringUserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(EnterActivity.this, BaseActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(EnterActivity.this, "Incorrect data. Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
