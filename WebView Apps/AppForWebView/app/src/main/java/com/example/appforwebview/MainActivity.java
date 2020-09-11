package com.example.appforwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.wv_quiz_question);
        webView.loadUrl("https://quiz.tryinteract.com/#/5f5afd407c8b8c00146c2b7e?method=iframe");
    }
}
