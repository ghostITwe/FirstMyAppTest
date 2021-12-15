package com.example.firstmyapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Registration extends AppCompatActivity {

    private Button loginButton, registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        loginButton = findViewById(R.id.LoginButton);
        registrationButton = findViewById(R.id.RegistrationButton);

        loginButton.setOnClickListener(v -> {
            startActivity(new Intent(this, Authorization.class));
            finish();
        });

        registrationButton.setOnClickListener(v -> {
            registration();
        });


    }

    public void registration() {
        startActivity(new Intent(this, Authorization.class));
        finish();
    }
}