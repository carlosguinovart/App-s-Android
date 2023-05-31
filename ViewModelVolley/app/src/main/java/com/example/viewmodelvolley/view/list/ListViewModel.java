package com.example.viewmodelvolley.view.list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.viewmodelvolley.datasource.VolleyFactory;
import com.example.viewmodelvolley.model.User;

import java.util.ArrayList;

public class ListViewModel extends AndroidViewModel {

    private ArrayList<User> dataSet;
    private MutableLiveData<ArrayList<User>> dataSetObservable;
    VolleyFactory volleyFactory;

    public ListViewModel(@NonNull Application application) {
        super(application);
        if (dataSet == null)
            dataSet = new ArrayList<>();
        if (dataSetObservable == null)
            dataSetObservable = new MutableLiveData<>();

        dataSetObservable.setValue(dataSet);

        volleyFactory = new VolleyFactory();
        volleyFactory.init(application, this);
    }


    public ArrayList<User> getDataSet() {
        return dataSet;
    }

    public MutableLiveData<ArrayList<User>> getDataSetObservable() {
        return dataSetObservable;
    }

    public void getFromAPIRest() {
        volleyFactory.callAPIListUsers();
    }
}
