package com.example.book_danation_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class login extends AppCompatActivity {


    EditText username, password;
    Button login;
    AlertDialog.Builder builder;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_login);
     initialize();
        }

        // YOU CAN DELETE THE COMMENT FOR LOGIN SYTEM WORK.

   //     login.setOnClickListener(new View.OnClickListener() {
     //       @Override
         //   public void onClick(View v) {
          //      if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
          //          builder = new AlertDialog.Builder(login.this);
           //         builder.setTitle("" +
            //                "Peringatan!");
              //      builder.setMessage("Harap masukan nama pengguna/kata sandi!");
            //        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
              //          @Override
               //         public void onClick(DialogInterface dialogInterface, int i) {
                 //           dialogInterface.dismiss();
                   //     }
                  //  });
                  //  AlertDialog alertDialog = builder.create();
                   // alertDialog.show();
              //  } else {
                //    proses_login backgroundTask = new proses_login(login.this);
                  //  backgroundTask.execute("Login", username.getText().toString(), password.getText().toString());

               // }


         //   }
     //   });
   // }

    private void initialize() {
        username = findViewById(R.id.usernameTxt);
        password = findViewById(R.id.katasandiTxt);
        login = findViewById(R.id.btnLogin);
    }

    public void tologin(View view) {
        startActivity(new Intent(login.this, beranda.class));
    }

    public void todaftar(View view) {
        startActivity(new Intent(login.this,register.class));
    }





}













