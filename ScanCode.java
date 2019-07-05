package com.example.ignadwiutami.examinaphonescreenpin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCode extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView( this);
        setContentView(ScannerView);
    }

    @Override
    public void handleResult(Result result) {

        // MainActivity.resultTV.setText(result.getText());
        //onBackPressed();
        Intent i = new Intent(ScanCode.this, webView.class);
        i.putExtra("url",result.getText());
        startActivity(i);

    }

    @Override
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }
}
