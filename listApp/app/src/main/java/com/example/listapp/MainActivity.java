package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ListFragment listFragment = ListFragment.newInstance();
        ft.add(R.id.list_fragment, listFragment);
        ft.commit();

    }

    @Override
    public void onItemClick(View view, int position, String task) {
        Log.v("CArlos",task);
        showDetail(task);

    }


    public void showDetail(String task){
        DetailFragment detailFragment = DetailFragment.newInstance(task);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.list_fragment, detailFragment);
        ft.commit();
    }


//GUARDA L'estat actual de les dades que necessiteem
/*
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("dataSet",dataSet);
        outState.putString("taskText", etTask.getText().toString());
        outState.putString("marca",etMarca.getText().toString());

        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dataSet=savedInstanceState.getParcelableArrayList("dataSet");
        etTask.setText(savedInstanceState.getString("taskText"));
        etMarca.setText(savedInstanceState.getString("marca"));

        taskAdapter=new TaskAdapter(dataSet);
        recyclerView.setAdapter(taskAdapter);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

       if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
           layoutManager=new GridLayoutManager(this,2);
       }else{
           layoutManager=new LinearLayoutManager(this);
       }
       recyclerView.setLayoutManager(layoutManager);
    }
    */

}