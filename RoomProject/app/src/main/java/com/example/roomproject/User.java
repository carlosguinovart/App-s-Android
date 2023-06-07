package com.example.roomproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int uid;
    @ColumnInfo(name="firstname")
    public String firstName;
    @ColumnInfo(name="lastname")
    public String lastName;

    public User(int uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){

    }
}
