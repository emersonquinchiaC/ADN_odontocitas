package com.ceiba.adn.infraestructura.controlador;

import com.ceiba.adn.aplicacion.manejador.ManejadorCrearAgenda;
import com.ceiba.adn.aplicacion.manejador.ManejadorListarTodos;
import com.ceiba.adn.dominio.modelo.dto.AgendaDTO;
import com.ceiba.adn.dominio.modelo.dto.BodyDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
@Api (tags = "Controlador Comando Agenda")
public class ComandoControladorUsuario {

    private final ManejadorCrearAgenda manejadorCrearAgenda;
    private final ManejadorListarTodos manejadorListarTodos;

    @Autowired
    public ComandoControladorUsuario(ManejadorCrearAgenda manejadorCrearAgenda, ManejadorListarTodos manejadorListarTodos) {
        this.manejadorCrearAgenda = manejadorCrearAgenda;
        this.manejadorListarTodos = manejadorListarTodos;
    }

    @PostMapping
    @ApiOperation("Crear Agenda")
    public  String crear (@RequestBody BodyDTO bodyDTO){
        return  this.manejadorCrearAgenda.ejecutar(bodyDTO);
    }

    @GetMapping
    @ApiOperation("Listar Todas Agenda")
    public List<AgendaDTO> listar (){
        return  this.manejadorListarTodos.ejecutar();
    }

}
