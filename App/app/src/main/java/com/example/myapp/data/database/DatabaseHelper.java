package com.example.myapp.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapp.data.Drinks.Drink;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COLUMN_ID = "ID";//column 0
    public static final String DRINKS_TABLE = "DRINKS_TABLE";
    public static final String COLUMN_TITLE = "TITLE";//column 1
    public static final String COLUMN_PRICE = "PRICE";//column 2
    public static final String COLUMN_IMAGE = "IMAGE";//column 3
    public static final String COLUMN_RANK = "RANK";//column 4
    public static final String COLUMN_PRICEINT = "PRICEINT";//column 6
    public static final String COLUMN_CLUBID = "CLUB";//column 8
    public static final String COLUMN_KLUBID = "KLUB";//column 9

    public DatabaseHelper(@Nullable Context context) {
        super(context, "DRINK_FINAL", null, 2);
    }

    //on create is called the first time you try to acccess the database object. Therefore you should have code that generate a new db
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DRINKS_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT, " + COLUMN_PRICE + " TEXT, " + COLUMN_IMAGE + " INT, " + COLUMN_RANK + " INT)";

        db.execSQL(createTableStatement);
        Log.d("creating","Creating DB");
    }
    //called whenever the database number changes. prevents previous users apps from breaking  when you change the db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //working
    /*public List<Drink> getAllDrinks(){
        List<Drink> list = new ArrayList<>();

        String query = "SELECT * FROM " + DRINKS_TABLE + " ORDER BY "+ COLUMN_TITLE;

        SQLiteDatabase database = this.getReadableDatabase();


        Cursor cursor = database.rawQuery(query,null);

        if(cursor.moveToFirst()){
            //loop through the result

            do{
                int columnId = cursor.getInt(0);
                String drink = cursor.getString(1);
                String price = cursor.getString(2);
                int image = cursor.getInt(3);
                int rank = cursor.getInt(4);
                int pricetag = cursor.getInt(6);
                String clubId = cursor.getString(8);




                Drink newDrinkAdding = new Drink(columnId,drink,price,image,rank,pricetag,clubId);
                list.add(newDrinkAdding);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        database.close();


        return list;
    }
*/


    public List<Drink> getByClubId(String club){
        List<Drink> list = new ArrayList<>();

        String query = "SELECT * FROM " + DRINKS_TABLE +" WHERE "+COLUMN_CLUBID+"='"+club+"' ORDER BY "+ COLUMN_TITLE;

        SQLiteDatabase database = this.getReadableDatabase();


        Cursor cursor = database.rawQuery(query,null);

        if(cursor.moveToFirst()){
            //loop through the result

            do{
                int columnId = cursor.getInt(0);
                String drink = cursor.getString(1);
                String price = cursor.getString(2);
                int image = cursor.getInt(3);
                int rank = cursor.getInt(4);
                int pricetag = cursor.getInt(6);
                String clubId = cursor.getString(8);


                Drink newDrinkAdding = new Drink(columnId,drink,price,image,rank,pricetag,clubId);


                list.add(newDrinkAdding);
                Log.d("database",newDrinkAdding.toString());
            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        database.close();


        return list;
    }




    //working
    public boolean deleteAll(String currentClub){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+ DRINKS_TABLE +" WHERE "+COLUMN_CLUBID+"='"+currentClub+"'";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }


    }

    //working
    public boolean addOneRow(Drink drink) {


        if (!checkForDuplicates(drink)) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contenv = new ContentValues();


            contenv.put(COLUMN_TITLE, drink.getTitle());
            contenv.put(COLUMN_PRICE, drink.getPrice());
            contenv.put(COLUMN_IMAGE, drink.getImage());
            contenv.put(COLUMN_RANK, drink.getPopularity()+1);
            contenv.put(COLUMN_PRICEINT, drink.getPricetag());
            contenv.put(COLUMN_CLUBID,drink.getClubId());



            long insert = db.insert(DRINKS_TABLE, null, contenv);
            if (insert == -1) {
                return false;
            }
            else {
                Log.d("vman","calling addOneRow");
                return true;
            }
        }
        else {
            upDate(drink);
        }

        return false;
    }

    //working
        public boolean checkForDuplicates(Drink drink){

        String query = "SELECT * FROM " + DRINKS_TABLE + " WHERE "+COLUMN_TITLE+"='"+drink.getTitle()+"'";

        SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){
                cursor.close();
                db.close();

                Log.d("status","success there is a duplicate");

                return true;
            }
            else{
                cursor.close();
                db.close();
                Log.d("status","failure there is not a duplicate");
                return false;
            }




        }

    //working
    public void upDate(Drink drink){

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contenv = new ContentValues();



            String query = "UPDATE "+ DRINKS_TABLE +" SET RANK = RANK +"+1 +" WHERE TITLE= "+"'"+drink.getTitle()+"'";

            Cursor update = db.rawQuery(query,null);
            if (update.moveToFirst()) {
                Log.d("status","false");
            } else {
                Log.d("status","true");
            }


    }

    /*public List<Drink> getAllDrinksByPopularity(){
        List<Drink> list = new ArrayList<>();

        String query = "SELECT * FROM " + DRINKS_TABLE + " ORDER BY "+ COLUMN_TITLE;

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery(query,null);

        if(cursor.moveToFirst()){
            //loop through the result

            do{
                int columnId = cursor.getInt(0);
                String drink = cursor.getString(1);
                String price = cursor.getString(2);
                int image = cursor.getInt(3);
                int rank = cursor.getInt(4);
                Drink newDrinkAdding = new Drink(columnId,drink,price,image,rank);
                list.add(newDrinkAdding);
            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        database.close();


        return list;
    }*/
}
