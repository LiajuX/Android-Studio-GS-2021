package com.example.glogalsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public final String PreferenceKey = "PREF";

    int Kg = 0;
    int L = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Código dos botões de incremento e decremento
        ImageButton KgDec = findViewById(R.id.decrementButtonKg);
        ImageButton KgInc = findViewById(R.id.incrementButtonKg);
        EditText inputKg = findViewById(R.id.inputKg);

        ImageButton LDec = findViewById(R.id.decrementButtonL);
        ImageButton LInc = findViewById(R.id.incrementButtonL);
        EditText inputL = findViewById(R.id.inputL);

        KgDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Kg > 0) {
                    Kg--;
                }
                inputKg.setText(String.valueOf(Kg));
            }
        });

        KgInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Kg < 999999) {
                    Kg++;
                }
                inputKg.setText(String.valueOf(Kg));
            }
        });

        LDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (L > 0) {
                    L--;
                }
                inputL.setText(String.valueOf(L));
            }
        });

        LInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (L < 999999) {
                    L++;
                }
                inputL.setText(String.valueOf(L));
            }
        });
    }

    public void addPreference(String chave, String valor) {
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();

        ed.putString(chave, valor).apply();
    }

    public void gravaPreferencias(View view) {
        Intent proximaTela = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtKgDeFarinha = findViewById(R.id.inputKg);
        EditText txtLitrosDeAgua = findViewById(R.id.inputL);

        addPreference("farinha", txtKgDeFarinha.getText().toString());
        addPreference("agua", txtLitrosDeAgua.getText().toString());

        proximaTela.putExtra("PreferenceKey", PreferenceKey);

        startActivity(proximaTela);
    }
}