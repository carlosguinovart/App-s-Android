package com.example.listapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

import androidx.annotation.NonNull;

public class Task implements Parcelable {
    private int id;
    private String task;
   // private String marca;


    public Task(String task) {
        this.id=new Random().nextInt(99999);
        this.task = task;
        //this.marca = marca;
    }
    public Task(Parcel in) {
        super();
        readFromParcel(in);

    }
    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel parcel) {
            return null;
        }

        @Override
        public Task[] newArray(int i) {
            return new Task[0];
        }
    };
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

   // public String getMarca() {
       // return marca;
   // }

   // public void setMarca(String marca) {
        //this.marca = marca;
   // }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(task);
        //parcel.writeString(marca);
    }

    public void readFromParcel(Parcel in){
        id=in.readInt();
        task=in.readString();
       // marca=in.readString();
    }


}
