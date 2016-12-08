package com.example.rssfeedtesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {
    EditText link;
    TextView title, description, url;
    Button fetchButton, resultButton;
    private String finalUrl = "http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.editText);
        link = (EditText) findViewById(R.id.editText2);
        description = (TextView) findViewById(R.id.editText3);
        url = (TextView) findViewById(R.id.urlText);

        fetchButton = (Button) findViewById(R.id.button);
        resultButton = (Button) findViewById(R.id.button2);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalUrl = "http://"+link.getText().toString();
                obj = new HandleXML(finalUrl);
                obj.fetchXML();

                while (obj.parsingComplete) ;

                XMLItem item = obj.getItem();
                title.setText(item.getTitle());
                description.setText(item.getDescription());
                url.setText(item.getUrl());
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, second.class);
                in.putExtra("URL", finalUrl);
                startActivity(in);
            }
        });
    }

}