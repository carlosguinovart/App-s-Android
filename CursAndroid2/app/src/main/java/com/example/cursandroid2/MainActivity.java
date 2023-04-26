package com.example.cursandroid2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUser;
    EditText editTextEmailAddress;
    EditText editTextPhone;
    EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.editTextUser);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);

        Log.v("Sessio1", "onCreate");
        Toast.makeText(this, "Starting", Toast.LENGTH_SHORT).show();


        final Button button = findViewById(R.id.cancelButton);

    }


    void clearData(View View){
        editTextUser.setText(null);
        editTextEmailAddress.setText(null);
        editTextPhone.setText(null);
        editTextPassword.setText(null);
    }


    public void acceptButton(View view) {
        String phone = editTextPhone.getText().toString();
        String name = editTextUser.getText().toString();
        String email = editTextEmailAddress.getText().toString();
        String password = editTextPassword.getText().toString();

        Toast.makeText(getApplicationContext(),"OKI DOKI",Toast.LENGTH_SHORT).show();

    }

    public void openDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle(getString(R.string.app_name)); //modificar el titol
        alertDialogBuilder.setMessage(R.string.preguntaCancelar)
                .setCancelable(false)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            //Que volem fer si clica que si.
                        editTextPhone.setText(null);
                        editTextUser.setText(null);
                        editTextEmailAddress.setText(null);
                        editTextPassword.setText(null);

                    }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); // No fem res, tanquem el Alert.
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create(); //crear el alert dialog
        alertDialog.show(); //mostrar per pantalla
    }


    public void cancelButton(View view) {
        openDialog();
    }
}