package com.example.myapp.data.Repository;

import android.content.Context;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.database.DatabaseHelper;

import java.util.List;

public class DatabaseRepository {

    private static DatabaseRepository instance;

    DatabaseHelper db;

    public DatabaseRepository(Context context) {
        db = new DatabaseHelper(context);

    }

    public static DatabaseRepository getGetInstance(Context context){
        if(instance==null){

            instance = new DatabaseRepository(context);

        }

        return instance;
    }


    public void deleteAllPerClub(String club){

        db.deleteAll(club);
    }

    public List<Drink> getDrinksPerClub(String club){
       return db.getByClubId(club);
    }

    public void setDrinksInDB(Drink drink){
        db.addOneRow(drink);
    }


}
