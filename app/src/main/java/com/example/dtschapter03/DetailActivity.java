package com.example.dtschapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView foto;
    TextView nama, nomor, deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        foto = findViewById(R.id.iv_detail);
        nama = findViewById(R.id.nm_detail);
        nomor = findViewById(R.id.ct_detail);
        deskripsi = findViewById(R.id.dsk_detail);

        Intent i = getIntent();

        int fotoKontak = getIntent().getIntExtra("GAMBAR_DEFAULT", 0);
        String namaKontak = getIntent().getStringExtra("NAMA_DEFAULT");
        String nomorKontak = getIntent().getStringExtra("NOMOR_DEFAULT");
        String deskripsiKontak = getIntent().getStringExtra("DESKRIPSI_DEFAULT");


        foto.setImageResource(fotoKontak);
        nama.setText(namaKontak);
        nomor.setText(nomorKontak);
        deskripsi.setText(deskripsiKontak);


    }


}