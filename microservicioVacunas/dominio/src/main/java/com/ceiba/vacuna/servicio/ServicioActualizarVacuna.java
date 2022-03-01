package com.ceiba.vacuna.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;

public class ServicioActualizarVacuna {

    private static final String LA_VACUNA_NO_EXISTE_EN_EL_SISTEMA = "La vacuna no existe en el sistema";

    private final RepositorioVacuna repositorioVacuna;

    public ServicioActualizarVacuna(RepositorioVacuna repositorioVacuna) {
        this.repositorioVacuna = repositorioVacuna;
    }

    public void ejecutar(Vacuna vacuna) {
        validarExistenciaPrevia(vacuna);
        this.repositorioVacuna.actualizar(vacuna);
    }

    private void validarExistenciaPrevia(Vacuna vacuna) {
        boolean existe = this.repositorioVacuna.existePorId(vacuna.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_VACUNA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
