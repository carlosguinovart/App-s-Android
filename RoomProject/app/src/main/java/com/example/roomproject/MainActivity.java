package com.example.roomproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserController userController = new UserController(getApplication());
        User u = new User(2, "carlos", "guinovart");
        userController.insertUser(u);

        List<User> users = userController.listUsers();
        for(int i =0; i <users.size(); i++){
            Log.v("test", users.get(i).firstName+" "+users.get(i).lastName);
        }




    }
}