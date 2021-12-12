package com.example.firstmyapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Authorization extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        findViewById(R.id.createNewAccount).setOnClickListener(v -> {
            startActivity(new Intent(this, Registration.class));
            finish();
        });
    }
}