package com.example.aluno.calculartroco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText valor;
    private EditText pago;
    private Button troco;
    private Button limpar;
    private TextView showTroco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = (EditText) findViewById(R.id.valor);
        pago = (EditText) findViewById(R.id.pago);
        troco = (Button) findViewById(R.id.troco);
        limpar = (Button) findViewById(R.id.limpar);
        showTroco = (TextView) findViewById(R.id.showTroco);

        troco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Double valor1 = Double.parseDouble( valor.getText().toString() );
                    Double pago1 = Double.parseDouble( pago.getText().toString() );

                    Double result = valor1 - pago1;

                    //Formanto para a variável aparecer até 2 casas após a virgula
                    NumberFormat format = NumberFormat.getInstance();
                    format.setMaximumFractionDigits(2);
                    format.setRoundingMode(RoundingMode.HALF_UP);
                    result = Double.valueOf(format.format(result));

                    showTroco.setText("Troco: R$" + result*(-1));

                    //Toast.makeText(MainActivity.this, "$"+result*(-1), Toast.LENGTH_LONG).show();

                } catch (Exception E){
                    // Caso ocorra algum erro...
                    Toast.makeText(MainActivity.this, "Houve um problema. Tente novamente!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    valor.setText(" ");
                    pago.setText(" ");
                    showTroco.setText(" ");

                }catch (Exception E){
                    Toast.makeText(MainActivity.this, "Houve um problema ao limpar. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
