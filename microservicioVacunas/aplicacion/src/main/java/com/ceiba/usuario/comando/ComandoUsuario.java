package com.ceiba.usuario.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{

    private Long id;
    private String nombre;
    private String tipoSangre;
    private LocalDateTime fechaCreacion;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String fechaNacimiento;
}
