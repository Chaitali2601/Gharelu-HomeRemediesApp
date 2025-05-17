package com.example.healthdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    // Constructor for Database Helper
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        // Creating a users table
        String qry1 = "CREATE TABLE users (username TEXT, email TEXT, password TEXT)";
        sqliteDatabase.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int oldVersion, int newVersion) {
        // Drop the table if it exists and recreate (if upgrading database version)
        sqliteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqliteDatabase);
    }

    // Method to register a user
    public void register(String username, String email, String password) {
        // Creating a ContentValues object to store data
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);

        // Getting a writable database instance
        SQLiteDatabase db = this.getWritableDatabase();

        // Inserting the values into the users table
        db.insert("users", null, cv);

        // Closing the database connection
        db.close();
    }
}
