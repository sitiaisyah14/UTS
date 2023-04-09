package com.example.dtschapter03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dtschapter03.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class Success extends AppCompatActivity implements com.example.recyclerview.adapter.ContactAdapter.OnContactClickListener{
    public RecyclerView rv;
    public com.example.recyclerview.adapter.ContactAdapter contactAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Contact> listContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        getSupportActionBar().hide();

        rv = findViewById(R.id.rvContact);

        listContact.add(new Contact("Iron Man",
                "102018308",
                R.drawable.ironman));

        listContact.add(new Contact("Bat Man",
                "102018309",
                R.drawable.batman));

        listContact.add(new Contact("Groot",
                "102018307",
                R.drawable.groot));

        listContact.add(new Contact("Sonic",
                "102018301", R.drawable.sonic));


        contactAdapter = new com.example.recyclerview.adapter.ContactAdapter(listContact);
        contactAdapter.setListener(this::onClick);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapter);
        rv.setLayoutManager(layoutManager);
    }
    @Override
    public void onClick(View view, int position) {
        Contact contact = listContact.get(position);
        // Toast.makeText(this, contact.getName(), Toast.LENGTH_LONG).show();

        if (listContact.get(position).getName().equals("Iron Man")){
            Intent i = new Intent(Success.this, DetailActivity.class) ;
            i.putExtra("GAMBAR_DEFAULT", R.drawable.ironman);
            i.putExtra("NAMA_DEFAULT", "Iron Man");
            i.putExtra("NOMOR_DEFAULT", "102018308");
            i.putExtra("DESKRIPSI_DEFAULT", "Iron Man (Anthony Edward \"Tony\" Stark) adalah pahlawan super fiksi yang muncul dalam buku komik Amerika yang diterbitkan oleh Marvel Comics, serta media yang terkait. Karakter diciptakan oleh penulis dan editor Stan Lee, yang dikembangkan oleh penulis skenario Larry Lieber, dan dirancang oleh seniman Don Heck dan Jack Kirby. Dia membuat penampilan pertamanya di Tales of Suspense #39 (cover tertanggal bulan Maret 1963).");
            startActivity(i);
        }
        if (listContact.get(position).getName().equals("Bat Man")){
            Intent i = new Intent(Success.this, DetailActivity.class) ;
            i.putExtra("GAMBAR_DEFAULT", R.drawable.batman);
            i.putExtra("NAMA_DEFAULT", "Bat Man");
            i.putExtra("NOMOR_DEFAULT", "102018309");
            i.putExtra("DESKRIPSI_DEFAULT", "Batman adalah tokoh fiksi pahlawan super yang diciptakan oleh seniman Bob Kane dan penulis Bill Finger dan diterbitkan oleh DC Comics. Tokoh ini pertama muncul di Detective Comics #27 (Mei 1939). Identitas asli Batman adalah Bruce Wayne, seorang pengusaha yang kaya raya. Nama Bruce Wayne itu sendiri diambil dari nama tokoh sejarah, yaitu Robert the Bruce dan Anthony Wayne.");
            startActivity(i);
        }
        if (listContact.get(position).getName().equals("Groot")){
            Intent i = new Intent(Success.this, DetailActivity.class) ;
            i.putExtra("GAMBAR_DEFAULT", R.drawable.groot);
            i.putExtra("NAMA_DEFAULT", "Groot");
            i.putExtra("NOMOR_DEFAULT", "102018307");
            i.putExtra("DESKRIPSI_DEFAULT", "Secara identitas makhluk, Groot ini merupakan makhluk luar angkasa dengan bentuk seperti pohon. Marvel menyebut makhluk ini punya kekuatan menyembuhkan diri sendiri, dan kekuatan superhuman.");
            startActivity(i);
        }
        if (listContact.get(position).getName().equals("Sonic")){
            Intent i = new Intent(Success.this, DetailActivity.class) ;
            i.putExtra("GAMBAR_DEFAULT", R.drawable.sonic);
            i.putExtra("NAMA_DEFAULT", "Sonic");
            i.putExtra("NOMOR_DEFAULT", "102018301");
            i.putExtra("DESKRIPSI_DEFAULT", "Sonic the Hedgehog (Bahasa Indonesia: Sonic si Landak) adalah karakter utama dari serial permainan video Sonic the Hedgehog milik Sega. Dia adalah maskot perusahaan permainan video Sega Corporation sejak 1991.");
            startActivity(i);
        }
    }
}