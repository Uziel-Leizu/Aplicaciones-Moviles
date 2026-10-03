package com.example.appcirculobarra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import java.util.Timer;

public class Lienzo extends View {
    static Paint p;
    SeekBar sb;
    int x, y;
    private Timer timer;
    static int R = 100;

    public Lienzo(Context context) {
        super(context);
        iniciar();
    }
    public Lienzo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        iniciar();
    }
    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniciar();
    }
    public void iniciar(){
        p = new Paint();

        p.setColor(Color.BLUE);
        timer = new Timer();

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            x = canvas.getWidth();
            y = canvas.getHeight();
            canvas.drawCircle(x / 2, y / 2, R, p);
            invalidate();
    }
    static void setRadius(int Radio){
         R = Radio;
    }
}

