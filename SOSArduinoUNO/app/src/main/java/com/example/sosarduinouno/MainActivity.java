package com.example.sosarduinouno;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ingenieriajhr.blujhr.BluJhr;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ToggleButton jtb;
    boolean enviar=false;
    ImageView Foco;
    Hilos main;
    BluJhr blue;
    List<String> requiredPermissions;
    ArrayList<String> devicesBluetooth = new ArrayList<String>();
    LinearLayout viewConn;
    ListView listDeviceBluetooth;
    Button buttonSend;
    TextView consola;
    EditText edtTx;
    Timer timer = new Timer();
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jtb = (ToggleButton) findViewById(R.id.xtb);
        jtb.setOnClickListener(this);
        Foco = (ImageView) findViewById(R.id.foco);
        blue = new BluJhr(this);
        blue.onBluetooth();
        listDeviceBluetooth = findViewById(R.id.listDeviceBluetooth);
        viewConn = findViewById(R.id.viewConn);

        listDeviceBluetooth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (!devicesBluetooth.isEmpty()) {
                    blue.connect(devicesBluetooth.get(i));
                    blue.setDataLoadFinishedListener(new BluJhr.ConnectedBluetooth() {
                        @Override
                        public void onConnectState(@NonNull BluJhr.Connected connected) {
                            if (connected == BluJhr.Connected.True) {
                                Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
                                listDeviceBluetooth.setVisibility(View.GONE);
                                viewConn.setVisibility(View.VISIBLE);
                                rxReceived();
                                main = new Hilos(blue,Foco);
                                thread = new Thread(main,"main");
                                thread.start();
                            } else {
                                if (connected == BluJhr.Connected.Pending) {
                                    Toast.makeText(getApplicationContext(), "Pending", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (connected == BluJhr.Connected.False) {
                                        Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (connected == BluJhr.Connected.Disconnect) {
                                            Toast.makeText(getApplicationContext(), "Disconnect", Toast.LENGTH_SHORT).show();
                                            listDeviceBluetooth.setVisibility(View.VISIBLE);
                                            viewConn.setVisibility(View.GONE);
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });

    }

    private void rxReceived() {

        blue.loadDateRx(new BluJhr.ReceivedData() {
            @Override
            public void rxDate(@NonNull String s) {
                consola.setText(consola.getText().toString() + s);
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (blue.checkPermissions(requestCode, grantResults)) {
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
            blue.initializeBluetooth();
        } else {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                blue.initializeBluetooth();
            } else {
                Toast.makeText(this, "Algo salio mal", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (!blue.stateBluetoooth() && requestCode == 100) {
            blue.initializeBluetooth();
        } else {
            if (requestCode == 100) {
                devicesBluetooth = blue.deviceBluetooth();
                if (!devicesBluetooth.isEmpty()) {
                    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, devicesBluetooth);
                    listDeviceBluetooth.setAdapter(adapter);
                } else {
                    Toast.makeText(this, "No tienes vinculados dispositivos", Toast.LENGTH_SHORT).show();
                }

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    //Accion del boton
    @Override
    public void onClick(View view) {
        if (jtb.isChecked()){
            showToastMessage("Botón: ToggleButton en ON");
            main.correr();
        }
        else {
            showToastMessage("Botón: ToggleButton en OFF");
            main.detener();
        }
    }
    private void showToastMessage(String s) {
        Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        t.show();
    }

}