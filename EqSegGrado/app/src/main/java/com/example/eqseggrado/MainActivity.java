package com.example.eqseggrado;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnCalcular;
    EditText A,B,C;
    TextView Resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = (Button) findViewById(R.id.calcular);
        btnCalcular.setOnClickListener(this);
        A = (EditText) findViewById(R.id.ValorA);
        B = (EditText) findViewById(R.id.ValorB);
        C = (EditText) findViewById(R.id.ValorC);
        Resultado = (TextView) findViewById(R.id.resultado);
    }

    @Override
    public void onClick(View view) {
        Resultado.setText("");
        CalcularEq();
    }

    public void CalcularEq(){
        int a = Integer.parseInt(A.getText()+"");
        int b = Integer.parseInt(B.getText()+"");
        int c = Integer.parseInt(C.getText()+"");
        double x1,x2;
        Resultado.append("a="+a+" b="+b+" c="+c);
        int cuadrado = b*b;
        //Resultado.append("\nCuadrado: "+cuadrado);
        int apoyo =cuadrado-(4*a*c);
        //Resultado.append("\n"+apoyo);
        double valorDentro = sqrt(apoyo);
        //Resultado.append("\n"+valorDentro);
        x1 = (-b + valorDentro)/(2*a);
        x2 = (-b - valorDentro)/(2*a);
        Resultado.append("\nX1= "+x1+" X2= "+x2);
    }
}