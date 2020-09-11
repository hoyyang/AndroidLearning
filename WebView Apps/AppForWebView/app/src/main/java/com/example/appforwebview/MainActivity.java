package com.example.appforwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.wv_quiz_question);

        String frameString = "<iframe id=\"interactApp5f5afd407c8b8c00146c2b7e\" width=\"800\" height=\"800\" style=\"border:none;max-width:100%;margin:0;\" allowTransparency=\"true\" frameborder=\"0\" src=\"https://quiz.tryinteract.com/#/5f5afd407c8b8c00146c2b7e?method=iframe\"></iframe>";
        String URL = "https://quiz.tryinteract.com/#/5f5afd407c8b8c00146c2b7e?method=iframe";
        String GOOGLE_URL = "https://www.google.com";


//        webView.loadData(
//                URL,
//                "text/html",
//                "utf-8");
        webView.loadUrl(GOOGLE_URL);
//        webView.loadDataWithBaseURL();
//        webView.loadDataWithBaseURL(frameString, );
    }
}
