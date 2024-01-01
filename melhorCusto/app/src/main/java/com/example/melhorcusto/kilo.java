package com.example.melhorcusto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class kilo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilo);

        Button voltar1 = findViewById(R.id.btnVoltar);
        Button limp1 = findViewById(R.id.btnLimp);
        Button calc1 = findViewById(R.id.btnCalc);
        EditText quantKG = findViewById(R.id.txnQuant);
        EditText precoKG = findViewById(R.id.txnPreco);
        TextView resultKG = findViewById(R.id.txtResult);
        RadioGroup groupKG = findViewById(R.id.rg1);
        RadioButton radioBG = findViewById(R.id.rbg);
        RadioButton radioBK = findViewById(R.id.rbk);

        EditText quantKGN = findViewById(R.id.txnqpd2);
        EditText precoKGN = findViewById(R.id.txnppd2);
        TextView resultKGPD = findViewById(R.id.txtResultpd);
        TextView resultKGPD2 = findViewById(R.id.txtResultpd2);
        RadioGroup groupKGN = findViewById(R.id.rgn);
        RadioButton radioBGN = findViewById(R.id.rbgn);
        RadioButton radioBKN = findViewById(R.id.rbkn);




        //BOTÃO PARA VOLTAR P TELA INICIAL!!
        voltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvoltar1 = new Intent(kilo.this,MainActivity.class);
                startActivity(intentvoltar1);
            }
        });

        //BOTÃO PARA LIMPAR OS CAMPOS!!
        limp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            quantKG.setText("");
            precoKG.setText("");
            resultKG.setText("");
            radioBG.setChecked(true);
            radioBK.setChecked(false);
            quantKGN.setText("");
            precoKGN.setText("");
            resultKGPD.setText("");
            resultKGPD2.setText("");
            radioBGN.setChecked(true);
            radioBKN.setChecked(false);
            quantKG.requestFocus();


            }
        });

        //BOTÃO PARA REALIZAR A COMPARAÇÃO ENTRE OS PRODUTOS!!
        calc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double precoprod1KG,precoprod2KG;
                //VALIDAÇÃO DOS CAMPOS !!
                if ((quantKG.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PESO DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    quantKG.requestFocus();
                }
                else if ((precoKG.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PREÇO DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    precoKG.requestFocus();
                }
                else if ((quantKGN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PESO DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    quantKGN.requestFocus();
                }
                else if ((precoKGN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PREÇO DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    precoKGN.requestFocus();
                }

                else {
                    //VALIDA QUE O USUÁRIO NÃO INSIRA VALOR IGUAL A ZERO !!
                    double q = Double.parseDouble(quantKG.getText().toString());
                    double p = Double.parseDouble(precoKG.getText().toString());
                    double q2 = Double.parseDouble(quantKGN.getText().toString());
                    double p2 = Double.parseDouble(precoKGN.getText().toString());
                    if (q < 1) {
                        Toast.makeText(getApplicationContext(), "PESO DO PRODUTO 1 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        quantKG.requestFocus();

                    } else if (p < 1) {
                        Toast.makeText(getApplicationContext(), "PREÇO DO PRODUTO 1 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        precoKG.requestFocus();
                    }
                    else if (q2 < 1) {
                        Toast.makeText(getApplicationContext(), "PESO DO PRODUTO 2 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        quantKGN.requestFocus();

                    } else if (p2 < 1) {
                        Toast.makeText(getApplicationContext(), "PREÇO DO PRODUTO 2 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        precoKGN.requestFocus();
                    }
                    else{
                        if(radioBG.isChecked()){
                             precoprod1KG = (p*1000) /q;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultKGPD.setText("KILO DO PRODUTO 1 CUSTA R$ " + df.format(precoprod1KG));

                        }else{
                            double convKG = q*1000;
                            precoprod1KG = (p * 1000)/convKG;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultKGPD.setText("KILO DO PRODUTO 1 CUSTA R$ " + df.format(precoprod1KG));
                        }
                        if(radioBGN.isChecked()){
                             precoprod2KG = (p2*1000) /q2;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultKGPD2.setText("KILO DO PRODUTO 2 CUSTA R$ " + df.format(precoprod2KG));

                        }else{
                            double convKG = q2*1000;
                             precoprod2KG = (p2 * 1000)/convKG;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultKGPD2.setText("KILO DO PRODUTO 2 CUSTA R$ " + df.format(precoprod2KG));


                        }
                        if(precoprod1KG < precoprod2KG){
                            resultKG.setText("PRODUTO 1 É O MAIS ECONÔMICO");
                        }
                        else if(precoprod1KG == precoprod2KG){
                            resultKG.setText("PRODUTOS POSSUEM PREÇO IGUAL !!");
                        }
                        else{
                            resultKG.setText("PRODUTO 2 É O MAIS ECONÔMICO");
                        }
                    }
                }
            }
        });
    }
}