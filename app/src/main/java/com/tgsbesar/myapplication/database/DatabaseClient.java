package com.tgsbesar.myapplication.database;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient databaseClient;

    private AppDatabase databaseUser;

    private DatabaseClient(Context context){
        this.context=context;
        databaseUser = Room.databaseBuilder(context, AppDatabase.class, "user").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(databaseClient==null){
            databaseClient = new DatabaseClient(context);
        }
        return databaseClient;
    }

    public AppDatabase getDatabaseUser(){ return databaseUser; }
}