package com.example.firstmyapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authorization extends AppCompatActivity {

    private Button signInButton;
    private TextView createNewAccount;
    private EditText loginText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        createNewAccount = findViewById(R.id.createNewAccount);
        signInButton = findViewById(R.id.sign_in);
        loginText = findViewById(R.id.login);
        passwordText = findViewById(R.id.password);


        createNewAccount.setOnClickListener(v -> {
            startActivity(new Intent(this, Registration.class));
            finish();
        });

        signInButton.setOnClickListener(v -> {
            SignIn(loginText.getText().toString(), passwordText.getText().toString());
        });
    }

    public void SignIn(String login, String password) {
        if (!login.equals("") && !password.equals("")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Логин и пароль не могут быть пустыми.", Toast.LENGTH_SHORT).show();
        }
    }
}