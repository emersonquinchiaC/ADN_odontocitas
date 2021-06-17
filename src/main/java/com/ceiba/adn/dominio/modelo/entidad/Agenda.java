package com.ceiba.adn.dominio.modelo.entidad;

import com.ceiba.adn.dominio.modelo.ReglasNegocio;
import com.ceiba.util.mensaje.Mensajes;
import com.ceiba.util.validador.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Getter
public class Agenda {

    private String id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private String tipoConsulta;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private double precio;
    ReglasNegocio reglasNegocio = new ReglasNegocio();

    public Agenda(String identificacionUsuario, String nombreUsuario, String tipoConsulta, LocalDateTime fechaInicio)
             {

        this.id = UUID.randomUUID().toString();

        ValidadorArgumento.validarArguemntoNulo(identificacionUsuario, Mensajes.IDENTIFICACION_USUARIO_NULA);
        ValidadorArgumento.validarArguemntoVacio(identificacionUsuario, Mensajes.IDENTIFICACION_USAURIO_VACIA);
        this.identificacionUsuario = identificacionUsuario;

        ValidadorArgumento.validarArguemntoNulo(nombreUsuario, Mensajes.NOMBRE_USAURIO_NULO);
        ValidadorArgumento.validarArguemntoVacio(nombreUsuario, Mensajes.NOMBRE_USUARIO_VACIO);
        this.nombreUsuario = nombreUsuario;

        ValidadorArgumento.validarArguemntoNulo(tipoConsulta, Mensajes.TIPO_CONSULTA_NULA);
        ValidadorArgumento.validarArguemntoVacio(tipoConsulta, Mensajes.TIPO_CONSULTA_VACIA);
        this.tipoConsulta = tipoConsulta;

        ValidadorArgumento.validarArguemntoNulo(fechaInicio, Mensajes.FECHA_INICIO_NULA);
        this.fechaInicio = fechaInicio;

        this.fechaFinal = reglasNegocio.calcularFechaFinal(fechaInicio,tipoConsulta) ;
        ValidadorArgumento.validarArguemntoNulo(fechaFinal, Mensajes.FECHA_FIN_NULA);

        this.precio = reglasNegocio.calcularPrecio(tipoConsulta);
        ValidadorArgumento.validarValorMatorCero(precio,Mensajes.PRECIO_INVALIDO);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(id, agenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id='" + id + '\'' +
                ", identificacionUsuario='" + identificacionUsuario + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", tipoConsulta='" + tipoConsulta + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", precio=" + precio +
                '}';
    }
}
