package com.example.firestoretest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        db = FirebaseFirestore.getInstance();
    }

    public void addClick(View view) {
        addRecipe();
    }


    public void addRecipe(){
        Map<String,Object> recipe=new HashMap<>();
        recipe.put("titulo", "lasaña");
        recipe.put("unidades", 5);

        db.collection("recetas").add(recipe).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.v("Test","document afegit amb id"+documentReference);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.v("test","ERROR",e);
            }
        });
    }

    public void listClicked(View view) {
        getList();
    }



    public void getList(){
        db.collection("recetas").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document: task.getResult()){
                                Log.v("Test", document.getId()+"->"+document.getData());
                            }
                        }else{
                            Log.v("Test", "ERROR");
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.v("test","ERROR",e);
                    }
                });
    }

    public void oneClicked(View view) {
        getOneRecipe();
    }



    public void getOneRecipe(){
        db.collection("recetas").document("2ZJtNsLRmZ9oafldCMsM")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    Log.v("Test", documentSnapshot.getId()+"->"+documentSnapshot.getData());

                }
            }
        });
    }

    public void fliterClicked(View view) {
        getListfilter();
    }



    public void getListfilter(){
        db.collection("recetas")
                .whereGreaterThan("unidades", 4)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document: task.getResult()){
                                Log.v("Test", document.getId()+"->"+document.getData());
                            }
                        }else{
                            Log.v("Test", "ERROR");
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.v("test","ERROR",e);
                    }
                });
    }
}