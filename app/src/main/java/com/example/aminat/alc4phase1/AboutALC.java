package com.example.aminat.alc4phase1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by AMINAT on 7/14/2019.
 */

public class AboutALC extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_aboutalc);

        webview = (WebView) findViewById(R.id.webview);
        webview  = new WebView(this);

        webview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        webview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });


        webview.loadUrl("https://andela.com/alc/");

//        setContentView(webview );
    }
}
