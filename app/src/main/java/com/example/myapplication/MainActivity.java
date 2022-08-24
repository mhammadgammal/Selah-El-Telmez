package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity{

    private Spinner termSpinner;

    private ListView coursesListView;

    private  int termFlag = 0;

    private final List<String> courses = Arrays.asList("Select Term...", "Term 1", "Term 2");

    private final List<String> coursesTerm1 = Arrays.asList("Database Management System", "Discrete Mathematics", "Logic Design", "Object-Oriented Programming", "Statistics Analysis");

    private final List<String> coursesTerm2 = Arrays.asList("Artificial Intelligence", "Computer Architecture", "Data Structure", "Linear Algebra", "Operation Research");

    String courseFlag = " ";
    private Toolbar home_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Home Page");

        termSpinner = (Spinner) findViewById(R.id.term_spinner);

        coursesListView = (ListView) findViewById(R.id.coursesListItem);

        termSpinner.setAdapter(new ArrayAdapter<>(this
                , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
                , courses));

        termSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                switch (termSpinner.getSelectedItemPosition()){
                    case 0:
                        coursesListView.setVisibility(View.INVISIBLE);
                        break;
                    case 1:

                        coursesListView.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_list_item_activated_1,
                                coursesTerm1));
                        coursesListView.setVisibility(View.VISIBLE);
                        break;
                    case 2:

                        coursesListView.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_list_item_activated_1,
                                coursesTerm2));
                        coursesListView.setVisibility(View.VISIBLE);
                        break;
                }
                termFlag = termSpinner.getSelectedItemPosition();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO document why this method is empty
            }
        });
        coursesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (termFlag){
                    case 1:
                        courseFlag = coursesTerm1.get(i);
                        break;
                    case 2:
                        courseFlag = coursesTerm2.get(i);
                        break;
                }
                Intent intent = new Intent(MainActivity.this, LecturesActivity.class);
                intent.putExtra("termIndex", termFlag);
                intent.putExtra("courseIndex", i);
                intent.putExtra("courseFlag", courseFlag);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.about_Us:
                startActivity(new Intent(MainActivity.this, aboutu.class));
                return true;
            case R.id.check_For_Update:
                Toast.makeText(this, "You are up to date", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
