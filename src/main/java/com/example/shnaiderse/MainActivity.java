package com.example.shnaiderse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
private Button btnActOne;
private EditText Name;
private EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActOne=(Button) findViewById(R.id.likebutton);
        Name=(EditText) findViewById(R.id.EditLogin);
        Password=(EditText) findViewById(R.id.password);
    }
    public void goNewView(View v){
        switch (v.getId()){
            case R.id.likebutton:
                Intent I=new Intent(MainActivity.this, HomeActivity.class);
                I.putExtra("Name", Name.getText().toString());
                I.putExtra("Password", Password.getText().toString());
                startActivity(I);
                break;
            default:
                break;
        }
    }
}
