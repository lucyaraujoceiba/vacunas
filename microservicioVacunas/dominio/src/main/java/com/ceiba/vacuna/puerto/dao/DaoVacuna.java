package com.ceiba.vacuna.puerto.dao;

import com.ceiba.vacuna.modelo.dto.DtoVacuna;

import java.util.List;

public interface DaoVacuna {
    /**
     * Permite listar vacunas aplicadas de un usuario
     * @return las vacunas
     */
    List<DtoVacuna> listarAplicadas(String tipoDocumento, String documento);

    /**
     * Permite listar todas las vacunas
     * @return las vacunas
     */
    List<DtoVacuna> listarTodas();

    /**
     * Permite listar vacunas pendientes
     * @param tipoDocumento
     * @param documento
     * @return
     */
    List<DtoVacuna> listarPorUsuario(String tipoDocumento, String documento);

}
