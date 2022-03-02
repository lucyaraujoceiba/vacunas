package com.ceiba.vacuna.puerto.repositorio;

import com.ceiba.vacuna.modelo.entidad.Vacuna;

public interface RepositorioVacuna {
    /**
     * Permite crear unaa vacuna
     * @param vacuna
     * @return el id generado
     */
    Long crear(Vacuna vacuna);

    /**
     * Permite actualizar un vacuna
     * @param vacuna
     */
    void actualizar(Vacuna vacuna);

    /**
     * Permite eliminar un vacuna
     * @param idVacuna
     */
    void eliminar(Long idVacuna);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre, Long idUsuario, Long dosis);

    /**
     * Permite validar si existe un vacuna con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long idVacuna);
}
