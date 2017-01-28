package com.quique.cice_imc2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Quique on 27/01/2017.
 */

public class BtnListener implements View.OnClickListener {
    private Context contexto;

    public Context getContexto() { return this.contexto; }
    public void setContexto(Context valor) { this.contexto = valor; }
    public BtnListener(Context valor) { setContexto(valor); }

    @Override
    public void onClick(View v) {
        Log.d(getClass().getCanonicalName(), "Detectado click en botón");
        Activity actividad = (Activity)contexto;

        Log.d(getClass().getCanonicalName(), "Recuperamos los valores introducidos");
        String cajaAltura = "" + ((EditText)actividad.findViewById(R.id.cajaAltura)).getText().toString();
        String cajaPeso = "" + ((EditText)actividad.findViewById(R.id.cajaPeso)).getText().toString();

        if(cajaAltura != "" && cajaPeso != "") {
            Log.d(getClass().getCanonicalName(), "Valor recuperado de Altura: " + cajaAltura + " cm.");
            Log.d(getClass().getCanonicalName(), "Valor recuperado de Peso: " + cajaPeso + " kg.");

            float valorIMC = IMCalc.calcularIMC(Float.parseFloat(cajaAltura), Float.parseFloat(cajaPeso));

            Log.d(getClass().getCanonicalName(), "Creamos el intent para enviar el hilo de ejecución a la respuesta");
            Intent respuesta = new Intent(contexto,Resultados.class);

            Log.d(getClass().getCanonicalName(), "Cargamos en en Bundle los valores de altura, peso y valorIMC");
            respuesta.putExtra("valorAltura", cajaAltura);
            respuesta.putExtra("valorPeso", cajaPeso);
            respuesta.putExtra("valorIMC", "" + valorIMC);

            Log.d(getClass().getCanonicalName(), "Lanzamos el hilo a la siguiente actividad: Resultados");
            contexto.startActivity(respuesta);

        } else {
            if(cajaAltura == "" && cajaPeso =="")
                Toast.makeText(contexto, contexto.getResources().getString(R.string.respErrorAmbos), Toast.LENGTH_SHORT).show();
            else{
                if(cajaAltura=="")
                    Toast.makeText(contexto, contexto.getResources().getString(R.string.respErrorAltura), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(contexto, contexto.getResources().getString(R.string.respErrorPeso), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
