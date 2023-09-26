package com.example.book_danation_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import AktfitasDonasi.donasiDua;
import AktfitasDonasi.donasiSatu;

public class beranda extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[],s4[], s5[];
    int images[] = {R.drawable.gambarpanti, R.drawable.donasibdg, R.drawable.gambarr};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        recyclerView = findViewById(R.id.recyclerView1);

        s1 = getResources().getStringArray(R.array.project_recycle);
        s2 = getResources().getStringArray(R.array.deskripsi);
        s3 = getResources().getStringArray(R.array.description);
        s4 = getResources().getStringArray(R.array.penyelenggara);
        s5 = getResources().getStringArray(R.array.lokasi);

       MyAdapter myAdapter = new MyAdapter(this, s1, s2,s3,s4, s5, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }




    public void onBackPressed(){
        AlertDialog.Builder tombolkeluar = new AlertDialog.Builder(beranda.this);
        tombolkeluar.setMessage("Keluar aplikasi donbuk?");
        tombolkeluar.setTitle("Keluar Aplikasi");
        final AlertDialog.Builder builder = tombolkeluar.setIcon(R.drawable.ic_baseline_warning_amber_24);
        tombolkeluar.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                beranda.this.finish();
            }
        });

        tombolkeluar.setNeutralButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        tombolkeluar.show();
    }


    public void about(View view) {
        startActivity(new Intent(beranda.this, about.class));
    }

    public void donasisatu(View view) {
        startActivity(new Intent(beranda.this, donasiSatu.class));
    }

    public void donasidua(View view) { startActivity(new Intent(beranda.this, donasiDua.class));
    }


    public void tolihatrincian(View view) { startActivity(new Intent(beranda.this,TampilSemuaPgw.class));
    }
}