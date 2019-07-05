package com.example.ignadwiutami.examinaphonescreenpin;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class webView extends AppCompatActivity {

    ProgressBar pbloading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        pbloading = findViewById(R.id.pbloading);
        WebView browser = (WebView) findViewById(R.id.webView);
        browser.setWebViewClient(new MyBrowser(pbloading));
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.loadUrl(getIntent().getStringExtra("url"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class MyBrowser extends WebViewClient {

        ProgressBar progressBar;

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }

        public MyBrowser(ProgressBar progressBar) {
            this.progressBar = progressBar;

            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void
        onPageFinished(WebView view, String url) {

            //TODO Auto-generated method stub

            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }


        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }
    }
}


