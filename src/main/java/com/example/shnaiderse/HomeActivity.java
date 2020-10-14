package com.example.shnaiderse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.*;
import java.util.Scanner;
public class HomeActivity extends AppCompatActivity{
    private Button btnActTwo;
    private EditText login;
    private EditText password;
    private TextView attempts;
    private TextView numberOfAttempts;
    private TextView loginLocked;
    int number = 3;
    private TextView Name;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        login=(EditText) findViewById(R.id.edit_login);
        password=(EditText) findViewById(R.id.edit_password);
        btnActTwo=(Button) findViewById(R.id.btnActTwo);
        loginLocked=(TextView) findViewById((R.id.login_locked));
        attempts=(TextView) findViewById(R.id.attempts);
        numberOfAttempts=(TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts.setText(Integer.toString(number));


    }
    public void Login(View view){
        String Name=getIntent().getStringExtra("Name");
        String Password=getIntent().getStringExtra("Password");
        if (login.getText().toString().equals(Name) && password.getText().toString().equals(Password)) {
            Toast.makeText(getApplicationContext(), "Вход выполнен!" ,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, Malen.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
            number--;
            attempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setText(Integer.toString(number));
            if(number==0){
                btnActTwo.setEnabled(false);
                loginLocked.setVisibility(View.VISIBLE);
                loginLocked.setBackgroundColor(Color.RED);
                loginLocked.setText("Вход заблокирован!!!");
            }

        }
    }
}
