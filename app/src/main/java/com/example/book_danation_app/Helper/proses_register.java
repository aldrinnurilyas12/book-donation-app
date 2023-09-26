package com.example.book_danation_app.Helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.book_danation_app.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class proses_register extends AsyncTask<String,Void, String> {

    //Link
    private String url_proses_login = "http://192.168.43.184/UAS_ALDRIN/register.php"; // link proses login di php

    Context context;
    ProgressDialog progressDialog;
    Activity activity;
    AlertDialog.Builder builder;

    public proses_register(Context context) {
        this.context = context;
        activity = (Activity) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        builder = new AlertDialog.Builder(activity);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Menyimpan Data..");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        if (method.equals("Register")){
            try {
                URL url = new URL(url_proses_login);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String nama,alamat,username, password;
                nama = params[1];
                alamat = params[2];
                username = params[3];
                password = params[4];

                String data_register = URLEncoder.encode("nama_lengkap","UTF-8") + "=" + URLEncoder.encode(nama,"UTF-8") + "&" +
                        URLEncoder.encode("alamat","UTF-8") + "=" + URLEncoder.encode(alamat,"UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(data_register);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }

                connection.disconnect();
                Thread.sleep(3000);
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {

            Toast.makeText(context, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, login.class);
            context.startActivity(intent);
//            JSONObject jsonObject = new JSONObject(s);
//            JSONArray jsonArray = jsonObject.getJSONArray("Server");
//            JSONObject JO = jsonArray.getJSONObject(0);
//            String code = JO.getString("code");
//            String message = JO.getString("message");
//            //Script jika berhasil DAFTAR
//            if (code.equals("regist_true")){
//                Intent intent = new Intent(context, login.class);
//                context.startActivity(intent);
//            }
//            //script jika gagal DAFTAR
//            else if (code.equals("login_false")){
//                builder.setMessage(message);
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        progressDialog.dismiss();
//                    }
//                });
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
            }catch (Exception e) {
            e.printStackTrace();
        }
        }

    }

