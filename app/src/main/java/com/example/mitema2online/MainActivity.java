package com.example.mitema2online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //solo arma la interface grafica
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true; /** true -> el menú ya está visible */
    }
    //cuando se pulsa el boton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.accion_compartir) {
            Intent paramView;
            paramView = new Intent("android.intent.action.SEND");//busca la mejor app para compartir
            paramView.setType("text/plain");
            paramView.putExtra("android.intent.extra.TEXT", "Descarga nuestra app de la PlayStore" +
                    " \n" + "https://play.google.com/store/apps/details?id=app.product.demarktec.alo14_pasajero");//indicas la direccion
            startActivity(Intent.createChooser(paramView, "Comparte Nuestro aplicativo"));//mensaje adicional para compartir
            return true;
        }
        if (id == R.id.accion_salir) {
            finish();
            return true;
        }
        if (id == R.id.activity_comunicacion) {
            startActivity(new Intent(this, comunicacion1.class));
            return true;
        }
        if (id == R.id.activity_intenciones) {
            startActivity(new Intent(this, Intenciones.class));
            return true;
        }
        if (id == R.id.activity_multimedia) {
            startActivity(new Intent(this, Multimedia.class));
            return true;
        }
        if (id == R.id.activity_permisos) {
            startActivity(new Intent(this, Permisos.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
