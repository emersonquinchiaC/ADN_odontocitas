package com.ceiba.adn.dominio.puerto;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.modelo.entidad.Agenda;

import java.util.List;

public interface RepositorioAgenda {

    String crear (Agenda agenda);

    boolean existe(String identificaionUsuario);

    List<AgendaDTO> listar();

}
