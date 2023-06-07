package com.example.roomproject;

import android.app.Application;

import java.util.List;

import androidx.room.Room;

public class UserController {

    private static UserController userController;
    private UserDao userDao;

    public UserController(Application application) {
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "myDatabase").allowMainThreadQueries().build();


        userDao = db.userDao();
    }


    public void insertUser(User user){

        userDao.insertAll(user);
    }

    public List<User> listUsers(){
        return userDao.getAll();
    }
}
