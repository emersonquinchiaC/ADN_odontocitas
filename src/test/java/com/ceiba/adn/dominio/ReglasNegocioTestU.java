package com.ceiba.adn.dominio;

import com.ceiba.adn.dominio.modelo.ReglasNegocio;
import com.ceiba.util.excepcion.ExcepcionTipoConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReglasNegocioTestU {

    ReglasNegocio negocio;

    @Test
    public void validarFechaFinConTipoConsultaUrgencias(){
        String tipoConsulta = "urgencias";
        LocalDateTime fechaInicio = LocalDateTime.now();
        negocio = new ReglasNegocio();
        Assertions.assertEquals(fechaInicio.plusHours(1),negocio.calcularFechaFinal(fechaInicio,tipoConsulta));

    }

    @Test
    public void validarFechaFinConTipoConsultaControl(){
        String tipoConsulta = "control";
        LocalDateTime fechaInicio = LocalDateTime.now();
        negocio = new ReglasNegocio();
        Assertions.assertEquals(fechaInicio.plusMinutes(40),negocio.calcularFechaFinal(fechaInicio,tipoConsulta));

    }

    @Test
    public void validarFechaFinConTipoConsultaNoValido(){
        String tipoConsulta = "emegencia";
        LocalDateTime fechaInicio = LocalDateTime.now();
        negocio = new ReglasNegocio();

        Assertions.assertThrows(ExcepcionTipoConsulta.class,()
        -> {
            negocio.calcularFechaFinal(fechaInicio,tipoConsulta);
        });

    }

    @Test
    public void calcularPrecioTipoConsultaUrgencias(){
        String tipoConsulta = "urgencias";
        negocio = new ReglasNegocio();
        Assertions.assertEquals(30000d,negocio.calcularPrecio(tipoConsulta).doubleValue());

    }

    @Test
    public void calcularPrecioTipoConsultaControl(){
        String tipoConsulta = "control";
        negocio = new ReglasNegocio();
        Assertions.assertEquals(12000d,negocio.calcularPrecio(tipoConsulta).doubleValue());

    }

    @Test
    public void calcularPrecioConTipoConsultaNoValido(){
        String tipoConsulta = "emegencia";
        negocio = new ReglasNegocio();

        Assertions.assertThrows(ExcepcionTipoConsulta.class,()
                -> {
            negocio.calcularPrecio(tipoConsulta);
        });

    }



}
