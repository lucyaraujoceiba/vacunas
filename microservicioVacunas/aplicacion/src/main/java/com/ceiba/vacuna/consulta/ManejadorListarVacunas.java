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

    public List<DtoVacuna> ejecutar(){ return this.daoVacuna.listar(); }

}
