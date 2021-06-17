package com.ceiba.adn.infraestructura.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
@Getter
@AllArgsConstructor
public class AgendaMappeoEntidad {



    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "identificacion_usuario")
    private String identificacionUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "tipo_consulta")
    private String tipoConsulta;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFinal;

    @Column(name = "precio")
    private double precio;

    public AgendaMappeoEntidad() {

    }
}
