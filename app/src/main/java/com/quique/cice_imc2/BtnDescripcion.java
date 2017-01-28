package com.quique.cice_imc2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by Quique on 28/01/2017.
 */

public class BtnDescripcion implements View.OnClickListener {
    private Context contexto;

    public Context getContexto() { return this.contexto; }
    public void setContexto(Context valor) { this.contexto = valor; }
    public BtnDescripcion(Context valor) { setContexto(valor); }

    @Override
    public void onClick(View v) {
        Log.d(getClass().getCanonicalName(), "Detectado click en botón de descripción");
        Activity actividad = (Activity)contexto;

        Log.d(getClass().getCanonicalName(), "Creamos el intent para enviar el hilo de ejecución a la descripcion");
        Intent descripcion = new Intent(contexto,ListaDescripcion.class);
        Log.d(getClass().getCanonicalName(), "Lanzamos el hilo a la siguiente actividad: ListaDescripcion");
        contexto.startActivity(descripcion);
    }
}
