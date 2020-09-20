package com.jolly.creations.pirateace;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class level4 extends AppCompatActivity {

    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0;
    Button enter,clear;
    TextView answers;
    WebView wv1;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        progressDialog=new ProgressDialog(this);

        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Please Wait !"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner

        progressDialog.setCancelable(true);

        n0=(Button)findViewById(R.id.n0);
        n1=(Button)findViewById(R.id.n1);
        n2=(Button)findViewById(R.id.n2);
        n3=(Button)findViewById(R.id.n3);
        n4=(Button)findViewById(R.id.n4);
        n5=(Button)findViewById(R.id.n5);
        n6=(Button)findViewById(R.id.n6);
        n7=(Button)findViewById(R.id.n7);
        n8=(Button)findViewById(R.id.n8);
        n9=(Button)findViewById(R.id.n9);

        enter=(Button)findViewById(R.id.enter);
        clear=(Button)findViewById(R.id.clear);

        answers=(TextView) findViewById(R.id.answer);

        wv1=(WebView)findViewById(R.id.question);
        wv1.setWebViewClient(new MyBrowser());

        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl("https://pirate-project.hariom04.repl.co/level4.html");

        wv1.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show(); // Display Progress Dialog

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                super.onPageFinished(view, url);
                progressDialog.hide();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                progressDialog.hide();
                handler.proceed(); // Ignore SSL certificate errors
            }

            public void onReceivedError(final WebView webView, int errorCode, String description, String failingUrl) {
                progressDialog.hide();
                try {
                    webView.stopLoading();
                } catch (Exception e) {
                }

                if (webView.canGoBack()) {
                    webView.goBack();
                }

                //load("about:blank");
                AlertDialog alertDialog = new AlertDialog.Builder(level4.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Server not Available ! \nCheck your internet connection and try again.");
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        webView.reload();
                    }
                });

                alertDialog.show();
                super.onReceivedError(webView, errorCode, description, failingUrl);
            }




        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers.getText().toString().equals("4"))
                {
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(level4.this,level5.class));
                }
                else
                {

                }
            }
        });

        //for number updating
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"0");
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"1"); }});

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"2"); }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"3"); }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"4"); }});

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"5"); }});

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"6"); }});

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"7"); }});

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"8"); }});

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { answers.setText(answers.getText().toString()+"9"); }});


    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



}
