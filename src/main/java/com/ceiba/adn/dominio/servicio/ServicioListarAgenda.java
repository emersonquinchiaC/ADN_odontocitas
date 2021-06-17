package com.ceiba.adn.dominio.servicio;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.puerto.RepositorioAgenda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioListarAgenda {


    private final RepositorioAgenda repositorioAgenda;

    public ServicioListarAgenda(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public List<AgendaDTO> ejecutar(){
        return this.repositorioAgenda.listar();
    }
}
