package com.ceiba.adn.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BodyDTO {

    private String identificacionUsuario;
    private String nombreUsuario;
    private String tipoConsulta;
    private LocalDateTime fechaInicio;
}
