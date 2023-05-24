package com.example.bottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    ProfileFragment profileFragment;
    HomeFragment homeFragment;
    SettingsFragment settingsFragment;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        profileFragment=ProfileFragment.newInstance();
        homeFragment=HomeFragment.newInstance();
        settingsFragment=SettingsFragment.newInstance();

        bottomNavigationView.setSelectedItemId(R.id.ic_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser ==null){//no hi ha user
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.v("carlos", item.getItemId()+"");
        FragmentManager fm= getSupportFragmentManager();
        switch (item.getItemId()){
            case R.id.ic_profile:
                fm.beginTransaction().replace(R.id.fl_content,profileFragment)
                        .commit();
                break;
            case R.id.ic_home:
                fm.beginTransaction().replace(R.id.fl_content,homeFragment)
                        .commit();
                break;
            case R.id.ic_settings:
                fm.beginTransaction().replace(R.id.fl_content,settingsFragment)
                        .commit();
                break;
        }
        return true;
    }





}