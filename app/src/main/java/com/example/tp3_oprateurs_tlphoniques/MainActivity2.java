package com.example.tp3_oprateurs_tlphoniques;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

EditText txtnumtel,txtcodeR,txtRchrligne,txtconslsold;
TextView txtres;
Button btnAppeler,btnAppelersold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtnumtel = (EditText) findViewById(R.id.txtnumTel);
        txtcodeR = (EditText) findViewById(R.id.txtcodeR);
        txtRchrligne = (EditText) findViewById(R.id.txtRchrligne);
        txtconslsold = (EditText) findViewById(R.id.txtconslsold);
        txtres = (TextView) findViewById(R.id.txtres);

txtnumtel.addTextChangedListener(new TextWatcher() {

    String numTel = txtnumtel.getText().toString();

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0 && start == 0) {
            char firstchar = s.charAt(0);
            if (firstchar == '3' || firstchar == '5') {
                txtres.setText("votre ligne est Orange");
                txtres.setTextColor(Color.rgb(255, 165, 0));
                Handler handler = new Handler(Looper.getMainLooper());
                final Runnable[] runnable = {null};

                txtcodeR.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        String numTel = txtnumtel.getText().toString();
                        if (!(numTel.length() == 8 && numTel.matches("[0-9]+"))) {
                            new AlertDialog.Builder(MainActivity2.this).setTitle("error")
                                    .setMessage("Le numero de téléphone doit étre de 8 chiffre")
                                    .setPositiveButton("ok", null).show();
                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        handler.removeCallbacks(runnable[0]);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String code = txtcodeR.getText().toString();
                        runnable[0] = new Runnable() {
                            public void run() {
                                txtRchrligne.setText("*100*" + code + "#");
                                txtRchrligne.setBackgroundColor(Color.rgb(255, 165, 0));
                                txtconslsold.setText("*111#");
                                txtconslsold.setBackgroundColor(Color.rgb(255, 165, 0));

                            }
                        };
                        handler.postDelayed(runnable[0], 1000);



                    }
                });
            }else if (firstchar == '2') {
                txtres.setText("votre ligne est Ooredoo");
                txtres.setTextColor(Color.RED);
                Handler handler = new Handler(Looper.getMainLooper());
                final Runnable[] runnable = {null};
                txtcodeR.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        String numTel = txtnumtel.getText().toString();
                        if (!(numTel.length() == 8 && numTel.matches("[0-9]+"))) {
                            new AlertDialog.Builder(MainActivity2.this).setTitle("Error")
                                    .setMessage("Le numero de téléphone doit étre de 8 chiffre")
                                    .setPositiveButton("OK", null
                                    ).show();

                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        handler.removeCallbacks(runnable[0]);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String code = txtcodeR.getText().toString();
                        runnable[0] = new Runnable() {
                            @Override
                            public void run() {
                                txtRchrligne.setText("*101*" + code + "#");
                                txtRchrligne.setBackgroundColor(Color.RED);
                                txtconslsold.setText("*100#");
                                txtconslsold.setBackgroundColor(Color.RED);
                            }
                        };
                        handler.postDelayed(runnable[0], 1000);
                    }
                });
            } else if (firstchar == '9') {
                txtres.setText("votre ligne est Tunisie Telecome");
                txtres.setTextColor(Color.BLUE);
                Handler handler = new Handler(Looper.getMainLooper());
                final Runnable[] runnable = {null};

                txtcodeR.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        String numTel = txtnumtel.getText().toString();
                        if (!(numTel.length() == 8 && numTel.matches("[0-9]+"))) {
                            new AlertDialog.Builder(MainActivity2.this)
                                    .setTitle("Error")
                                    .setMessage("Le numero de téléphone doit étre de 8 chiffre")
                                    .setPositiveButton("OK", null)
                                    .show();
                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        handler.removeCallbacks(runnable[0]);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String code = txtcodeR.getText().toString();
                        runnable [0] = new Runnable() {
                            @Override
                            public void run() {
                                txtRchrligne.setText("*123*" + code + "#");
                                txtRchrligne.setBackgroundColor(Color.BLUE);
                                txtconslsold.setText("*122#");
                                txtconslsold.setBackgroundColor(Color.BLUE);

                            }
                        };
                        handler.postDelayed(runnable[0], 1000);
                    }
                });
            } else {
                txtres.setText("Votre ligne est telecome");
                txtres.setTextColor(Color.BLUE);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


});



        btnAppeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recharge = txtRchrligne.getText().toString();
                String code = txtcodeR.getText().toString();
                if(!(code.length() == 14 && code.matches("[0-9]+"))){
                    new AlertDialog.Builder(MainActivity2.this)
                            .setTitle("error").setMessage("Le code de recharge doit étre de 14 chiffre")
                            .setPositiveButton("ok",null).show();

                }else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + txt));
                    startActivity(intent);
                }

            }
        });
        btnAppelersold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Solde=txtconslsold.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Uri.encode(Solde)));
                startActivity(intent);

            }
        });






    }
}