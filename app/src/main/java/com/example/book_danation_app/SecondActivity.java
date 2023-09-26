package com.example.book_danation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class SecondActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView textjudul,myText3,myText4, myText5;

    String data1, data3,data4, data5;
    int myImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        textjudul = findViewById(R.id.textjudul);
        myText3 = findViewById(R.id.myText3);
        myText4 = findViewById(R.id.myText4);
        myText5 = findViewById(R.id.myText5);


        getData();
        setData();

    }

    private void getData (){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
        getIntent().hasExtra("data3")){

            data1 = getIntent().getStringExtra("data1");
            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");
            data5 = getIntent().getStringExtra("data5");
            myImages = getIntent().getIntExtra("myImage", 1);
        }else {
            Toast.makeText(this, "data belom masuk .", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        textjudul.setText(data1);
       myText3.setText(data3);
       myText4.setText(data4);
       myText5.setText(data5);
        mainImageView.setImageResource(myImages);
    }




    public void gotoformulir(View view) {
        startActivity(new Intent(SecondActivity.this, FormulirDonasi.class));
    }
}