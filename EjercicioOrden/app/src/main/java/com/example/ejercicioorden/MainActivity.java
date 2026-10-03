package com.example.ejercicioorden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText EdEntrada;
    Button btn;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdEntrada=(EditText) findViewById(R.id.EdEntrada);
        btn = (Button) findViewById(R.id.btnEnviar);
        btn.setOnClickListener(this);
        tvResultado=(TextView) findViewById(R.id.tvResultado);
    }

    public int[] burbuja (int[] array){
        int aux=0;
        int i,j;
        for(i=0;i<array.length;i++){
            for(j=0;j<array.length-i-1;j++){
                if(array[j+1]<array[j]){
                    aux = array[j+1];
                    array[j+1]=array[j];
                    array[j]=aux;
                }
            }
        }
        return array;
    }
    public int[] invertir(int[] array){
        int aux[] = new int[array.length];
        for(int i = 0,j=array.length-1;i<array.length;i++,j--){
            aux[i]=array[j];
        }
        array = aux;
        return array;
    }

    @Override
    public void onClick(View v) {
        String ent = EdEntrada.getText().toString();
        int numeros[];
        numeros = new int[ent.length()];
        for(int i = 0;i<EdEntrada.length();i++){
            numeros[i] = Integer.parseInt(ent.charAt(i)+"");
        }
        StringBuilder numero1 = new StringBuilder();
        StringBuilder numero2 = new StringBuilder();
        numeros = burbuja(numeros);


        int invNum[] = invertir(numeros);
        for(int i = 0; i<invNum.length;i++){
            tvResultado.append(invNum[i]+"");
            numero2.append(invNum[i]+"");
        }
        tvResultado.append("\n");
        for(int i = 0; i<numeros.length;i++){
            tvResultado.append(numeros[i]+"");
            numero1.append(numeros[i]+"");
        }

        int num2 = Integer.parseInt(numero2.toString());
        int num1 = Integer.parseInt(numero1.toString());

        int num3 = num2-num1;
        tvResultado.append("\n----------------\n");
        //tvResultado.append(num2+"\n");
        //tvResultado.append(num1+"\n");
        tvResultado.append(num3+"");
    }
}