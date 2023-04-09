package com.example.dtschapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dtschapter03.models.Register;

public class RegisterResultActivity extends AppCompatActivity {
    //inisialisasi variabel
    TextView tvResultNama, tvResultTanggallahir, tvResultjenisKelamin, tvResultUsername;

    // Intent key
    public static final String Key_RegisterActivity = "Key_RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);
        getSupportActionBar().hide();

        tvResultNama = findViewById(R.id.tvResultNama);
        tvResultTanggallahir = findViewById(R.id.tvResultTanggalLahir);
        tvResultjenisKelamin = findViewById(R.id.tvResultJenisKelamin);
        tvResultUsername = findViewById(R.id.tvResultUsername);

        //get string array berdasarkan key
//        String[] stringArray = getIntent().getStringArrayExtra (RegisterActivity.Key_RegisterActivity);

        Register register = getIntent().getParcelableExtra(Key_RegisterActivity);

        // set value to textview
//        tvResultNama.setText(stringArray [0]);
//        tvResultTanggallahir.setText(stringArray[1]);
//        tvResultjenisKelamin.setText(stringArray[2]);
//        tvResultUsername.setText(stringArray[3]);

        // Set value to TextView based on Parcel Object
        tvResultNama.setText(register.getNama());
        tvResultTanggallahir.setText(register.getTanggalLahir());
        tvResultjenisKelamin.setText(register.getJenisKelamin());
        tvResultUsername.setText(register.getUsername());
    }
}