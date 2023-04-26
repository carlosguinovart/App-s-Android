package com.example.intentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.EditText;
import android.widget.ResourceCursorAdapter;

public class MainActivity extends AppCompatActivity {

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextIntput);


    }

    public void enviarIntent(View view) {
        // get text from editText id = editTextIntput;
        String resultat = editText.getText().toString();

        Intent intent = new Intent(getApplicationContext(), resultIntentActivity.class);
        intent.putExtra("resultat", resultat);
        startActivity(intent);



    }
}