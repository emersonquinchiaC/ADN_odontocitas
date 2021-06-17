package com.ceiba.adn.infraestructura.repositorio;

import com.ceiba.adn.infraestructura.entidad.AgendaMappeoEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgendaRepositorioSQL extends CrudRepository  <AgendaMappeoEntidad,String> {

    List<AgendaMappeoEntidad> findByIdentificacionUsuario(String idetificaionUsuario);

    List<AgendaMappeoEntidad> findAll();


}
