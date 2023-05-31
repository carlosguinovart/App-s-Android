package com.example.bottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    EditText etMail, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();

        etMail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void registerClicked(View view) {
        String mail = etMail.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful()){
                    Log.v("carlos", "OK");
                    finish();
                }else{
                    Log.v("Carlos", task.getException().getMessage());
                }
            }
        });

    }

    public void loginClick(View view) {
        String mail = etMail.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful()){
                    Log.v("carlos", "Login OK");
                    finish();
                }else{
                    Log.v("Carlos", task.getException().getMessage());
                }
            }
        });

    }
    public void logoutClicked(View view){
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            FirebaseAuth.getInstance().signOut();
        }
    }
}