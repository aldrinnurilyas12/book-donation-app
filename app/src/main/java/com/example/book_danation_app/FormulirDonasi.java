package com.example.book_danation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.book_danation_app.R;

import java.util.HashMap;

public class FormulirDonasi extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextNama;
    private EditText editTextAlamat;
    private EditText editTextTelepon;
    private EditText editTextTujuan;
    private EditText editTextIsbn;
    private EditText editTextJudul;

    RadioGroup radioGroupKategori;
    RadioButton kategoribuku;




    private Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RadioButton radioButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir);

        editTextNama = (EditText)  findViewById(R.id.editTextNama);
        editTextAlamat =(EditText) findViewById(R.id.editTextAlamat);
        editTextTelepon = (EditText)  findViewById(R.id.editTextTelepon);
        editTextTujuan = (EditText) findViewById(R.id.editTextTujuan);
        editTextJudul =(EditText) findViewById(R.id.editTextJudul);
        editTextIsbn =(EditText) findViewById(R.id.editTextIsbn);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);

    }



    private void addPengguna() {
        final String nama_lengkap = editTextNama.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String telepon = editTextTelepon.getText().toString().trim();
        final String tujuan_donasi = editTextTujuan.getText().toString().trim();
        final String judul = editTextJudul.getText().toString().trim();
        final String isbn = editTextIsbn.getText().toString().trim();


        radioGroupKategori = (RadioGroup)findViewById(R.id.radioGroupKategori);

        int kategoribuku=radioGroupKategori.getCheckedRadioButtonId();
        RadioButton radioButton =(RadioButton)findViewById(kategoribuku);
        String kategori=radioButton.getText().toString();



        class AddPengguna extends AsyncTask<Void,Void,String>{


            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(FormulirDonasi.this,"Mendonasikan Buku Anda", "Tunggu sebentar", false,false);
            }

            @Override
            protected void onPostExecute(String s) {

                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(FormulirDonasi.this, s, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormulirDonasi.this, displaySuksesDonasi.class);
                startActivity(intent);


            }



            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_PENGGUNA_NAMA,nama_lengkap);
                params.put(Konfigurasi.KEY_PENGGUNA_ALAMAT,alamat);
                params.put(Konfigurasi.KEY_PENGGUNA_TELEPON,telepon);
                params.put(Konfigurasi.KEY_PENGGUNA_TUJUAN,tujuan_donasi);
                params.put(Konfigurasi.KEY_PENGGUNA_JUDUL,judul);
                params.put(Konfigurasi.KEY_PENGGUNA_ISBN,isbn);
                params.put(Konfigurasi.KEY_PENGGUNA_KATEGORI,kategori);



                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }
        AddPengguna ap = new AddPengguna();
        ap.execute();
    }



    @Override
    public void onClick(View v){
        if(v==buttonAdd){
            addPengguna();
        }

    }


    public void ketentuan(View view) {
        startActivity(new Intent(FormulirDonasi.this, about.class));
    }
}