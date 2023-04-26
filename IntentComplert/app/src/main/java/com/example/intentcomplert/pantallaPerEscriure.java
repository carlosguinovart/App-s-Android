package com.example.intentcomplert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class pantallaPerEscriure extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_per_escriure);
        editText = findViewById(R.id.inputText);
    }

    public void saveInputText(View view) {
        String text= editText.getText().toString();

        Intent resultat=new Intent();
        resultat.putExtra("text_resultat", text);
        setResult(RESULT_OK, resultat);
        finish();
    }
}