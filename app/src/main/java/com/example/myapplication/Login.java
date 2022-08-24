package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.RegistrationHelper;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Button login = (Button) findViewById(R.id.login);
        TextView register = (TextView) findViewById(R.id.register);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        final RegistrationHelper database = new RegistrationHelper(this);


        login.setOnClickListener(v -> {
            if (email.getText().toString().equals("")||password.getText().toString().equals("")
                    ||email.getText().toString().equals(" ")||password.getText().toString().equals(" "))
                Toast.makeText(Login.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            else {
                boolean check = database.checkUsernamePassword(email.getText().toString(), password.getText().toString());
                if (check) {
                    Toast.makeText(Login.this, "Login Successfully ", Toast.LENGTH_SHORT).show();
                    if (email.getText().toString().equals("Admin@administration.com"))
                        startActivity(new Intent(Login.this, AdminActivity.class));
                    else
                        startActivity(new Intent(Login.this, MainActivity.class));
                } else {
                    Toast.makeText(Login.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
                }
            }

        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
        });
    }
}