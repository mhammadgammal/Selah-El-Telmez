package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RegistrationHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "registrationdb";
    private static final String TABLE_NAME = "registration_table";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_GENDER = "gender";


    public RegistrationHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_EMAIL + " TEXT PRIMARY KEY, "
                + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_PASSWORD + " TEXT NOT NULL, "
                + COLUMN_GENDER + " TEXT NOT NULL)";
        db.execSQL(createQuery);
        //insertUser("Admin@administration.com", "Admins", "admin", "N/A");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String email, String name, String password, String gender)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues userRecord = new ContentValues();
        userRecord.put(COLUMN_EMAIL, email);
        userRecord.put(COLUMN_NAME, name);
        userRecord.put(COLUMN_PASSWORD, password);
        userRecord.put(COLUMN_GENDER, gender);
        long result = db.insert(TABLE_NAME, null, userRecord);
        return result != -1;
    }

    public boolean checkUsernamePassword(String email , String password) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME +  " where "  + COLUMN_EMAIL +  " = '" + email  + "' and " + COLUMN_PASSWORD  + " = '" + password + "'", null);

        return cursor.getCount() == 1;

        /*if (cursor.getCount() == 1)
            return true;
        else
            return false;*/
    }
}
