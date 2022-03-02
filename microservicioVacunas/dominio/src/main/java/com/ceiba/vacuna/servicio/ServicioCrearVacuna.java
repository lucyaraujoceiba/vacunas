package com.ceiba.vacuna.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;


public class ServicioCrearVacuna {

    private static final String LA_VACUNA_YA_EXISTE_EN_EL_SISTEMA = "La vacuna ya existe en el sistema";
    private static final String PENDIENTE = "pendiente";
    private final RepositorioVacuna repositorioVacuna;

    public ServicioCrearVacuna(RepositorioVacuna repositorioVacuna) {
        this.repositorioVacuna = repositorioVacuna;
    }

    public Long ejecutar(Vacuna vacuna) {
        validarExistenciaPrevia(vacuna);

        if(vacuna.getEstado().equals(PENDIENTE)){
            vacuna.setFechaAplicacion(calcularfechaVacuna(vacuna.getTiempoEntreDosis()));
        }
        return this.repositorioVacuna.crear(vacuna);
    }

    private void validarExistenciaPrevia(Vacuna vacuna) {
        boolean existe = this.repositorioVacuna.existe(vacuna.getNombre(), vacuna.getIdUsuario(), vacuna.getDosis());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_VACUNA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private LocalDateTime calcularfechaVacuna(Long tiempo){
        LocalDateTime fechaVacuna;
        LocalDateTime fechaActual = LocalDateTime.now();
        fechaVacuna = fechaActual.plusMonths(tiempo);
        if(fechaVacuna.getDayOfWeek() == DayOfWeek.SUNDAY){
            fechaVacuna = fechaActual.plusDays(1);
        }
        return fechaVacuna;
    }
}
