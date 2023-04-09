package com.example.dtschapter03;

import static com.example.dtschapter03.WelcomeBack.isValidEmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
EditText editUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();
        editUsername = findViewById(R.id.edtUsername);
    }
    public void postSendRequest(View view) {
        //Validasi input email kosong
        if(TextUtils.isEmpty(editUsername.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        //Validasi inputan type email
        else if(!isValidEmail(editUsername.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(ForgotPassword.this, ResetPassword.class);
            startActivity(i);

        }
    }


}