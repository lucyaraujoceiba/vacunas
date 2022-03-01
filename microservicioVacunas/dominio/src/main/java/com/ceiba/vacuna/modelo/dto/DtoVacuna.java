package com.ceiba.vacuna.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVacuna {
    private Long id;
    private String nombre;
    private String estado;
    private LocalDateTime fechaAplicacion;
    private String subsidiada;
    private Long valor;
    private Long dosis;
    private Long idUsuario;
    private String dosisPendiente;
    private Long tiempoEntreDosis;

}