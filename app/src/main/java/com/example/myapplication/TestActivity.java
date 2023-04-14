package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.NumberFormatException;

public class TestActivity extends AppCompatActivity {
    public static String primer;
    public static String[] otv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView text = findViewById(R.id.testtext);
        Funtions.test(Funtions.getRandomNumber(1, 3));
        text.setText("Решайте уравнения и примеры!\nВот ваша задача: \n" + primer);
        Button but = findViewById(R.id.testanswerbut);
        Button backbut = findViewById(R.id.backtestbutton);
        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TestActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    EditText edtxt = findViewById(R.id.answertext);
                    String o = edtxt.getText().toString();
                    o.replaceAll(" ", "");
                    if (!o.contains(",")) {
                        if (Double.valueOf(otv[0]).equals(Double.valueOf(o))) {
                            Funtions.test(Funtions.getRandomNumber(1, 3));
                            text.setText("Верно! Следующая задача: \n" + primer);
                        } else {
                            text.setText("Попробуйте ещё раз! \n" + primer);
                        }
                    } else {
                        String fst = o.substring(0, o.indexOf(","));
                        String scn = o.substring(o.indexOf(",") + 1, o.length());
                        double fstotv = Double.valueOf(otv[0]);
                        double scnotv = Double.valueOf(otv[1]);
                        if ((fstotv == Double.valueOf(fst) || fstotv == Double.valueOf(scn)) && (scnotv == Double.valueOf(fst) || scnotv == Double.valueOf(scn))) {
                            Funtions.test(Funtions.getRandomNumber(1, 3));
                            text.setText("Верно! Следующая задача: \n" + primer);
                        } else {
                            text.setText("Попробуйте ещё раз! \n" + primer);
                        }
                    }
                }
                catch (NumberFormatException exc){
                    text.setText("Неверный формат ввода! Ответы разделяйте запятой,nдесятые от целой части - точкой. \n" + primer);
                }
            }
        });
    }
}