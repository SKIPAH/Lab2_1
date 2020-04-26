package com.example.lab2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button requestUrlButton;
    EditText requestUrlEditor;
    String urlString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestUrlButton = (Button) findViewById(R.id.button);
        requestUrlEditor = (EditText) findViewById(R.id.editText);

        requestUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlString = "https://" + requestUrlEditor.getText().toString();

            }
        });
    }
        protected void loadFromWeb(String urlString) {
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(connection.getInputStream());
                String htmlText = Utilities.fromStream(in);
                TextView textView = findViewById(R.id.httpTextView);
                textView.setText(htmlText);
            }
            catch (Exception e) {e.printStackTrace();}
        }
    }

