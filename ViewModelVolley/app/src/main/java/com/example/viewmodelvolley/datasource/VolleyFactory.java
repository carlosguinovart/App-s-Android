package com.example.viewmodelvolley.datasource;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.viewmodelvolley.model.User;
import com.example.viewmodelvolley.view.list.ListViewModel;
import com.google.gson.Gson;

import org.json.JSONArray;

public class VolleyFactory {


    private String url = "https://jsonplaceholder.typicode.com/users";
    RequestQueue queue;
    ListViewModel listViewModel;

    public String getUrl() {
        return url;
    }

    public void init(Context c, ListViewModel listViewModel) {
        if (queue == null)
            queue = Volley.newRequestQueue(c);

        this.listViewModel = listViewModel;
    }


    public void callAPIListUsers() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listViewModel.getDataSet().clear();
                Gson gson = new Gson();
                User[] userArray = gson.fromJson(response.toString(), User[].class);

                for (User user : userArray) {
                    listViewModel.getDataSet().add(user);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST", error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
}
