package com.example.rssfeedtesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class second extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");

        WebView w1 = (WebView) findViewById(R.id.webView);
        w1.loadUrl(url);
    }
}