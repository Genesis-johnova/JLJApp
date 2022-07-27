package com.school.jljapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyWebView extends AppCompatActivity {

    private TextView user;
    private Button btnpc, btnperi, btnBrowser, btnlocate;
    private ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);

        banner = findViewById(R.id.imageView2);
        user = findViewById(R.id.textView2);
        btnpc = findViewById(R.id.pcbutton);
        btnperi = findViewById(R.id.peributton);
        btnlocate = findViewById(R.id.locatebutton);
        btnBrowser = findViewById(R.id.browserbutton);
        Intent i = getIntent();
        String username = i.getStringExtra("Username");
        // user.setText("Hello " + username);

        btnpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pd = ProgressDialog.show(MyWebView.this,"","Loading...",true);
                pd.setCancelable(true);
                WebView wv = findViewById(R.id.webview);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.getSettings().setBuiltInZoomControls(true);
                wv.getSettings().setDisplayZoomControls(true);
                wv.getSettings().setLoadsImagesAutomatically(true);
                wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv.loadUrl("https://www.dell.com/en-sg/shop/deals/laptop-deals?gacd=9654672-8037-5761040-272420144-0&dgc=ST&gclid=CjwKCAjww8mWBhABEiwAl6-2RaVM4yCbW5o0iY9rWxl63fvMbpY6FtUjEl20EMKyIEkJs8_XnkTjARoCYxUQAvD_BwE&gclsrc=aw.ds");
                wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageFinished(WebView view, String url){
                        if (pd!=null && pd.isShowing()){
                            pd.dismiss();
                        }
                    }
                });
            }
        });

        btnperi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pd = ProgressDialog.show(MyWebView.this,"","Loading...",true);
                pd.setCancelable(true);
                WebView wv = findViewById(R.id.webview);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.getSettings().setBuiltInZoomControls(true);
                wv.getSettings().setDisplayZoomControls(true);
                wv.getSettings().setLoadsImagesAutomatically(true);
                wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv.loadUrl("https://www.logitech.com/en-sg/business/keyboards-mice.html");
                wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageFinished(WebView view, String url){
                        if (pd!=null && pd.isShowing()){
                            pd.dismiss();
                        }
                    }
                });
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MyBrowser.class);
                startActivity(i);
            }
        });

        btnlocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }
        });


        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(i);
            }
        });



    }
}