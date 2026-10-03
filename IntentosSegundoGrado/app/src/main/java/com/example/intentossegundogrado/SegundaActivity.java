package com.example.intentossegundogrado;

import static java.lang.Math.sqrt;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;


public class SegundaActivity extends Activity {
    TextView Resultado;
    Bundle bdl;
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        Resultado = (TextView) findViewById(R.id.res);
        bdl = getIntent().getExtras();
        CalcularEq();
    }
    public void CalcularEq(){
        int a = Integer.parseInt(bdl.getString("A"));
        int b = Integer.parseInt(bdl.getString("B"));
        int c = Integer.parseInt(bdl.getString("C"));
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
