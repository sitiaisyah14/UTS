package com.example.dtschapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {
EditText resetCode,edtPassword,edtConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        getSupportActionBar().hide();
        resetCode = findViewById(R.id.edt_reset_code);
        edtPassword = findViewById(R.id.edt_new_password);
        edtConfirmPassword = findViewById(R.id.edt_confirm_password);
    }
    public void postChangePassword(View view) {
        //Validasi resetCode, EditPassword, Confirm Password Kosong
        if (TextUtils.isEmpty(resetCode.getText().toString().trim()) && TextUtils.isEmpty(edtPassword.getText().toString().trim()) && TextUtils.isEmpty(edtConfirmPassword.getText().toString().trim())) {
            Toast.makeText(this, "Reset Code, Password dan Konfirmasi Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        }
        //Validasi resetCode Kosong
        else if(TextUtils.isEmpty(resetCode.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Reset Code tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi Edit Password Kosong
        else if(TextUtils.isEmpty(edtPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Baru tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi Confirm Password Kosong
        else if(TextUtils.isEmpty(edtConfirmPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Konfirmasi Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi input new password dan Confirm Password lebih 15 karakter
        else if (edtPassword.getText().toString().length() > 15 ) {
            Toast.makeText(view.getContext(), "New Password tidak boleh lebih dari 15 karakter!", Toast.LENGTH_LONG).show();
        }
        else if (edtConfirmPassword.getText().toString().length() > 15 ) {
            Toast.makeText(view.getContext(), "Confirm Password tidak boleh lebih dari 15 karakter!", Toast.LENGTH_LONG).show();
        }
        //validasi confirm password harus sama dengan new password
        else if ((!edtConfirmPassword.getText().toString().equals(edtPassword))){
            Toast.makeText(view.getContext(), "Confirm Password tidak sesuai dengan new password!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(ResetPassword.this, Success.class);
            startActivity(i);
        }
    }

}