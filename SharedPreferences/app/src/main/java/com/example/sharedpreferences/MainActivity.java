package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etShared;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etShared=findViewById(R.id.etShared);
        sharedPreferences= getSharedPreferences(getString(R.string.shared_file), MODE_PRIVATE);

        String guardat = sharedPreferences.getString("textGuardat", "");

        etShared.setText(guardat);
        int contador = 0;

        Toast.makeText(this, contador, Toast.LENGTH_SHORT).show();

    }

    public void savePreferences(View view) {
        String text = etShared.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("textGuardat",text);
        editor.commit();


    }

    public void openClicked(View view) {

        Intent intent = new Intent(this, SegonaActivity.class);
        startActivity(intent);


    }
}