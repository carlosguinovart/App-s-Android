package com.example.apirest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    String url ="https://jsonplaceholder.typicode.com/users/";
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvResult);
        imageView = findViewById(R.id.ivFoto);

        Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);

//inicialitzar la queue
        queue = Volley.newRequestQueue(getApplicationContext());

;    }


    public void checkConect(View view) {

        if(isConnected()){
            textView.setText(R.string.ok);
        }else{
            textView.setText(R.string.error);
        }
    }


    public boolean isConnected(){
        ConnectivityManager connMgr= (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo= connMgr.getActiveNetworkInfo();

        if(netInfo!=null && netInfo.isConnected()){
            return true;
        }
        return false;
    }

    public void stringClicked(View view) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("TEST", response);
                String resultado = "";

                try {
                    JSONArray jsonArray= new JSONArray(response);
                    for(int i =0 ; i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        resultado += jsonObject.getString("name")+ "\n";
                    }
                    textView.setText(resultado);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Test", error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    public void jsonClicked(View view) {
        String new_url=url+"/1";

        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, new_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    textView.setText(response.getString("name"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test",error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void arrayClicked(View view) {

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String resultado="";
                try {
                    for (int i = 0; i<response.length();i++){
                        resultado += response.getJSONObject(i).getString("name");
                    }
                }catch (JSONException e){
                    throw new RuntimeException();
                }
                textView.setText(resultado);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test",error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);

    }


    public void jsonClickedGson(View view) {
        String new_url=url+"/1";
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, new_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    textView.setText(response.getString("name"));

                    Gson gson= new Gson();

                    //conversio directa a un objacte tipus User ;
                    User u = gson.fromJson(response.toString(), User.class);


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test",error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
    }


    public void arrayClickedGson(View view) {

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String resultado="";
                try {
                    for (int i = 0; i<response.length();i++){
                        resultado += response.getJSONObject(i).getString("name");
                    }

                    Gson gson = new Gson();
                    User[] userArray= gson.fromJson(response.toString(), User[].class);
                    for (User  user : userArray){
                        Log.v("Array", user.getName());
                    }

                }catch (JSONException e){
                    throw new RuntimeException();
                }
                textView.setText(resultado);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test",error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);

    }


    public void postClicked(View view) {
        JSONObject newObject = new JSONObject();
       try{

        newObject.put("name", "carlos");
        newObject.put("email", "carlos@gmail.com");
       }catch (JSONException e ){
           e.printStackTrace();
       }
       JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, newObject, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               Log.v("TEST", "post ok");
           }
       },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST", error.getMessage());
            }
        });
    }
}