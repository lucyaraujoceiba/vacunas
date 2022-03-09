package com.ceiba.vacuna.servicio.testdatabuilder;

import com.ceiba.vacuna.modelo.entidad.Vacuna;

import java.time.LocalDate;

public class VacunaTestDataBuilder {

    private Long id;
    private String nombreVacuna;
    private String estado;
    private LocalDate fecha;
    private String subsidiada;
    private Long valor;
    private Long idUsuario;
    private Long dosis;
    private String dosisPendiente;
    private Long tiempoEntreDosis;

    public VacunaTestDataBuilder() {
        nombreVacuna = "tetano";
        estado = "aplicada";
        fecha = null;
        subsidiada = "si";
        valor = 0L;
        dosis = 1L;
        dosisPendiente = "S";
        tiempoEntreDosis = 1L;
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

    public VacunaTestDataBuilder conFechaAplicacion(LocalDate fechaAplicacion) {
        this.fecha = fechaAplicacion;
        return this;
    }

    public VacunaTestDataBuilder conNombre(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
        return this;
    }

    public VacunaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
    public VacunaTestDataBuilder conTiempoEntreDosis(Long tiempoEntreDosis) {
        this.tiempoEntreDosis = tiempoEntreDosis;
        return this;
    }

    public VacunaTestDataBuilder convalorVacuna(Long valor) {
        this.valor = valor;
        return this;
    }

    public VacunaTestDataBuilder conSubsidiada(String subsidiada) {
        this.subsidiada = subsidiada;
        return this;
    }
    public VacunaTestDataBuilder convaDosisPendiente(String dosis) {
        this.dosisPendiente = dosis;
        return this;
    }

    public Vacuna build() {
        return new Vacuna(id,nombreVacuna, estado,fecha,subsidiada,valor, dosis, idUsuario, dosisPendiente, tiempoEntreDosis);
    }
}
