package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String clave;
    private LocalDateTime fecha;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String fechaNacimiento;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        clave = "1234";
        fecha = LocalDateTime.now();
        numeroIdentificacion = "1234";
        tipoIdentificacion = "cc";
        fechaNacimiento = "13-05-1991";
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha = fechaCreacion;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario, clave,fecha,numeroIdentificacion,tipoIdentificacion, fechaNacimiento);
    }
}
