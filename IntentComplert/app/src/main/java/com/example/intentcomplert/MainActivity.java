package com.example.intentcomplert;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textViewOutput;

    ImageView imageView;
    ActivityResultLauncher<Intent> activityResultLauncher, passingTextResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextInput);
        textViewOutput=findViewById(R.id.outputView);

        passingTextResult= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){
                            String text= result.getData().getStringExtra("text_resultat");
                            textViewOutput.setText(text);
                        }
                    }
                });



    }

    public void openWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);
    }


    public void openMaps(View view) {
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void shareButton(View view) {
        // get text from editText id = editTextIntput;
        String resultat = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, resultat);
        startActivity(Intent.createChooser(intent, "Compartir con"));
    }


    public void sendMailOnClick(View view) {
        // get text from editText id = editTextIntput;
        String resultat = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, resultat);
        intent.putExtra(Intent.EXTRA_EMAIL,
                "hello@email.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
        startActivity(intent);

    }

    public void takePicture(View View){
        Intent takeIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    }

    public void recollirText(View view) {
        Intent intent = new Intent(this, pantallaPerEscriure.class);
        passingTextResult.launch(intent);
    }
}