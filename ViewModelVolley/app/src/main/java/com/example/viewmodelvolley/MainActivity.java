package com.example.viewmodelvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.viewmodelvolley.view.list.ListFragment;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment retainedFragment = fm.findFragmentById(R.id.list_fragment);
        if (retainedFragment == null) { //Crea el primer cop
            listFragment = ListFragment.newInstance(); //Init un cop.
            ft.add(R.id.list_fragment, listFragment);
        }else{ //Aprofita les següents
            listFragment= (ListFragment) retainedFragment;
            ft.replace(R.id.list_fragment, listFragment);
        }

        ft.commit();
    }
}