package com.example.tp3_oprateurs_tlphoniques;

import androidx.appcompat.app.AppCompatActivity;

import android.app.blob.BlobHandle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText txtLogin,txtPass;
     Button btnConnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtLogin =(EditText) findViewById(R.id.txtLogin);
         txtPass = (EditText) findViewById(R.id.txtPass);
         btnConnect = (Button) findViewById(R.id.btnConnect);

      btnConnect.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String Login = txtLogin.getText().toString();
              String pwd = txtPass.getText().toString();
              if(Login.equals("admin")&&pwd.equals("123456")){
                 Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                 startActivity(intent);

              }else {
                  Toast.makeText(MainActivity.this,"login ou mot de pass incorrect", Toast.LENGTH_SHORT).show();
              }
          }
      });

    }

}