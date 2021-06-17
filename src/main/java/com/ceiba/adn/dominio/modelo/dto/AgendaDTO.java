package com.ceiba.adn.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AgendaDTO {

    private String id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private String tipoConsulta;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private double precio;

}
