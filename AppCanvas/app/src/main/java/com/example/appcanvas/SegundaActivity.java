package com.example.appcanvas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class SegundaActivity extends Activity {
    Bundle bdl;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        bdl = getIntent().getExtras();
        int amp = Integer.parseInt(bdl.getString("amp"));
        int per = Integer.parseInt(bdl.getString("per"));
        float famp = (float) amp;
        float fper = (float) per;
        Lienzo l = new Lienzo(this,famp,fper);
        setContentView(l);
    }
}
