package com.example.mitema2online;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.URLEncoder;

public class Intenciones extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenciones);
    }

    public void web(View view) {
        //action view es una accion implisita y va a buscar la mejor aplicacion para abrir la url
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://developer.android.com/guide/components/intents-common?hl=es-419"));
        startActivity(intent);
    }

    public void Llamar(View view) {
        //action para llamar automaticamente, busca la mejor aplicacion
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:952000243"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void maps(View view) {
        //action para abrir la ubicacion en el mapa, busca al mejor aplicacion el detalle es el parametro
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:-18.013739816,-70.2510593169"));
        startActivity(intent);
    }
    public void foto(View view) {
        //action para abrir la camara
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
    public void email(View view) {
        //action para manda correo, busca la mejora aplicacion el parametro ayuda mucho
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Duda de Android");
        intent.putExtra(Intent.EXTRA_TEXT, "Buen día Ing. Wilson tengo la siguiente duda...");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"nosliwsys@gmail.com"});
        startActivity(intent);
    }

    public void whassap(View view) {//ENVIAR EL DATO DIRECTAMENTE ABRIENDO LA APP DE WHASAP SIN PERMISOS
        PackageManager packageManager = this.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        try {
            String url = "https://api.whatsapp.com/send?phone=" + "+51952000243" + "&text="
                    + URLEncoder.encode("Buen día, tenia una duda del curso ... ", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                this.startActivity(i);
            }
            else {
                Toast.makeText(this, "No tiene Whatsapp porfavor instale la app"
                        , Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
