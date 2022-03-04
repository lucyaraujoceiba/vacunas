package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_SANGRE = "Se debe ingresar el tipo de sangre";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";


    private Long id;
    private String nombre;
    private String tipoSangre;
    private LocalDateTime fechaCreacion;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String fechaNacimiento;

    public Usuario(Long id,String nombre, String tipoSangre,LocalDateTime fechaCreacion, String numeroIdentificacion, String tipoIdentificacion, String fechaNacimiento) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(tipoSangre, SE_DEBE_INGRESAR_EL_TIPO_SANGRE);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre;
        this.tipoSangre = tipoSangre;
        this.fechaCreacion = fechaCreacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
    }

}
