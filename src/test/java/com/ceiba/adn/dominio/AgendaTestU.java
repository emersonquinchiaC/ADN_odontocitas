package com.ceiba.adn.dominio;

import com.ceiba.adn.dominio.modelo.entidad.Agenda;
import com.ceiba.util.excepcion.ExcepcionTipoConsulta;
import com.ceiba.util.excepcion.ExcepcionValorNulo;
import com.ceiba.util.excepcion.ExcepcionValorVacio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AgendaTestU {

    private Agenda agenda;

    @Test
    public void crearAgendaConIdNulo(){
        Assertions.assertThrows(ExcepcionValorNulo.class, ()-> {
            agenda = new Agenda( null, null, null, null);
        });
    }
    @Test
    public void crearAgendaConIdentificacionNula(){
        Assertions.assertThrows(ExcepcionValorNulo.class, ()-> {
            agenda = new Agenda( null, null, null, null);
        });
    }
    @Test
    public void crearAgendaConIdentificacionVacia(){
        Assertions.assertThrows(ExcepcionValorVacio.class, ()-> {
            agenda = new Agenda( "", null, null, null);
        });
    }
    @Test
    public void crearAgendaConNombreUsaurioNulo(){
        Assertions.assertThrows(ExcepcionValorNulo.class, ()-> {
            agenda = new Agenda( "1041235232", null, null, null);
        });
    }
    @Test
    public void crearAgendaConNombreUsuarioVacio(){
        Assertions.assertThrows(ExcepcionValorVacio.class, ()-> {
            agenda = new Agenda( "1041235232", "", null, null);
        });
    }
    @Test
    public void crearAgendaConTipoConsultaNulo(){
        Assertions.assertThrows(ExcepcionValorNulo.class, ()-> {
            agenda = new Agenda( "1041235232", "Emerson Quinchia", null, null);
        });
    }
    @Test
    public void crearAgendaConTipoConsultaVacio(){
        Assertions.assertThrows(ExcepcionValorVacio.class, ()-> {
            agenda = new Agenda( "1041235232", "Emerson Quinchia", "",  null );
        });
    }
    @Test
    public void crearAgendaConFechaInicioNula(){
        Assertions.assertThrows(ExcepcionValorNulo.class, ()-> {
            agenda = new Agenda("1041235232", "Emerson Quinchia", "Urgencias",  null);
        });
    }public void crearAgendaConFechaTipoConsultaNoValido(){
        Assertions.assertThrows(ExcepcionTipoConsulta.class, ()-> {
            agenda = new Agenda("1041235232", "Emerson Quinchia", "Emergencias",  null);
        });
    }


}
