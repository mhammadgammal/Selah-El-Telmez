package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.database.LectureModel;
import com.example.myapplication.R;
import com.example.selahel_telmez.adpters.DashboardAdapter;
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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AdminActivity extends AppCompatActivity implements DashboardAdapter.OnDeleteIcClickListener{
    int tableFlag = 0;
    List<String> coursesList = Arrays.asList("select Course…", "AI", "Archi", "DB", "Discrete", "DS", "LA", "Logic", "OR", "OOP", "Stat");
    EditText nameEDT;
    EditText linkEDT;
    Spinner courseSpinner;
    Button insertBTN;
    Button getAllBTN;
    RecyclerView dashboardRecycler;
    DashboardAdapter adapter;
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
    Toolbar toolbar;
    List<LectureModel> lectureModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);
        getSupportActionBar().setTitle("Admin Page");
        aiHelper =new AiCourseHelper(AdminActivity.this);
        archiHelper = new ArchiCourseHelper(AdminActivity.this);
        dbHelper = new DatabaseCourseHelper(AdminActivity.this);
        discreteHelper = new DiscreteCourseHelper(AdminActivity.this);
        dsHelper = new DsCourseHelper(AdminActivity.this);
        laHelper = new LACourseHelper(AdminActivity.this);
        logicHelper = new LogicCourseHelper(AdminActivity.this);
        oopHelper = new OOPCourseHelper(AdminActivity.this);
        orHelper = new ORCourseHelper(AdminActivity.this);
        statHelper = new StatCourseHelper(AdminActivity.this);

        courseSpinner = (Spinner) findViewById(R.id.coursesSpinner);
        adapter = new DashboardAdapter(this);
        dashboardRecycler = findViewById(R.id.dashboardRecyc);
        nameEDT = findViewById(R.id.lectureNameEDT);
        linkEDT = findViewById(R.id.linksEDT);
        insertBTN = findViewById(R.id.insertBTN);
        getAllBTN = findViewById(R.id.getAllBTN);
        courseSpinner.setAdapter(new ArrayAdapter<>(AdminActivity.this
                , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
                , coursesList));
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tableFlag = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(AdminActivity.this, "please select course", Toast.LENGTH_SHORT).show();
            }
        });

        insertBTN.setOnClickListener(view -> {
            LectureModel lecture = new LectureModel();
            switch (tableFlag){
                case 0:
                    dashboardRecycler.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    boolean insertion = aiHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    archiHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    dbHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    discreteHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    dsHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    laHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    logicHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 8:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    insertion = oopHelper.insertLecture(lecture);
                    Toast.makeText(this, insertion + "", Toast.LENGTH_SHORT).show();
                    break;
                case 9:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    orHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
                case 10:
                    try {
                        lecture.setName(nameEDT.getText().toString());
                        lecture.setLink(linkEDT.getText().toString());
                    }catch (NullPointerException e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    statHelper.insertLecture(lecture);
                    nameEDT.setText("");
                    linkEDT.setText("");
                    Toast.makeText(this,  "Lecture inserted", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        getAllBTN.setOnClickListener(view -> {
            switch (tableFlag) {
                case 0:
                    Toast.makeText(this, "select course", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    adapter.setLecture(aiHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 2:
                    adapter.setLecture(archiHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 3:
                    adapter.setLecture(dbHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 4:
                    adapter.setLecture(discreteHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 5:
                    adapter.setLecture(dsHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 6:
                    adapter.setLecture(laHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 7:
                    adapter.setLecture(logicHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 8:
                    adapter.setLecture(oopHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 9:
                    adapter.setLecture(orHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
                case 10:
                    adapter.setLecture(statHelper.getAllLectures());
                    dashboardRecycler.setAdapter(adapter);
                    break;
            }});
    }

    @Override
    public void onDeleteIcClickListener(int position) {
        LectureModel l = (LectureModel) dbHelper.getAllLectures().get(position);
        dbHelper.deleteLecture(l);
        adapter.setLecture(dbHelper.getAllLectures());
        dashboardRecycler.setAdapter(adapter);
        Toast.makeText(this, l.getName() +  " deleted", Toast.LENGTH_SHORT).show();

    }
}