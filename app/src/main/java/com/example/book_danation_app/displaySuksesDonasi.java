package com.example.book_danation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class displaySuksesDonasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sukses_donasi);
    }


    public void tolihatrincian(View view) {startActivity(new Intent(displaySuksesDonasi.this, TampilSemuaPgw.class));
    }
}