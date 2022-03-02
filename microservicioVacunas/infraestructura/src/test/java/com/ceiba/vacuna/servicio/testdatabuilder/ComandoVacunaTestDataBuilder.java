package com.ceiba.vacuna.servicio.testdatabuilder;

import com.ceiba.vacuna.comando.ComandoVacuna;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoVacunaTestDataBuilder {

    private Long idVacuna;
    private String nombre;
    private String estado;
    private LocalDateTime fecha;
    private String subsidiada;
    private Long valor;
    private Long dosis;
    private Long idUsuario;
    private String dosisPendiente;
    private Long tiempoEntreDosis;

    public ComandoVacunaTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        estado = "aplicada";
        fecha = LocalDateTime.now();
        subsidiada = "si";
        valor = 0L;
        dosis = 1L;
        idUsuario = 1L;
        dosisPendiente = "S";
        tiempoEntreDosis = 1L;
    }

    public ComandoVacunaTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ComandoVacuna build() {
        return new ComandoVacuna(idVacuna,nombre, estado,fecha, subsidiada,valor, dosis,idUsuario, dosisPendiente, tiempoEntreDosis);
    }
}
