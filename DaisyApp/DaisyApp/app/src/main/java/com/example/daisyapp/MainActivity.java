package com.example.daisyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daisyapp.ApiService;
import com.example.daisyapp.Models.LoginRequest;
import com.example.daisyapp.Models.User;
import com.example.daisyapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextInputEditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnCallApi);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtEmail.getText() == null || txtPassword.getText() == null) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin đăng nhập", Toast.LENGTH_LONG).show();
                } else {
                    LoginRequest request = new LoginRequest(txtEmail.getText().toString(), txtPassword.getText().toString());
                    Login(request);
                }
            }
        });

    }

    //"Đăng nhập thất bại vui lòng kiểm tra lại tài khoản"
    private void Login(LoginRequest request) {
        try {
            ApiService.apiService.Login(request).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User result = response.body();
                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }
}


