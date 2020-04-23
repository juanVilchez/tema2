package com.example.mitema2online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class comunicacion1 extends AppCompatActivity {
    EditText edtnombre;
    EditText edtedad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicacion1);
        edtnombre=findViewById(R.id.edtnombre);
        edtedad=findViewById(R.id.edtedad);
    }
    public void Verificar(View view){
        Intent intent = new Intent(this, comunicacion2.class);
        intent.putExtra("nombre", edtnombre.getText().toString());
        intent.putExtra("edad", Integer.parseInt(edtedad.getText().toString()));
//startActivity(intent);
        startActivityForResult(intent, 1234);
    }
    @Override protected void onActivityResult(int requestCode,
                                               int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String res = data.getExtras().getString("resultado");
            TextView miresultado = findViewById(R.id.txtvalor);
            if (res.equals("aceptado"))
                miresultado.setText("Esperamos que trabajar con nosotros sea de su agrado");
            else
                miresultado.setText("Esperemos que cambie de opinion para trabajar con nosotros");
        }
    }
}
