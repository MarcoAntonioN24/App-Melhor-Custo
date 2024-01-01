package com.example.melhorcusto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class saibaMais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiba_mais);
        Button voltsb = findViewById(R.id.btnVSB);

        voltsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvoltsb = new Intent(saibaMais.this,MainActivity.class);
                startActivity(intentvoltsb);
            }
        });
    }
}