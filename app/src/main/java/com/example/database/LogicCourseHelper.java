package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LogicCourseHelper extends SQLiteOpenHelper {
    private static final String  NAME = "logiccourse.db";
    private static final String TABLE_NAME = "LOGIC_TABLE"
            , COLUMN_LECTURE_ID = "ID"
            , COLUMN_LECTURE_NAME = "lec_name"
            , COLUMN_LECTURE_LINK = "lec_link";
    public LogicCourseHelper(@Nullable Context context) {
        super(context, NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createExec = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_LECTURE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_LECTURE_NAME + " TEXT UNIQUE, " + COLUMN_LECTURE_LINK + " TEXT)";

        db.execSQL(createExec);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);    }

    public boolean insertLecture(LectureModel lecture) {

        SQLiteDatabase db = this .getWritableDatabase();
        ContentValues lectureRecord = new ContentValues();
        lectureRecord.put(COLUMN_LECTURE_NAME, lecture.getName());
        lectureRecord.put(COLUMN_LECTURE_LINK, lecture.getLink());
        long insert = db.insert(TABLE_NAME, null, lectureRecord);

        return insert != -1;
    }

    public List<LectureModel> getAllLectures(){
        List<LectureModel> lectureModelList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAllQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllQuery, null);
        if (cursor.moveToFirst()){
            do {
                String cursorName = cursor.getString(1);
                String cursorLink = cursor.getString(2);
                LectureModel lecture = new LectureModel();
                lecture.setName(cursorName);
                lecture.setLink(cursorLink);
                lectureModelList.add(lecture);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lectureModelList;
    }

    public void deleteLecture(LectureModel model){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_LECTURE_NAME + " = '" + model.getName() + "'", null);
        db.close();
    }
}
