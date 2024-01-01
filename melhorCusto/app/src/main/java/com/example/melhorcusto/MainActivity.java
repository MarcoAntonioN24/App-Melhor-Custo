package com.example.melhorcusto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kilo = findViewById(R.id.k);
        Button litro = findViewById(R.id.li);
        Button metro = findViewById(R.id.m);
        Button saibamais = findViewById(R.id.sm);


        kilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentkilo = new Intent(MainActivity.this,kilo.class);
                startActivity(intentkilo);
            }
        });

        litro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlitro = new Intent(MainActivity.this,litro.class);
                startActivity(intentlitro);
            }
        });

        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentmetro = new Intent(MainActivity.this,metro.class);
                startActivity(intentmetro);
            }
        });

      saibamais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsaibamais = new Intent(MainActivity.this,saibaMais.class);
                startActivity(intentsaibamais);
            }
        });




    }
}