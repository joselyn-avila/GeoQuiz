package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_verdadero;
    Button btn_falso;
    Button btn_siguiente;
    TextView textPregunta;
    Pregunta[] preguntas = new Pregunta[]{
            new Pregunta(R.string.Pregunta_1, true),
            new Pregunta(R.string.Pregunta_2, false),
            new Pregunta(R.string.Pregunta_3, true),
            new Pregunta(R.string.Pregunta_4, true),
            new Pregunta(R.string.Pregunta_5, false),
    };

    int preguntaActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //toma el activity main

        btn_verdadero = findViewById(R.id.btn_verdadero);
        btn_falso= findViewById(R.id.btn_falso);
        btn_siguiente= findViewById(R.id.btn_siguiente);
        textPregunta = findViewById(R.id.text_pregunta);

        Pregunta pregunta= preguntas [preguntaActual];
        textPregunta.setText(pregunta.getId());

        btn_verdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d( "MainActivity" ,  "Click en btnVerdadero");
                Toast.makeText( MainActivity.this, R.string.CORRECTO, Toast.LENGTH_SHORT).show();
            }
        });

        btn_falso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity" , "Click en btnfalso");
                Toast.makeText( MainActivity.this, R.string.INCORRECTO , Toast.LENGTH_SHORT).show();
            }
        });


        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preguntaActual ++;
                Pregunta pregunta= preguntas [preguntaActual];
                textPregunta.setText(pregunta.getId());



            }
        });
    }

}