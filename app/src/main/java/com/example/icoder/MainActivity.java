package com.example.icoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Developed by Prashant @iammprashant
public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private WebView mWebView;

    private String urlToload="https://iammprashant.github.io/iCoder/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //assignviewbyid
        mProgressBar = findViewById(R.id.loading_progressbar);
        mWebView = findViewById(R.id.webview);

        mWebView.loadUrl(urlToload);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack())
        {
            mWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}