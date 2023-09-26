package com.example.book_danation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.book_danation_app.Helper.proses_register;

public class register extends AppCompatActivity {

    EditText et_nama,et_username,et_pass,et_alamat;
    Button btnRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialize();

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validate();
                proses_register backgroundTask = new proses_register(register.this);
                backgroundTask.execute("Register", et_username.getText().toString(), et_alamat.getText().toString(), et_username.getText().toString(),et_pass.getText().toString());
            }
        });

    }

    private void Validate() {
        if (et_nama.equals("")) {
            Toast.makeText(getApplicationContext(), "Masukkan Nama Anda", Toast.LENGTH_SHORT).show();
        } else if (et_alamat.equals("")) {
            Toast.makeText(getApplicationContext(), "Masukkan Alamat Anda", Toast.LENGTH_SHORT).show();
        } else if (et_username.equals("")) {
            Toast.makeText(getApplicationContext(), "Masukkan Username Anda", Toast.LENGTH_SHORT).show();
        } else if (et_pass.equals("")) {
            Toast.makeText(getApplicationContext(), "Masukkan password Anda", Toast.LENGTH_SHORT).show();
        }
    }

            private void initialize() {
        et_nama = findViewById(R.id.namelengkapTxt);
        et_alamat = findViewById(R.id.alamatTxt);
        et_username = findViewById(R.id.namapenggunaTxt);
        et_pass = findViewById(R.id.katasandiTxt);
        btnRegis = findViewById(R.id.btnLogin);
    }


    public void masuk(View view) {
        finish();
    }
}

