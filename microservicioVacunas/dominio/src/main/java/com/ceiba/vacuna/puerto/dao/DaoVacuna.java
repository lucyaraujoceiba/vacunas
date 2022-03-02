package com.ceiba.vacuna.puerto.dao;


import com.ceiba.vacuna.modelo.dto.DtoListaVacunas;
import com.ceiba.vacuna.modelo.dto.DtoVacuna;

import java.util.List;

public interface DaoVacuna {
    /**
     * Permite listar vacunas
     * @return las vacunas
     */
    List<DtoVacuna> listar(Long idUsuario);

    List<DtoVacuna> listarPorUsuario(Long idUsuario);

    Long valorApagarPorusuario(Long idUsuario);
}
