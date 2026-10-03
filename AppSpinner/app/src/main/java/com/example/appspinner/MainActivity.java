package com.example.appspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Activity;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends Activity {
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = (Spinner) findViewById(R.id.xsp);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> av, View v,int i,long l){
                Toast.makeText(MainActivity.this, s.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> arg0){ }
        });
    }
}