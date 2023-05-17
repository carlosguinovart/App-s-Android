package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class SegonaActivity extends AppCompatActivity {

    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segona);


        prefs = getSharedPreferences(getString(R.string.shared_file), MODE_PRIVATE);

        int contador = prefs.getInt("contador", 0);
        contador++;

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("contador", contador);
        editor.commit();




    }
}