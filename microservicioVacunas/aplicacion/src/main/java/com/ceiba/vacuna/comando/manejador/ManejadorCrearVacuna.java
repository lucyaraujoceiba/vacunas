package com.ceiba.vacuna.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.servicio.ServicioRegistrarVacunaUsuario;
import com.ceiba.vacuna.comando.ComandoVacuna;
import org.springframework.stereotype.Component;

import com.ceiba.vacuna.comando.fabrica.FabricaVacuna;

@Component
public class ManejadorCrearVacuna implements ManejadorComandoRespuesta<ComandoVacuna, ComandoRespuesta<Long>> {

    private final FabricaVacuna fabricaVacuna;
    private final ServicioRegistrarVacunaUsuario servicioCrearVacuna;

    public ManejadorCrearVacuna(FabricaVacuna fabricaVacuna, ServicioRegistrarVacunaUsuario servicioCrearVacuna) {
        this.fabricaVacuna = fabricaVacuna;
        this.servicioCrearVacuna = servicioCrearVacuna;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoVacuna comandoVacuna) {
        Vacuna vacuna = this.fabricaVacuna.crear(comandoVacuna);
        return new ComandoRespuesta<>(this.servicioCrearVacuna.ejecutar(vacuna));
    }
}
