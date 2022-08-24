package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.database.RegistrationHelper;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        final Button signup = (Button) findViewById(R.id.login);
        final EditText name=(EditText) findViewById(R.id.name);
        final EditText email=(EditText) findViewById(R.id.email);
        final EditText password=(EditText) findViewById(R.id.password);
        final EditText confirmation_password=(EditText) findViewById(R.id.confirmationpassword);
        final RegistrationHelper database = new RegistrationHelper(this);
        RadioButton maleRBTN=(RadioButton)findViewById(R.id.radioButton);
        RadioButton femaleRBTN=(RadioButton)findViewById(R.id.radioButton2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender;
                if (name.getText().toString().equals("") || name.getText().toString().equals(" ")
                        || email.getText().toString().equals("") || email.getText().toString().equals(" ")
                        || password.getText().toString().equals("") || password.getText().toString().equals(" ")
                        || confirmation_password.getText().toString().equals("") || confirmation_password.getText().toString().equals(" ")
                        || !(maleRBTN.isChecked()||femaleRBTN.isChecked()))
                    Toast.makeText(Signup.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else
                    if (!password.getText().toString().equals(confirmation_password.getText().toString()))
                        Toast.makeText(Signup.this, "Passwords not matched", Toast.LENGTH_SHORT).show();
                    else {
                        if (maleRBTN.isChecked())
                            gender = "male";
                        else
                            gender = "female";
                        database.insertUser(email.getText().toString(), name.getText().toString(), password.getText().toString(), gender);
                        Toast.makeText(Signup.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Signup.this, Login.class);
                        startActivity(intent);
                    }
            }
        });
    }
}