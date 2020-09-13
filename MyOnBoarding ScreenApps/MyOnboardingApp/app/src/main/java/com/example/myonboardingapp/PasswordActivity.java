package com.example.myonboardingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }

    public void openApp(View view) {
        Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, R.anim.activity_close);
    }
}
