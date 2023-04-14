package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Button but = findViewById(R.id.listbut);
        EditText edt = findViewById(R.id.listedittxt);
        TextView text = findViewById(R.id.listtext);
        Button back = findViewById(R.id.backlistbut);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String st = edt.getText().toString().replaceAll(" ", "");
                    String[] a = st.split(",");
                    double sr;
                    double[] b = new double[a.length];
                    double k = 0;
                    for (int i = 0; i < a.length; i++) {
                        b[i] = Double.valueOf(a[i]);
                        k += b[i];
                    }
                    sr = k / b.length;
                    Double disp = 0.;
                    for (int i = 0; i < b.length; i++) {
                        disp += (sr - b[i]) * (sr - b[i]);
                    }
                    disp = disp / b.length;
                    HashMap<String, Integer> m = new HashMap<>();
                    for (int i = 0; i < a.length; i++) {
                        if (m.containsKey(a[i])) {
                            m.put(a[i], m.get(a[i]) + 1);
                            continue;
                        }
                        m.put(a[i], 1);
                    }
                    int maximalCount = 0;
                    for (int s : m.values()) {
                        if (s > maximalCount) {
                            maximalCount = s;
                        }
                    }
                    String moda = "";
                    for (String e : m.keySet()) {
                        if (m.get(e) == maximalCount) {
                            moda += e + " ";
                        }
                    }
                    String mediana;
                    Arrays.sort(b);
                    if (b.length % 2 == 0) {
                        mediana = Double.toString((b[b.length / 2] + b[b.length / 2 - 1]) / 2);
                    } else {
                        mediana = Double.toString(b[b.length / 2]);
                    }
                    text.setText("Медиана: " + mediana + "\nМода: " + moda + "\nДисперсия: " + disp);
                }
                catch (NumberFormatException exc){
                    text.setText("Неверный формат ввода! Вводите действительные числа через запятую, десятичную часть от целой разделяйте точкой.");
                }
                }
        });
    }
}