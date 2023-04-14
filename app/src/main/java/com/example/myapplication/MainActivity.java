package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test = findViewById(R.id.testbutton);
        Button sin = findViewById(R.id.sinbutton);
        Button listofnumbers = findViewById(R.id.listnumbers);
        EditText sinin = findViewById(R.id.sinin);
        TextView sinout = findViewById(R.id.sinout);
        Button ans = findViewById(R.id.answer);
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AnswerActivity.class);
                startActivity(i);
            }
        });
        listofnumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TestActivity.class);
                startActivity(i);
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DecimalFormat d = new DecimalFormat("#.####");
                    double s = Math.toRadians(Double.valueOf(sinin.getText().toString()));

                    sinout.setText("sin: " + d.format(Math.sin(s)) + " cos: " + d.format(Math.cos(s)) + " tg: " + d.format(Math.tan(s)));
                }
                catch (java.lang.NumberFormatException e) {
                    sinout.setText("Неверный формат ввода!");
                }
            }
        });
    }
}