package com.example.bottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    ProfileFragment profileFragment;
    HomeFragment homeFragment;
    SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigationView.setSelectedItemId(R.id.ic_profile);

        profileFragment=ProfileFragment.newInstance();
        homeFragment=HomeFragment.newInstance();
        settingsFragment=SettingsFragment.newInstance();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.v("carlos", item.getItemId()+"");
        return false;
    }
}