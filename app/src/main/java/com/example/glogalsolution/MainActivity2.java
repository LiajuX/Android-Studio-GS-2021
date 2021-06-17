package com.example.glogalsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void voltar(View view) {
        Intent telaAnterior = new Intent(MainActivity2.this, MainActivity.class);

        startActivity(telaAnterior);
    }

    public String getPreference(String chave) {
        SharedPreferences sh = getSharedPreferences(getIntent().getStringExtra("PreferenceKey"), Context.MODE_PRIVATE);
        return sh.getString(chave, "");
    }

    public void recuperaPreferencias(View view) {
        TextView txtKgDeFarinha = findViewById(R.id.textValorDeKg);
        TextView txtLitrosDeAgua = findViewById(R.id.textValorEmLitros);

        txtKgDeFarinha.setText(getPreference("farinha") + "Kg");
        txtLitrosDeAgua.setText(getPreference("agua") + "L");
    }
}