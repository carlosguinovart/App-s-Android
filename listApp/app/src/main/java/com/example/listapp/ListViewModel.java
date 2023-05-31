package com.example.listapp;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListViewModel extends ViewModel {


   private ArrayList<Task> dataSet;
   private MutableLiveData<ArrayList<Task>> dataSetObservable;

    public ArrayList<Task> getDataSet() {
        return dataSet;
    }

    public MutableLiveData<ArrayList<Task>> getDataSetObservable() {
        return dataSetObservable;
    }

    public void init(){
        if(dataSet==null){
            dataSet =new ArrayList<>();
            createDummyContent();
        }
        if(dataSetObservable==null){
            dataSetObservable=new MutableLiveData<>();
        }
        dataSetObservable.setValue(dataSet);
    }

    private void createDummyContent() {
        dataSet.add(new Task("Task 1"));
        dataSet.add(new Task("Task 2"));
    }

    public void refreshObservable(){
        dataSetObservable.setValue(dataSet);
    }
}
