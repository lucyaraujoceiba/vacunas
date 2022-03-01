package com.ceiba.vacuna.consulta;

import com.ceiba.vacuna.modelo.dto.DtoListaVacunas;
import com.ceiba.vacuna.modelo.dto.DtoVacuna;
import com.ceiba.vacuna.puerto.dao.DaoVacuna;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarVacunasPorUsuario {
    private final DaoVacuna daoVacuna;

    public ManejadorListarVacunasPorUsuario(DaoVacuna daoVacuna){
        this.daoVacuna = daoVacuna;
    }

    public DtoListaVacunas ejecutar(Long idUsuario){
        Long valorTotal= 0L;
        List<DtoVacuna>  listaVacunas = this.daoVacuna.listarPorUsuario(idUsuario);
        if(!listaVacunas.isEmpty() || listaVacunas.size() != 0) {
             valorTotal = this.daoVacuna.valorApagarPorusuario(idUsuario);
        }
        DtoListaVacunas dtoListaVacunas = new DtoListaVacunas(listaVacunas,valorTotal );
        return dtoListaVacunas;
    }
}
