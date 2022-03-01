package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fecha;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String fechaNacimiento;

    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        clave = "1234";
        fecha = LocalDateTime.now();
        numeroIdentificacion = "1234";
        tipoIdentificacion = "cc";
        fechaNacimiento = "13-05-1991";
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, clave,fecha, numeroIdentificacion,tipoIdentificacion, fechaNacimiento);
    }
}
