package com.example.nfceditor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final int DIALOG_WRITE_URL = 1;
    private EditText mMyUrl;
    private Button mMyWriteUrlButton;
    private boolean mWriteUrl = false;
    private static final int PENDING_INTENT_TECH_DISCOVERED = 1;
    private NfcAdapter mNfcAdapter;
    private static final int DIALOG_NEW_TAG = 3;
    private static final String ARG_MESSAGE = "message";

    private String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyUrl = (EditText) findViewById(R.id.myUrl);
        mMyWriteUrlButton = (Button) findViewById(R.id.myWriteUrl);

        mMyWriteUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWriteUrl = true;
                MainActivity.this.showDialog(DIALOG_WRITE_URL);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id,Bundle args){
        switch (id){
            case DIALOG_WRITE_URL:
                return new AlertDialog.Builder(this)
                        .setTitle("Write URL to tag...")
                        .setMessage("Touch tag to start writing.")
                        .setCancelable(true)
                        .setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialogInterface) {
                                mWriteUrl = false;
                            }
                        }).create();
            case DIALOG_NEW_TAG:
                return new AlertDialog.Builder(this)
                        .setTitle("Tag detected")
                        .setMessage(message)
                        .setCancelable(true)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        NfcManager nfcManager = (NfcManager) this.getSystemService(Context.NFC_SERVICE);
        mNfcAdapter = nfcManager.getDefaultAdapter();
        PendingIntent pi = createPendingResult(PENDING_INTENT_TECH_DISCOVERED,new Intent(),0);
        mNfcAdapter.enableForegroundDispatch(this,
                pi,
                new IntentFilter[]{new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED)},
                new String[][]{
                        new String[]{"android.nfc.tech.NdefFormatable"},
                        new String[]{"android.nfc.tech.Ndef"}
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PENDING_INTENT_TECH_DISCOVERED:
                resolveIntent(data, true);
                break;
        }
    }
    private void resolveIntent(Intent data,boolean foregroundDispatch){
        String action = data.getAction();
        if((data.getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY)!=0) return;
        if(NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)||NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)){
            Tag tag = data.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if(foregroundDispatch && mWriteUrl){
                mWriteUrl = false;
                String urlStr = mMyUrl.getText().toString();
                byte[] urlBytes = urlStr.getBytes(Charset.forName("UTF-8"));
                byte[] urlPayload = new byte[urlBytes.length+1];
                urlPayload[0]=0;
                System.arraycopy(urlBytes,0,urlPayload,1,urlBytes.length);
                NdefRecord urlRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                        NdefRecord.RTD_URI,
                        new byte[0],
                        urlPayload);
                NdefMessage msg = new NdefMessage(new NdefRecord[]{urlRecord});
                Ndef ndefTag = Ndef.get(tag);
                if(ndefTag != null){
                    try {
                        ndefTag.connect();
                        ndefTag.writeNdefMessage(msg);
                    }catch (Exception e){
                    }finally {
                        try{ndefTag.close();}catch (Exception e){}
                    }
                }else{
                    //is not formatted
                    NdefFormatable ndefFormatableTag = NdefFormatable.get(tag);
                    if(ndefFormatableTag != null){
                        try{
                            ndefFormatableTag.connect();
                        }catch (Exception e){
                        }finally {
                            try{
                                ndefFormatableTag.close();
                            }catch (Exception e){}
                        }

                    }
                }
                dismissDialog(DIALOG_WRITE_URL);
            }else{
                StringBuilder tagInfo = new StringBuilder();
                byte[] uid = tag.getId();
                tagInfo.append("UID: ")
                        .append(bytesToHex(uid))
                        .append("\n\n");
                Parcelable[] ndefRaw = data.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
                NdefMessage[] ndefMsgs = null;
                if(ndefRaw != null){
                    ndefMsgs = new NdefMessage[ndefRaw.length];
                    for(int i = 0; i<ndefMsgs.length;i++){
                        ndefMsgs[i] = (NdefMessage) ndefRaw[i];
                    }
                }
                if(ndefMsgs != null){
                    for(int i=0;i<ndefMsgs.length;++i){
                        NdefRecord[] records = ndefMsgs[i].getRecords();
                        if(records != null){
                            for(int j = 0; j < records.length; ++j){
                                if((records[j].getTnf()==NdefRecord.TNF_WELL_KNOWN)&& Arrays.equals(records[j].getType(),NdefRecord.RTD_URI)){
                                    byte[] payload = records[j].getPayload();
                                    String uri = new String(Arrays.copyOfRange(payload,1,payload.length),Charset.forName("UTF-8"));
                                    tagInfo.append("URI: ").append(uri).append("\n");
                                }
                            }
                        }
                    }
                }
                System.out.println(tagInfo.toString());
                Bundle args = new Bundle();
                args.putString(ARG_MESSAGE,tagInfo.toString());
                message = "";
                message = tagInfo.toString();
                showDialog(DIALOG_NEW_TAG,args);
            }
        }
    }
    public String bytesToHex(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(1, bytes);
        String hexString = bigInteger.toString(16);
        // Asegurar que la cadena hexadecimal tenga el número correcto de dígitos
        int paddingLength = (bytes.length * 2) - hexString.length();
        if (paddingLength > 0) {
            hexString = String.format("%0" + paddingLength + "d", 0) + hexString;
        }
        return hexString;
    }
    @Override
    protected void onPrepareDialog(int id, Dialog dialog,Bundle args) {
        switch (id){
            case DIALOG_NEW_TAG:
                String message = args.getString(ARG_MESSAGE);
                if(message != null){
                    System.out.println("Hola estamos en PrepareDialog");
                    ((AlertDialog) dialog).setMessage(message);
                }
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        resolveIntent(intent,false);
    }
}