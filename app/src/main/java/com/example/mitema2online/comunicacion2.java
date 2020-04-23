package com.example.mitema2online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class comunicacion2 extends AppCompatActivity {
    TextView txtmensaje;
    String nombre;
    int edad;
    int evaluacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicacion2);
        Bundle extras = getIntent().getExtras();
        nombre= extras.getString("nombre");
        edad = extras.getInt("edad");
        txtmensaje=findViewById(R.id.txtmensaje);
        if (edad > 25)
            evaluacion = 3000;
        else
            evaluacion = 2000;
        txtmensaje.setText("Buen día "+ nombre + " por su edad de " + edad +
                " podemos ofrecerle " + evaluacion + "soles");
    }
    public void aceptar(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado","aceptado");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void rechazar(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado","rechazado");
        setResult(RESULT_OK, intent);
        finish();
    }
}
