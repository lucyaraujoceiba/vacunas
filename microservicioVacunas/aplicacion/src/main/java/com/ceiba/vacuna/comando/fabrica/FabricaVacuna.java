package com.ceiba.vacuna.comando.fabrica;

import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.comando.ComandoVacuna;
import org.springframework.stereotype.Component;

@Component
public class FabricaVacuna {

    public Vacuna crear(ComandoVacuna comandoVacuna) {
        return new Vacuna(
                comandoVacuna.getId(),
                comandoVacuna.getNombre(),
                comandoVacuna.getEstado(),
                comandoVacuna.getFechaAplicacion(),
                comandoVacuna.getSubsidiada(),
                comandoVacuna.getValor(),
                comandoVacuna.getDosis(),
                comandoVacuna.getIdUsuario(),
                comandoVacuna.getDosisPendiente(),
                comandoVacuna.getTiempoEntreDosis()
        );
    }

}
