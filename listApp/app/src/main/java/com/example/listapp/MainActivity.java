package com.example.listapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Task> dataSet;

    RecyclerView recyclerView;

    TaskAdapter taskAdapter;

    EditText editText;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet=new ArrayList<>();

        recyclerView=findViewById(R.id.list);
        editText=findViewById(R.id.addToList);


        layoutManager=new LinearLayoutManager(this);
        // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        // RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);

        if(savedInstanceState==null){
            createDummyContent();
            taskAdapter =new TaskAdapter(dataSet);
            recyclerView.setAdapter(taskAdapter);

        }

        taskAdapter=new TaskAdapter(dataSet);
        recyclerView.setAdapter(taskAdapter);
    }


    private void createDummyContent(){
        dataSet.add(new Task("Task 1"));
        dataSet.add(new Task("Task 2"));
    }

    public void addTask(View View){
        String text= editText.getText().toString();
        dataSet.add(new Task(text));
        taskAdapter.notifyDataSetChanged();
        editText.setText("");
    }

//GUARDA L'estat actual de les dadesque necessiteem

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("dataSet",dataSet);
        outState.putString("taskText", editText.getText().toString());
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dataSet=savedInstanceState.getParcelableArrayList("dataSet");
        editText.setText(savedInstanceState.getString("taskText"));
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
}