package com.ceiba.adn.aplicacion.manejador;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;

import com.ceiba.adn.dominio.servicio.ServicioListarAgenda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTodos {

    private final ServicioListarAgenda servicioListarAgenda;

    public ManejadorListarTodos(ServicioListarAgenda servicioListarAgenda) {
        this.servicioListarAgenda = servicioListarAgenda;
    }

    public List<AgendaDTO> ejecutar(){
        return this.servicioListarAgenda.ejecutar();
    }

}
