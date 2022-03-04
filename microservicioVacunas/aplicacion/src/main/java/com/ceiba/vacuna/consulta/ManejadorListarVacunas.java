package com.ceiba.vacuna.consulta;

import java.util.List;

import com.ceiba.vacuna.puerto.dao.DaoVacuna;
import org.springframework.stereotype.Component;

import com.ceiba.vacuna.modelo.dto.DtoVacuna;

@Component
public class ManejadorListarVacunas {

    private final DaoVacuna daoVacuna;

    public ManejadorListarVacunas(DaoVacuna daoVacuna){
        this.daoVacuna = daoVacuna;
    }

    public List<DtoVacuna> ejecutar(Long idUsuario){ return this.daoVacuna.listarAplicadas(idUsuario); }

    public List<DtoVacuna> litarTodas(){ return this.daoVacuna.listarTodas(); }

}
