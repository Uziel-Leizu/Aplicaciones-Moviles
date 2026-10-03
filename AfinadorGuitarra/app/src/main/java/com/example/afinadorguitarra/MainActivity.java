package com.example.afinadorguitarra;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class MainActivity extends Activity implements OnClickListener {
    static final String msg = "Reproduciendo ";
    MediaPlayer mp;
    Button jbnE1, jbnA1, jbnD1, jbnG1, jbnB1, jbnE2, jbns1;
    TextView jtv;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jbnE1 = (Button) findViewById(R.id.E1); jbnE1.setOnClickListener(this);
        jbnA1 = (Button) findViewById(R.id.A1); jbnA1.setOnClickListener(this);
        jbnD1 = (Button) findViewById(R.id.D1); jbnD1.setOnClickListener(this);
        jbnG1 = (Button) findViewById(R.id.G1); jbnG1.setOnClickListener(this);
        jbnB1 = (Button) findViewById(R.id.B1); jbnB1.setOnClickListener(this);
        jbnE2 = (Button) findViewById(R.id.E2); jbnE2.setOnClickListener(this);
        jtv = (TextView) findViewById(R.id.xtv);
    }
    public void onClick(View v) {
        if (v.getId() == jbnE1.getId()) {
            mp = MediaPlayer.create(this, R.raw.cuerdae2);
            jtv.setText(msg + "Cuerda E");
        } else if (v.getId() == jbnA1.getId()) {
            jtv.setText(msg + "Cuerda A");
            mp = MediaPlayer.create(this, R.raw.cuerdaa1);
        } else if (v.getId() == jbnD1.getId()){
            mp = MediaPlayer.create(this, R.raw.cuerdad1);
            jtv.setText(msg + "Cuerda D");
        } else if (v.getId() == jbnG1.getId()) {
            mp = MediaPlayer.create(this, R.raw.cuerdag1);
            jtv.setText(msg + "Cuerda G");
        } else if (v.getId() == jbnB1.getId()) {
            mp = MediaPlayer.create(this, R.raw.cuerdab1);
            jtv.setText(msg + "Cuerda B");
        } else if (v.getId() == jbnE2.getId()) {
            mp = MediaPlayer.create(this, R.raw.cuerdae1);
            jtv.setText(msg + "Cuerda E");
        }
        playSound(1);
    }
    @Override
    public void onPause(){
        try{
            super.onPause();
            mp.pause();
        } catch (Exception e){}
    }
    public void onStop(){
        super.onStop();
        mp.stop();
    }
    private void playSound(int arg){
        try{
            if(mp.isPlaying()){
                mp.stop();
                mp.release();
            }
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        mp.setLooping(false);
        mp.start();
    }
}