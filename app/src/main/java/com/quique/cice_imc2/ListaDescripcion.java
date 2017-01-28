package com.quique.cice_imc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ListaDescripcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_descripcion);

        Log.d(getClass().getCanonicalName(), "Entramos en el Grid de descripción");

        ((ListView)findViewById(R.id.lista_Descripcion)).setAdapter(new AdapterDescripcion(this));
    }
}
