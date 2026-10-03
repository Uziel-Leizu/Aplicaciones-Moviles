package com.example.appcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText amp;
    EditText per;
    Button btn;
    Bundle bdl;
    Intent itn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.calcular);
        amp = (EditText) findViewById(R.id.ValorAmp);
        per = (EditText) findViewById(R.id.ValorPer);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itn = new Intent(MainActivity.this,SegundaActivity.class);
        bdl = new Bundle();
        bdl.putString("amp",amp.getText().toString());
        bdl.putString("per",per.getText().toString());
        itn.putExtras(bdl);
        startActivity(itn);
    }
}