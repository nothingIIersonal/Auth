package com.example.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class auth extends AppCompatActivity {

    private Button authBtn;
    private EditText loginET, passwordET;
    public static final int REA_ACT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        authBtn = findViewById(R.id.authBTN);
        loginET = findViewById(R.id.loginET);
        passwordET = findViewById(R.id.passwordET);
        authBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), checkCred.class);
            intent.putExtra("login", loginET.getText().toString());
            intent.putExtra("password", passwordET.getText().toString());
            startActivityForResult(intent, REA_ACT_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REA_ACT_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null){
                    if (data.getBooleanExtra("flag", false)) {
                        Snackbar.make(findViewById(R.id.rootAUTH), "Success!", Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(findViewById(R.id.rootAUTH), "Fail!", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}