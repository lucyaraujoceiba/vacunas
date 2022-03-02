package com.ceiba.vacuna.puerto.dao;

import com.ceiba.vacuna.modelo.dto.DtoVacuna;

import java.util.List;

public interface DaoVacuna {
    /**
     * Permite listar vacunas aplicadas de un usuario
     * @return las vacunas
     */
    List<DtoVacuna> listarAplicadas(Long idUsuario);

    /**
     * Permite listar todas las vacunas
     * @return las vacunas
     */
    List<DtoVacuna> listarTodas();

    /**
     * Permite listar vacunas pendientes
     * @param idUsuario
     * @return
     */
    List<DtoVacuna> listarPorUsuario(Long idUsuario);

    /**
     * Permite consultar el valor a pagar en la siguiente cita de vacunas
     * @param idUsuario
     * @return
     */
    Long valorApagarPorusuario(Long idUsuario);
}
