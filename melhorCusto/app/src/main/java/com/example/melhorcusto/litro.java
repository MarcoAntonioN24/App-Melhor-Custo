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

public class litro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litro);

        Button voltar2 = findViewById(R.id.btnVoltar);
        Button limp2 = findViewById(R.id.btnLimp);
        Button calc2 = findViewById(R.id.btnCalc);
        EditText quantML = findViewById(R.id.txnQuant2);
        EditText precoML = findViewById(R.id.txnPreco2);
        TextView resultML = findViewById(R.id.txtResult2);
        RadioGroup groupML = findViewById(R.id.rg2);
        RadioButton radioBM = findViewById(R.id.rbm);
        RadioButton radioBL = findViewById(R.id.rbl);

        EditText quantMLN = findViewById(R.id.txnqpd3);
        EditText precoMLN = findViewById(R.id.txnppd3);
        TextView resultMLPD = findViewById(R.id.txtResultpd3);
        TextView resultMLPD2 = findViewById(R.id.txtResultpd4);
        RadioGroup groupMLN = findViewById(R.id.rgn2);
        RadioButton radioBMN = findViewById(R.id.rbmn);
        RadioButton radioBLN = findViewById(R.id.rbln);




        //BOTÃO PARA VOLTAR P TELA INICIAL!!
        voltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvoltar1 = new Intent(litro.this,MainActivity.class);
                startActivity(intentvoltar1);
            }
        });

        //BOTÃO PARA LIMPAR OS CAMPOS!!
        limp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantML.setText("");
                precoML.setText("");
                resultML.setText("");
                radioBM.setChecked(true);
                radioBL.setChecked(false);
                quantMLN.setText("");
                precoMLN.setText("");
                resultMLPD.setText("");
                resultMLPD2.setText("");
                radioBMN.setChecked(true);
                radioBLN.setChecked(false);
                quantML.requestFocus();

            }
        });

        //BOTÃO PARA REALIZAR A COMPARAÇÃO ENTRE OS PRODUTOS!!
        calc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double precoprod1ML,precoprod2ML;
                //VALIDAÇÃO DOS CAMPOS !!
                if ((quantML.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PESO DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    quantML.requestFocus();
                }
                else if ((precoML.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PREÇO DO PRODUTO 1",Toast.LENGTH_SHORT).show();
                    precoML.requestFocus();
                }
                else if ((quantMLN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PESO DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    quantMLN.requestFocus();
                }
                else if ((precoMLN.getText().toString().trim().isEmpty())) {
                    Toast.makeText(getApplicationContext(),"INSIRA O PREÇO DO PRODUTO 2",Toast.LENGTH_SHORT).show();
                    precoMLN.requestFocus();
                }

                else {
                    //VALIDA QUE O USUÁRIO NÃO INSIRA VALOR IGUAL A ZERO !!
                    double q2 = Double.parseDouble(quantML.getText().toString());
                    double p2 = Double.parseDouble(precoML.getText().toString());
                    double q3 = Double.parseDouble(quantMLN.getText().toString());
                    double p3 = Double.parseDouble(precoMLN.getText().toString());
                    if (q2 < 1) {
                        Toast.makeText(getApplicationContext(), "PESO DO PRODUTO 1 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        quantML.requestFocus();

                    } else if (p2 < 1) {
                        Toast.makeText(getApplicationContext(), "PREÇO DO PRODUTO 1 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        precoML.requestFocus();
                    }
                    else if (q3 < 1) {
                        Toast.makeText(getApplicationContext(), "PESO DO PRODUTO 2 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        quantMLN.requestFocus();

                    } else if (p3 < 1) {
                        Toast.makeText(getApplicationContext(), "PREÇO DO PRODUTO 2 NÃO PODE SER IGUAL A ZERO", Toast.LENGTH_SHORT).show();
                        precoMLN.requestFocus();
                    }
                    else{
                        if(radioBM.isChecked()){
                            precoprod1ML = (p2*1000) /q2;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultMLPD.setText("LITRO DO PRODUTO 1 CUSTA R$ " + df.format(precoprod1ML));

                        }else{
                            double convML = q2*1000;
                            precoprod1ML = (p2 * 1000)/convML;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultMLPD.setText("LITRO DO PRODUTO 1 CUSTA R$ " + df.format(precoprod1ML));
                        }
                        if(radioBMN.isChecked()){
                            precoprod2ML = (p3*1000) /q3;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultMLPD2.setText("LITRO DO PRODUTO 2 CUSTA R$ " + df.format(precoprod2ML));

                        }else{
                            double convML = q3*1000;
                            precoprod2ML = (p3 * 1000)/convML;
                            DecimalFormat df = new DecimalFormat("#.##");
                            resultMLPD2.setText("LITRO DO PRODUTO 2 CUSTA R$ " + df.format(precoprod2ML));


                        }
                        if(precoprod1ML < precoprod2ML){
                            resultML.setText("PRODUTO 1 É O MAIS ECONÔMICO ");
                        }

                        else if(precoprod1ML == precoprod2ML){
                            resultML.setText("PRODUTOS POSSUEM PREÇO IGUAL !!");
                        }

                        else{
                            resultML.setText("PRODUTO 2 É O MAIS ECONÔMICO");
                        }
                    }
                }
            }
        });
    }
}