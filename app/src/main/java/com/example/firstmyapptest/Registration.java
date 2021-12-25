package com.example.firstmyapptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Registration extends AppCompatActivity {

    private Button loginButton, registrationButton;
    private EditText loginText, emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        loginButton = findViewById(R.id.LoginButton);
        registrationButton = findViewById(R.id.RegistrationButton);

        loginText = findViewById(R.id.name);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);

        loginButton.setOnClickListener(v -> {
            startActivity(new Intent(this, Authorization.class));
            finish();
        });

        registrationButton.setOnClickListener(v -> {
//            registration(loginText.getText().toString(), emailText.getText().toString(), passwordText.getText().toString());
            cars();
        });


    }

    public void registration(String login, String email, String password) {
        OkHttpClient client = new OkHttpClient();

        //Тело запроса для POST запросов
        FormBody formBody = new FormBody.Builder()
                .add("username", login)
                .add("email", email)
                .add("password", password).build();

        //Если это GET запрос, то удаляем .post
        Request request = new Request.Builder()
//                .post(formBody)
                .url(" http://cars.areas.su/cars").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.code() == 200) {

                    startActivity(new Intent(getApplicationContext(), Authorization.class));
                    finish();
                }
            }
        });
    }

    public void cars() {
        OkHttpClient client = new OkHttpClient();

        //Если это GET запрос, то удаляем .post
        Request request = new Request.Builder()
//                .post(formBody)
                .url(" http://cars.areas.su/cars").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.code() == 200) {
                    System.out.println(response.body().toString());
                    try {
                        JSONArray jsonArray = new JSONArray(response.body().toString());
                        System.out.println(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                    startActivity(new Intent(getApplicationContext(), Authorization.class));
//                    finish();
                }
            }
        });
    }
}