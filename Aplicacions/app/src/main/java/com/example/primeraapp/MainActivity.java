package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Sessio1", "onCreate");
        editText = findViewById(R.id.editTextPersonName);
        final Button button = findViewById(R.id.aceptButton);

        Toast.makeText(this, "HOLA", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("Sessio1", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("Sessio1", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("Sessio1", "onDestroy");
    }

    public void onClickAccept(View View){
        String n= editText.getText().toString();
        TextView textSet = findViewById(R.id.setText);
        textSet.setText(n);
    }

    public void onClickCancel(View View){
        TextView textSet = findViewById(R.id.setText);
        textSet.setText(null);
    }
}