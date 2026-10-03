package com.example.appcirculobarra;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar seekBar;
    Lienzo l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.xsb1);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setMax(500);
        seekBar.setProgress(100);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Lienzo.setRadius(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}