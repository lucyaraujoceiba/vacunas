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

    public DtoListaVacunas ejecutar(String tipoDocumento, String documento){
        Long valorTotal= 0L;
        List<DtoVacuna>  listaVacunas = this.daoVacuna.listarPorUsuario(tipoDocumento, documento);
        for (DtoVacuna dtoVacuna: listaVacunas) {
            valorTotal = valorTotal + dtoVacuna.getValor();
        }
        DtoListaVacunas dtoListaVacunas = new DtoListaVacunas(listaVacunas,valorTotal );
        return dtoListaVacunas;
    }
}
