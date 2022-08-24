package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.adpters.LectureAdapter;
import com.example.database.AiCourseHelper;
import com.example.database.ArchiCourseHelper;
import com.example.database.DatabaseCourseHelper;
import com.example.database.DiscreteCourseHelper;
import com.example.database.DsCourseHelper;
import com.example.database.LACourseHelper;
import com.example.database.LectureModel;
import com.example.database.LogicCourseHelper;
import com.example.database.OOPCourseHelper;
import com.example.database.ORCourseHelper;
import com.example.database.StatCourseHelper;

import java.util.ArrayList;
import java.util.List;

public class LecturesActivity extends AppCompatActivity implements LectureAdapter.OnLectureClickListener{
    RecyclerView lectureListRecyc;
    List<LectureModel> lectureModelList = new ArrayList<>();
    LectureAdapter adapter;
    AiCourseHelper aiHelper;
    ArchiCourseHelper archiHelper;
    DatabaseCourseHelper dbHelper;
    DiscreteCourseHelper discreteHelper;
    DsCourseHelper dsHelper;
    LACourseHelper laHelper;
    LogicCourseHelper logicHelper;
    OOPCourseHelper oopHelper;
    ORCourseHelper orHelper;
    StatCourseHelper statHelper;
    /*adapter.setLectures(lectureModelList);
            lectureListRecyc.setAdapter(adapter);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("courseFlag"));
        dbHelper = new DatabaseCourseHelper(this);
        lectureListRecyc = findViewById(R.id.lectureListRecyc);
        adapter = new LectureAdapter(this);
        aiHelper =new AiCourseHelper(LecturesActivity.this);
        archiHelper = new ArchiCourseHelper(LecturesActivity.this);
        dbHelper = new DatabaseCourseHelper(LecturesActivity.this);
        discreteHelper = new DiscreteCourseHelper(LecturesActivity.this);
        dsHelper = new DsCourseHelper(LecturesActivity.this);
        laHelper = new LACourseHelper(LecturesActivity.this);
        logicHelper = new LogicCourseHelper(LecturesActivity.this);
        oopHelper = new OOPCourseHelper(LecturesActivity.this);
        orHelper = new ORCourseHelper(LecturesActivity.this);
        statHelper = new StatCourseHelper(LecturesActivity.this);

        switch (intent.getIntExtra("termIndex", -1)){
            case 0:
                Toast.makeText(this, "Select a term...", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                switch (intent.getIntExtra("courseIndex", -1)){
                    case 0:
                        lectureModelList = dbHelper.getAllLectures();
                    adapter.setLectures(lectureModelList);
                    lectureListRecyc.setAdapter(adapter);break;
                    case 1:
                        lectureModelList = discreteHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 2:
                        lectureModelList = logicHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 3:
                        lectureModelList = oopHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 4:
                        lectureModelList = statHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                }
            break;
            case 2:
                switch (intent.getIntExtra("courseIndex", -1)){
                    case 0:
                        lectureModelList = aiHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 1:
                        lectureModelList = archiHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 2:
                        lectureModelList = dsHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 3:
                        lectureModelList = laHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                    case 4:
                        lectureModelList = orHelper.getAllLectures();
                        adapter.setLectures(lectureModelList);
                        lectureListRecyc.setAdapter(adapter);break;
                }
                break;
        }
    }

    @Override
    public void onLectureClickListener(int pos) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(lectureModelList.get(pos).getLink()));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }
}