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

    public List<DtoVacuna> ejecutar(String tipoDocumento, String documento){ return this.daoVacuna.listarAplicadas(tipoDocumento, documento); }

    public List<DtoVacuna> litarTodas(){ return this.daoVacuna.listarTodas(); }

}
