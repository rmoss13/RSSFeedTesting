package com.example.rssfeedtesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends Activity {
    TextView link, title;
    private String finalUrl = "http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.editText);
        link = (TextView) findViewById(R.id.editText2);

        finalUrl = "http://" + link.getText().toString();
        obj = new HandleXML(finalUrl);
        obj.fetchXML();

        while (obj.parsingComplete) ;

        ArrayList<XMLItem> items = obj.getItem();
        for (XMLItem item : items) {
            title.setText(title.getText() + item.toString());
        }
        title.setMovementMethod(new ScrollingMovementMethod());
    }

}