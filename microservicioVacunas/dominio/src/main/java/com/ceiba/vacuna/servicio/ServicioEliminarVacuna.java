package com.ceiba.vacuna.servicio;

import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;

public class ServicioEliminarVacuna {

    private final RepositorioVacuna repositorioVacuna;

    public ServicioEliminarVacuna(RepositorioVacuna repositorioVacuna) {
        this.repositorioVacuna = repositorioVacuna;
    }

    public void ejecutar(Long id) {
        this.repositorioVacuna.eliminar(id);
    }
}
