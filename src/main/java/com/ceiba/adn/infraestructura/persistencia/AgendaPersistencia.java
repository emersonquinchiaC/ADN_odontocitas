package com.ceiba.adn.infraestructura.persistencia;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.modelo.entidad.Agenda;
import com.ceiba.adn.dominio.puerto.RepositorioAgenda;
import com.ceiba.adn.infraestructura.repositorio.AgendaRepositorioSQL;
import com.ceiba.util.fabrica.AgendaFabrica;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AgendaPersistencia implements RepositorioAgenda {

    private final AgendaRepositorioSQL agendaRepositorioSQL;

    public AgendaPersistencia(AgendaRepositorioSQL agendaRepositorioSQL) {
        this.agendaRepositorioSQL = agendaRepositorioSQL;
    }

    @Override
    public String crear(Agenda agenda) {
        this.agendaRepositorioSQL.save(AgendaFabrica.modelaEntidad(agenda));
        return agenda.toString();
    }

    @Override
    public boolean existe(String identificaionUsuario) {
        if(this.agendaRepositorioSQL.findByIdentificacionUsuario(identificaionUsuario).isEmpty())
        {
            return true;
        }else{
            return  false;
        }


    }

    @Override
    public List<AgendaDTO> listar() {
        return this.agendaRepositorioSQL.findAll().stream().map(
                agendaMappeoEntidad -> AgendaFabrica.entidadaDTO(agendaMappeoEntidad)
        ).collect(Collectors.toUnmodifiableList());
    }
}
