package com.ceiba.util.fabrica;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.modelo.dto.BodyDTO;
import com.ceiba.adn.dominio.modelo.entidad.Agenda;
import com.ceiba.adn.infraestructura.entidad.AgendaMappeoEntidad;

public class AgendaFabrica {

    private AgendaFabrica() {}

    public static Agenda bodyaModel(BodyDTO agendaDTO){
        return  new Agenda(agendaDTO.getIdentificacionUsuario(), agendaDTO.getNombreUsuario(),
                agendaDTO.getTipoConsulta(), agendaDTO.getFechaInicio());
    }
    public static AgendaDTO modelaDTO(Agenda agenda){
        return  new AgendaDTO(agenda.getId(), agenda.getIdentificacionUsuario(), agenda.getNombreUsuario(),
                agenda.getTipoConsulta(), agenda.getFechaInicio(),agenda.getFechaFinal()
                , agenda.getPrecio());
    }

    public static AgendaDTO entidadaDTO(AgendaMappeoEntidad agendaEntidad){
        return  new AgendaDTO(agendaEntidad.getId(), agendaEntidad.getIdentificacionUsuario(), agendaEntidad.getNombreUsuario(),
                agendaEntidad.getTipoConsulta(), agendaEntidad.getFechaInicio(),agendaEntidad.getFechaFinal()
                , agendaEntidad.getPrecio());
    }

    public static AgendaMappeoEntidad modelaEntidad(Agenda agenda){
        return  new AgendaMappeoEntidad(agenda.getId(), agenda.getIdentificacionUsuario(), agenda.getNombreUsuario(),
                agenda.getTipoConsulta(), agenda.getFechaInicio(),agenda.getFechaFinal()
                , agenda.getPrecio());
    }


}
