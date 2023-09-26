package AktfitasDonasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.book_danation_app.FormulirDonasi;
import com.example.book_danation_app.R;



public class donasiDua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_dua);
    }

    public void keformulir(View view) { startActivity(new Intent(donasiDua.this, FormulirDonasi.class));
    }
}