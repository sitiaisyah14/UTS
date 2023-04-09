package com.example.dtschapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class WelcomeBack extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextPassword;

    CheckBox chkRememberUsername;
    CheckBox chkKeepLogin;
    private SharedPreferences sharedPrefs;
    private static final String USERNAME_KEY = "key_username";
    private static final String KEEP_LOGIN_KEY = "key_keep_login";

    private static final String DUMMY_USERNAME = "sitiaisyah4110@gmail.com";
    private static final String DUMMY_PASSWORD = "aisyah14";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);
        getSupportActionBar().hide();

        editTextEmail = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.edt_password);
        chkRememberUsername =findViewById(R.id.remember);
        chkKeepLogin = findViewById(R.id.keepLogin);

        // Inisialisasi SharedPreferences
        this.sharedPrefs = this.getSharedPreferences("dtsapp_sharedprefs", Context.MODE_PRIVATE);

        this.autoLogin();
        this.loadSavedUsername();

    }

    private void saveUsername()
    {
        // Menyimpan username bila diperlukan

        SharedPreferences.Editor editor = this.sharedPrefs.edit();

        if(this.chkRememberUsername.isChecked())
            editor.putString(USERNAME_KEY, this.editTextEmail.getText().toString());
        else
            editor.remove(USERNAME_KEY);
        editor.apply();
    }

    private void loadSavedUsername()
    {
        // Memeriksa apakah sebelumnya ada username yang tersimpan?
        // Jika ya, maka tampilkan username tersebut di EditText username.

        String savedUsername = this.sharedPrefs.getString(USERNAME_KEY, null);

        if(savedUsername != null)
        {
            this.editTextEmail.setText(savedUsername);

            this.chkRememberUsername.setChecked(true);
        }
    }

    private boolean validateCredential()
    {
        String currentUsername = this.editTextEmail.getText().toString();
        String currentPassword = this.editTextPassword.getText().toString();

        return (Objects.equals(currentUsername, DUMMY_USERNAME)
                && Objects.equals(currentPassword, DUMMY_PASSWORD));
    }

    private void makeAutoLogin()
    {
        // Mengatur agar selanjutnya pada saat aplikasi dibuka menjadi otomatis login
        SharedPreferences.Editor editor = this.sharedPrefs.edit();

        if(this.chkKeepLogin.isChecked())
            editor.putBoolean(KEEP_LOGIN_KEY, true);
        else
            editor.remove(KEEP_LOGIN_KEY);

        editor.apply();
    }

    private void autoLogin()
    {
        // Cek apakah sebelumnya aplikasi diatur agar bypass login?
        // Jika ya maka langsung buka activity berikutnya
    }

    public void clickForgot(View view) {
        Intent i = new Intent(WelcomeBack.this, ForgotPassword.class);
        startActivity(i);
    }

    public void postLogin(View view) {

        // Validasi input email kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim()) && TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(this, "Email dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        }
        // Validasi inputan email kosong
        else if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if(!isValidEmail(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(), "Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        else {
            boolean valid = this.validateCredential();

            if(valid)
            {
                Intent i = new Intent(WelcomeBack.this, Success.class);
                startActivity(i);

                this.saveUsername();
                this.makeAutoLogin();
            } else
            {
                Toast.makeText(this, "Invalid username and/or password!", Toast.LENGTH_LONG).show();
            }

        }
    }
    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    public void clickSignUp(View view){
        Intent i = new Intent(WelcomeBack.this, RegisterActivity.class);
        startActivity(i);
    }
}