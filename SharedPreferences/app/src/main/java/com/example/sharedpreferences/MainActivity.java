package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etShared;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etShared=findViewById(R.id.etShared);
        sharedPreferences= getSharedPreferences("Preferencies", MODE_PRIVATE);

    }

    public void savePreferences(View view) {
        String text = etShared.getText().toString();

    }
}