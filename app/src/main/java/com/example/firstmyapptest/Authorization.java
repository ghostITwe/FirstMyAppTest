package com.example.firstmyapptest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Authorization extends AppCompatActivity {

    private Button loginButton, registrationButton;
    private EditText loginText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        registrationButton = findViewById(R.id.RegistrationButton);
        loginButton = findViewById(R.id.LoginButton);
        loginText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);


        registrationButton.setOnClickListener(v -> {
            startActivity(new Intent(this, Registration.class));
            finish();
        });

        loginButton.setOnClickListener(v -> {
            try {
                SignIn(loginText.getText().toString(), passwordText.getText().toString());
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public void SignIn(String login, String password) throws IOException, JSONException {
        if (!login.trim().equals("") && !password.trim().equals("")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();

        } else {
            Toast.makeText(this, "Логин и пароль не могут быть пустыми.", Toast.LENGTH_SHORT).show();
        }
    }
}