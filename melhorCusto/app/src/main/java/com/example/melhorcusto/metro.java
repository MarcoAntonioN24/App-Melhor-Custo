package com.example.melhorcusto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class metro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro);

        Button voltar3 = findViewById(R.id.btnVoltar);
        Button limp3 = findViewById(R.id.btnLimp);
        Button calc3 = findViewById(R.id.btnCalc);
        EditText quantRM = findViewById(R.id.txnQuant3);
        EditText metRM = findViewById(R.id.txnMt3);
        EditText precoRM = findViewById(R.id.txnPreco3);
        TextView resultRM = findViewById(R.id.txtResult3);
        EditText quantRMN = findViewById(R.id.txnqpd5);
        EditText metRMN = findViewById(R.id.txnMt4);
        EditText precoRMN = findViewById(R.id.txnppd5);
        TextView resultRM5 = findViewById(R.id.txtResultpd5);
        TextView resultRM6 = findViewById(R.id.txtResultpd6);


        voltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvoltar3 = new Intent(metro.this,MainActivity.class);
                startActivity(intentvoltar3);
            }
        });

        limp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantRM.setText("");
                metRM.setText("");
                precoRM.setText("");
                resultRM.setText("");
                quantRMN.setText("");
                metRMN.setText("");
                precoRMN.setText("");
                resultRM5.setText("");
                resultRM6.setText("");

            }
        });

        calc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VALIDAÇÃO DOS CAMPOS !!
                if ((quantRM.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA A QUANTIDADE DE ROLOS DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    quantRM.requestFocus();
                }
                else if ((metRM.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA A METRAGEM DE CADA ROLO DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    metRM.requestFocus();
                }
                else if ((precoRM.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PREÇO POR PACOTE DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    precoRM.requestFocus();
                }
                else if ((quantRMN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA A QUANTIDADE DE ROLOS DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    quantRMN.requestFocus();
                }
                else if ((metRMN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA A METRAGEM DE CADA ROLO DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    metRMN.requestFocus();
                }
                else if ((precoRMN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PREÇO POR PACOTE DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    precoRMN.requestFocus();
                }
                //VALIDA QUE O USUÁRIO NÃO INSIRA VALOR IGUAL A ZERO !!
                else{
                    double q= Double.parseDouble(quantRM.getText().toString());
                    double m = Double.parseDouble(metRM.getText().toString());
                    double p = Double.parseDouble(precoRM.getText().toString());
                    double q2= Double.parseDouble(quantRMN.getText().toString());
                    double m2 = Double.parseDouble(metRMN.getText().toString());
                    double p2 = Double.parseDouble(precoRMN.getText().toString());

                    if( q <1) {
                        Toast.makeText(getApplicationContext(), "QUANTIDADE DE ROLOS DO PRODUTO 1 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        quantRM.requestFocus();

                    }else if( m <1) {
                        Toast.makeText(getApplicationContext(), "METRAGEM DE CADA ROLO DO PRODUTO 1 NÃO PODE SER ZERO", Toast.LENGTH_SHORT).show();
                        metRM.requestFocus();

                    }else if(p <1){
                        Toast.makeText(getApplicationContext(),"PREÇO DO PRODUTO 1 NÃO PODE SER IGUAL A ZERO",Toast.LENGTH_SHORT).show();
                        precoRM.requestFocus();
                    }
                    else if( q2 <1) {
                        Toast.makeText(getApplicationContext(), "QUANTIDADE DE ROLOS DO PRODUTO 2 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        quantRMN.requestFocus();
                    }
                    else if( m2 <1) {
                        Toast.makeText(getApplicationContext(), "METRAGEM DE CADA ROLO DO PRODUTO 2 NÃO PODE SER ZERO", Toast.LENGTH_SHORT).show();
                        metRMN.requestFocus();
                    }
                    else if(p2 <1){
                        Toast.makeText(getApplicationContext(),"PREÇO DO PRODUTO 2 NÃO PODE SER IGUAL A ZERO",Toast.LENGTH_SHORT).show();
                        precoRMN.requestFocus();
                    }
                    else{
                        double mtRM = q*m;
                        double precofinalRM = p/mtRM;
                        DecimalFormat df = new DecimalFormat("#.##");
                        resultRM5.setText("CADA METRO DO ROLO DO PRODUTO 1 R$ " + df.format(precofinalRM));

                        double mtRM2 = q2*m2;
                        double precofinalRM2 = p2/mtRM2;
                        DecimalFormat df2 = new DecimalFormat("#.##");
                        resultRM6.setText("CADA METRO DO ROLO DO PRODUTO 2 R$ " + df2.format(precofinalRM2));

                        if(precofinalRM < precofinalRM2){
                           resultRM.setText("PRODUTO 1 É O MAIS ECONÔMICO");
                        }
                        else if(precofinalRM == precofinalRM2){
                            resultRM.setText("PRODUTOS POSSUEM O MESMO PREÇO");
                        }
                        else{
                            resultRM.setText("PRODUTO 2 É O MAIS ECONÔMICO");
                        }
                    }
                }
            }
        });
    }
}