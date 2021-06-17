package com.ceiba.adn.dominio.servicio;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.modelo.dto.BodyDTO;
import com.ceiba.adn.dominio.modelo.entidad.Agenda;
import com.ceiba.adn.dominio.puerto.RepositorioAgenda;
import com.ceiba.util.excepcion.ExcepcionRangoFecha;
import com.ceiba.util.fabrica.AgendaFabrica;
import com.ceiba.util.mensaje.Mensajes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCrearAgenda {

    private final RepositorioAgenda repositorioAgenda;

    public ServicioCrearAgenda(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }


    public String ejecutar(BodyDTO bodyDTO){
        var agenda = AgendaFabrica.bodyaModel(bodyDTO);
        validarExistenciaPorFechas(agenda);
        return this.repositorioAgenda.crear(agenda);
    }

    private void validarExistenciaPorFechas(Agenda agenda){
        List<AgendaDTO> agendas = this.repositorioAgenda.listar();

        for (AgendaDTO agendaDTO: agendas
             ) {
            if (agenda.getFechaInicio().isEqual(agendaDTO.getFechaInicio())
            || agenda.getFechaInicio().isAfter(agendaDTO.getFechaInicio())&&agenda.getFechaInicio().isBefore(agendaDTO.getFechaFinal())
            || agenda.getFechaFinal().isAfter(agendaDTO.getFechaInicio())&&agenda.getFechaInicio().isBefore(agendaDTO.getFechaFinal())){
                throw new ExcepcionRangoFecha(Mensajes.EXISTENCIA_AGENDA_FECHA);
            }
        }


    }

}
