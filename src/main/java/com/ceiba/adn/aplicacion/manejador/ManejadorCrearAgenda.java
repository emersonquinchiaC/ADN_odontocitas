package com.ceiba.adn.aplicacion.manejador;

import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.modelo.dto.BodyDTO;
import com.ceiba.adn.dominio.servicio.ServicioCrearAgenda;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearAgenda {

    private final ServicioCrearAgenda servicioCrearAgenda;

    public ManejadorCrearAgenda(ServicioCrearAgenda servicioCrearAgenda) {
        this.servicioCrearAgenda = servicioCrearAgenda;
    }

    public  String ejecutar(BodyDTO bodyDTO){
        return this.servicioCrearAgenda.ejecutar(bodyDTO);
    }
}
