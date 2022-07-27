package com.school.jljapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyBrowser extends AppCompatActivity {

    private EditText url;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);

        url = findViewById(R.id.editText3);
        go = findViewById(R.id.button6);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!url.getText().toString().isEmpty()){
                    String path = "https://" + url.getText().toString();
                    final ProgressDialog pd = ProgressDialog.show(MyBrowser.this,"","Loading...",true);
                    pd.setCancelable(true);
                    WebView wv = findViewById(R.id.webview2);
                    wv.getSettings().setJavaScriptEnabled(true);
                    wv.getSettings().setBuiltInZoomControls(true);
                    wv.getSettings().setDisplayZoomControls(true);
                    wv.getSettings().setLoadsImagesAutomatically(true);
                    wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                    wv.loadUrl(path);
                    wv.setWebViewClient(new WebViewClient(){
                        @Override
                        public void onPageFinished(WebView view, String url){
                            if (pd!=null && pd.isShowing()){
                                pd.dismiss();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(),"URL can't be empty!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}