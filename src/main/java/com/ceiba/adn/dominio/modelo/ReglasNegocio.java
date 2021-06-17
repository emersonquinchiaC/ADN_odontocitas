package com.ceiba.adn.dominio.modelo;

import com.ceiba.util.excepcion.ExcepcionTipoConsulta;
import com.ceiba.util.mensaje.Mensajes;

import java.time.LocalDateTime;

public class ReglasNegocio {

    private final String TIPO_CONSULTA_URGENCIAS = "URGENCIAS";
    private final String TIPO_CONSULTA_CONTROL = "CONTROL";

    public LocalDateTime calcularFechaFinal(LocalDateTime fechaInicio, String tipoConsulta){

        LocalDateTime fechaFin = LocalDateTime.now();

        if(validarTipoCita(tipoConsulta)){
            if(tipoConsulta.equalsIgnoreCase(TIPO_CONSULTA_CONTROL)){
                fechaFin = fechaInicio.plusMinutes(40);
            }else{
                fechaFin = fechaInicio.plusHours(1);
            }
        }
        return fechaFin;

    }

    public Double calcularPrecio(String tipoConsulta){
        double precio = 0d;

        if(validarTipoCita(tipoConsulta)){
            if(tipoConsulta.equalsIgnoreCase(TIPO_CONSULTA_CONTROL)){
                precio = 12000;
            }else{
                precio = 30000;
            }
        }
        return precio;
    }

    private boolean validarTipoCita(String tipoConsulta){

        if (tipoConsulta.equalsIgnoreCase(TIPO_CONSULTA_CONTROL)
                || tipoConsulta.equalsIgnoreCase(TIPO_CONSULTA_URGENCIAS)){
            return true;
        }else
            throw  new ExcepcionTipoConsulta(Mensajes.TIPO_CONSULTA_NO_VALIDO);

    }

}
