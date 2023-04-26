package com.example.intentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class resultIntentActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_intent);

        textView =findViewById(R.id.outputText);
        String resultat = getIntent().getStringExtra("resultat");

        textView.setText(resultat);

    }
}