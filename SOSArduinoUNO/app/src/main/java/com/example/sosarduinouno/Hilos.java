package com.example.sosarduinouno;

import android.widget.ImageView;

import com.ingenieriajhr.blujhr.BluJhr;

public class Hilos implements Runnable{
    BluJhr blue;
    ImageView Foco;
    volatile boolean ejecutar=false;
    public Hilos(BluJhr blue,ImageView foco){
        this.blue = blue;
        Foco = foco;
    }
    @Override
    public void run() {
        while (true) {
            if(ejecutar){
                try {
                    blue.bluTx("1");
                    Thread.sleep(100);
                    blue.bluTx("0");
                    Thread.sleep(100);
                    blue.bluTx("1");
                    Thread.sleep(100);
                    blue.bluTx("0");
                    Thread.sleep(100);
                    blue.bluTx("1");
                    Thread.sleep(100);
                    blue.bluTx("0");
                    Thread.sleep(100);
                    Thread.sleep(500);
                    blue.bluTx("1");
                    Thread.sleep(200);
                    blue.bluTx("0");
                    Thread.sleep(200);
                    blue.bluTx("1");
                    Thread.sleep(200);
                    blue.bluTx("0");
                    Thread.sleep(200);
                    blue.bluTx("1");
                    Thread.sleep(200);
                    blue.bluTx("0");
                    Thread.sleep(500);
                    blue.bluTx("1");
                    Thread.sleep(100);
                    blue.bluTx("0");
                    Thread.sleep(100);
                    blue.bluTx("1");
                    Thread.sleep(100);
                    blue.bluTx("0");
                    Thread.sleep(100);
                    blue.bluTx("1");
                    Thread.sleep(100);
                    blue.bluTx("0");
                    Thread.sleep(100);
                    Foco.setImageResource(R.drawable.on);
                    Thread.sleep(200);
                    Foco.setImageResource(R.drawable.off);
                    Thread.sleep(200);
                    Foco.setImageResource(R.drawable.on);
                    Thread.sleep(200);
                    Foco.setImageResource(R.drawable.off);
                    Thread.sleep(200);
                    Foco.setImageResource(R.drawable.on);
                    Thread.sleep(200);
                    Foco.setImageResource(R.drawable.off);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void correr(){
        ejecutar=true;
    }
    public void detener(){
        ejecutar=false;
    }
}
