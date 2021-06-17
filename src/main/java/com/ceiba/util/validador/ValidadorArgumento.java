package com.ceiba.util.validador;

import com.ceiba.util.excepcion.ExcepcionValorMayorCero;
import com.ceiba.util.excepcion.ExcepcionValorNulo;
import com.ceiba.util.excepcion.ExcepcionValorVacio;

public class ValidadorArgumento {

    private ValidadorArgumento() {}

    public static void validarArguemntoNulo(Object argumento, String mensaje){

        if (argumento==null){

            throw new ExcepcionValorNulo(mensaje);
        }

    }
    public static void validarArguemntoVacio(String argumento, String mensaje){

        if (argumento.isBlank()){

            throw new ExcepcionValorVacio(mensaje);
        }

    }
    public static void validarValorMatorCero(Double valor, String mensaje){

        if (valor<=0){

            throw new ExcepcionValorMayorCero(mensaje);
        }

    }






}
