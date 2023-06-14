package com.example.storagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference gsReference =storage.getReferenceFromUrl("gs://storagetest-68630.appspot.com/la-gran-via-de-madrid-1072541.webp");

        ImageView imageView = findViewById(R.id.ivGlide);

        Glide.with(this).load(gsReference).into(imageView);


    }
}