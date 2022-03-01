package com.ceiba.vacuna.servicio.testdatabuilder;

import com.ceiba.vacuna.modelo.entidad.Vacuna;

import java.time.LocalDateTime;

public class VacunaTestDataBuilder {

    private Long id;
    private String nombreVacuna;
    private String estado;
    private LocalDateTime fecha;
    private String subsidiada;
    private Long valor;
    private Long idUsuario;
    private Long dosis;
    private String dosisPendiente;
    private Long tiempoEntreDosis;

    public VacunaTestDataBuilder() {
        nombreVacuna = "tetano";
        estado = "aplicada";
        fecha = LocalDateTime.now();
        subsidiada = "si";
        valor = 0L;
        dosis = 1L;
        idUsuario = 1L;
    }

    public VacunaTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public VacunaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public VacunaTestDataBuilder conFechaAplicacion(LocalDateTime fechaAplicacion) {
        this.fecha = fechaAplicacion;
        return this;
    }

    public VacunaTestDataBuilder conNombre(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
        return this;
    }

    public Vacuna build() {
        return new Vacuna(id,nombreVacuna, estado,fecha,subsidiada,valor, dosis, idUsuario, dosisPendiente, tiempoEntreDosis);
    }
}
