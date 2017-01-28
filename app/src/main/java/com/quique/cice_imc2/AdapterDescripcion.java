package com.quique.cice_imc2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Quique on 28/01/2017.
 */

public class AdapterDescripcion extends BaseAdapter {
    private Context contexto;
    private Integer[] listaIDImagenes = {
            R.drawable.desnutrido,
            R.drawable.bajopeso,
            R.drawable.normal,
            R.drawable.sobrepeso,
            R.drawable.obeso,
    };
    private Integer[] listaIDDescripcion = {
            R.string.respDesnutrido,
            R.string.respBajoPeso,
            R.string.respNormal,
            R.string.respSobrePeso,
            R.string.respObeso
    };

    public Context getContexto() { return contexto; }
    public void setContexto(Context valor) { this.contexto = valor; }
    public AdapterDescripcion(Context valor) { setContexto(valor); }

    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() { return listaIDDescripcion.length; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(getClass().getCanonicalName(), "Entramos en el adapter de las descripciones");

        Activity activity = (Activity) contexto;
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View nodoDescripcion = layoutInflater.inflate(R.layout.nodo_lista_descripcion, parent, false);

        Log.d(getClass().getCanonicalName(), "Cargamos los parámetros de la vista");
        ((TextView)nodoDescripcion.findViewById(R.id.nodoDescripcion)).setText(listaIDDescripcion[position]);
        ((ImageView)nodoDescripcion.findViewById(R.id.nodoImagen)).setImageResource(listaIDImagenes[position]);

        Log.d(getClass().getCanonicalName(), "Devolvemos la vista maquetada al adapter");
        return nodoDescripcion;
    }
}
