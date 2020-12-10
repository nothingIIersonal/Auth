package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class checkCred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            Intent intent = new Intent();
            intent.putExtra("flag", arguments.get("login").toString().equals("admin") && arguments.get("password").toString().equals("toor"));
            setResult(RESULT_OK, intent);
        }

        finish();
    }
}