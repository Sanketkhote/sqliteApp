package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "cars";

    // below int is our database version
    private static final int DB_VERSION = 1;


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE carDetails (name TEXT PRIMARY KEY, brand TEXT, price TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS carDetails");
        onCreate(sqLiteDatabase);
    }

    public void addCarDetails(String name, String brand, String price) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("name", name);
        values.put("brand", brand);
        values.put("price", price);

        // after adding all values we are passing
        // content values to our table.
        db.insert("carDetails", null, values);

        // at last we are closing our
        // database after adding database.
      //  db.close();
    }

    public ArrayList<String> carList() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCars= db.rawQuery("SELECT name FROM carDetails", null);

        // on below line we are creating a new array list.
        ArrayList<String> carList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCars.moveToFirst()) {
            do {
                Log.e("abc",cursorCars.getString(0));
                // on below line we are adding the data from cursor to our array list.
                carList.add(cursorCars.getString(0));
            } while (cursorCars.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCars.close();
        return carList;
    }

    public class carDetail{
        String name,brand,price;

        public void carDetail(){
            name=new String();
            brand=new String();
            price=new String();
        }
    }
    public carDetail showCarDetails(String carName){
        carDetail carDetailData=new carDetail();
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCars= db.rawQuery("SELECT name,brand,price FROM carDetails where name = \""+ carName +"\"", null);

        if (cursorCars.moveToFirst()) {
            do {
                Log.e("abc",cursorCars.getString(0));
                // on below line we are adding the data from cursor to our array list.
                carDetailData.name=cursorCars.getString(0);
                carDetailData.brand=cursorCars.getString(1);
                carDetailData.price=cursorCars.getString(2);
            } while (cursorCars.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCars.close();
        return carDetailData;
    }


}
