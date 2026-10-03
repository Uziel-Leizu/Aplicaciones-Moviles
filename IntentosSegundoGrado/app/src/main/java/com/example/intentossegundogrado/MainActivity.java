package com.example.intentossegundogrado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;


public class MainActivity extends Activity implements View.OnClickListener {
    Button btnEnv;
    EditText A,B,C;
    Bundle bdl;
    Intent itn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnv = (Button) findViewById(R.id.calcular);
        A = (EditText) findViewById(R.id.ValorA);
        B = (EditText) findViewById(R.id.ValorB);
        C = (EditText) findViewById(R.id.ValorC);
        btnEnv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itn = new Intent(MainActivity.this,SegundaActivity.class);
        bdl = new Bundle();
        bdl.putString("A",A.getText().toString());
        bdl.putString("B",B.getText().toString());
        bdl.putString("C",C.getText().toString());
        itn.putExtras(bdl);
        startActivity(itn);
    }
}