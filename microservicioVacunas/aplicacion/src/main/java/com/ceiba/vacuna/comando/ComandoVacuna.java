package com.ceiba.vacuna.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoVacuna {

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
