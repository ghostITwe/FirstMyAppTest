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
            try {
                SignIn(loginText.getText().toString(), passwordText.getText().toString());
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public void SignIn(String login, String password) throws IOException, JSONException {
        if (!login.trim().equals("") && !password.trim().equals("")) {
//            JSONObject data = new JSONObject();
//            data.put("email", login);
//            data.put("password", password);
//
//            URL urlApi = new URL("https://reqres.in/api/login");
//            HttpURLConnection connection = (HttpURLConnection) urlApi.openConnection();
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//            connection.connect();
//
//            OutputStream os = connection.getOutputStream();
//            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
//
//            osw.write(data.toString());
//            osw.flush();
//            osw.close();
            startActivity(new Intent(this, MainActivity.class));
            finish();

        } else {
            Toast.makeText(this, "Логин и пароль не могут быть пустыми.", Toast.LENGTH_SHORT).show();
        }
    }
}