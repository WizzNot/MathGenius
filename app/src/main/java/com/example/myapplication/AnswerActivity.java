package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Button backbut = findViewById(R.id.backasnwerbut);
        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnswerActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        TextView txt = findViewById(R.id.answertextview);
        Button asnwerstrt = findViewById(R.id.answerb);
        EditText answeredt = findViewById(R.id.answerin);
        asnwerstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String otv = "";
                    for(String s:Funtions.answeruravn(answeredt.getText().toString().replaceAll(" ", "")))
                    {
                        otv = otv + s + " ";
                    }
                    txt.setText(otv);
                }
                catch (NumberFormatException e)
                {
                    txt.setText("Неправильный формат ввода! Приведите уравнение к стандартному виду.");
                }
                catch (StringIndexOutOfBoundsException e)
                {
                    txt.setText("Вводите уравнение в формате Ax^2 + Bx + C");
                }
            }
        });
    }
}
