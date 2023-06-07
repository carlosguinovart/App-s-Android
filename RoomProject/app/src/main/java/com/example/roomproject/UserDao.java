package com.example.roomproject;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM  user")

    List<User> getAll();


    @Query("SELECT * FROM user Where uid in (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user Where firstname LIKE :first AND lastname LIKE :last")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

}
