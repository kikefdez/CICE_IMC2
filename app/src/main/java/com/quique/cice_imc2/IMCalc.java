package com.quique.cice_imc2;

import android.content.Context;
import android.util.Log;

/**
 * Created by Quique on 27/01/2017.
 */

public class IMCalc {
    public static float calcularIMC(float altura, float peso){
        float valorIMC = 0;
        if (altura % 1 == 0)
            altura = altura / 100;
        if(altura > 0)
            valorIMC = peso/(altura * altura);
        Log.d("calcularIMC", "El valor numérico obtenido de IMC es: " + valorIMC);
        return valorIMC;
    }

    public static String describirIMC(float valorIMC, Context contexto){
        String respuesta ="";

        if(valorIMC == 0)
            respuesta += contexto.getResources().getString(R.string.respError);
        else if (valorIMC < 16)
            respuesta += contexto.getResources().getString(R.string.respDesnutrido);
        else if(valorIMC < 18)
            respuesta += contexto.getResources().getString(R.string.respBajoPeso);
        else if(valorIMC < 25)
            respuesta += contexto.getResources().getString(R.string.respNormal);
        else if(valorIMC < 31)
            respuesta += contexto.getResources().getString(R.string.respSobrePeso);
        else
            respuesta += contexto.getResources().getString(R.string.respObeso);
        Log.d("describirIMC", "El resultado del análisis es: " + respuesta);

        return respuesta;
    }
}
