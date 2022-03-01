package com.ceiba.vacuna.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;


public class ServicioCrearVacuna {

    private static final String LA_VACUNA_YA_EXISTE_EN_EL_SISTEMA = "La vacuna ya existe en el sistema";

    private final RepositorioVacuna repositorioVacuna;

    public ServicioCrearVacuna(RepositorioVacuna repositorioVacuna) {
        this.repositorioVacuna = repositorioVacuna;
    }

    public Long ejecutar(Vacuna vacuna) {
        validarExistenciaPrevia(vacuna);
        //obtener la fecha de aplicación
        return this.repositorioVacuna.crear(vacuna);
    }

    private void validarExistenciaPrevia(Vacuna vacuna) {
        boolean existe = this.repositorioVacuna.existe(vacuna.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_VACUNA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
