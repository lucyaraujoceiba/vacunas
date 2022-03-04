package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String tipoSangre;
    private LocalDateTime fechaCreacion;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String fechaNacimiento;

}
