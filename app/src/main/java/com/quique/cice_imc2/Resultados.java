package com.quique.cice_imc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Log.d(getClass().getCanonicalName(), "Recuperamos y cargamos los valores de altura y peso almacenados en el Intent");
        ((TextView)this.findViewById(R.id.respAltura)).setText(getIntent().getStringExtra("valorAltura").toString() + " cm");
        ((TextView)this.findViewById(R.id.respPeso)).setText(getIntent().getStringExtra("valorPeso").toString() + " kg");

        Log.d(getClass().getCanonicalName(), "Recuperamos el valorIMC y la descripción del Intent");
        Intent intent = this.getIntent();
        String valorIMC = intent.getStringExtra("valorIMC").toString();
        String descripcionIMC = IMCalc.describirIMC(Float.parseFloat(valorIMC), this);
        ((TextView)this.findViewById(R.id.respIndice)).setText(this.getResources().getString(R.string.cabeceraIndice) + ": " + valorIMC);
        ((TextView)this.findViewById(R.id.respDescripcion)).setText(descripcionIMC);

        Log.d(getClass().getCanonicalName(), "Recuperamos la imagen correspondiente a la descripción del intent");
        int codigoImagen=0;
        switch (descripcionIMC){
            case "Desnutrido":
                codigoImagen = R.drawable.desnutrido;
                break;
            case "Bajo Peso":
                codigoImagen = R.drawable.bajopeso;
                break;
            case "Normal":
                codigoImagen = R.drawable.normal;
                break;
            case "Sobrepeso":
                codigoImagen = R.drawable.sobrepeso;
                break;
            case "Obeso":
                codigoImagen = R.drawable.obeso;
                break;
        }
        Log.d(getClass().getCanonicalName(), "Cargamos la imagen correspondiente a la descripción");
        ((ImageView)this.findViewById(R.id.imagenIMC)).setImageResource(codigoImagen);

        ((Button)findViewById(R.id.btnDescripcion)).setOnClickListener(new BtnDescripcion(this));
    }
}
