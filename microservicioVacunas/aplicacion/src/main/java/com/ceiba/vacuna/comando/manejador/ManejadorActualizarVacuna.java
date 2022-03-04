package com.ceiba.vacuna.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.servicio.ServicioActualizarEstadoVacuna;
import org.springframework.stereotype.Component;

import com.ceiba.vacuna.comando.ComandoVacuna;
import com.ceiba.vacuna.comando.fabrica.FabricaVacuna;

@Component
public class ManejadorActualizarVacuna implements ManejadorComando<ComandoVacuna> {

    private final FabricaVacuna fabricaVacuna;
    private final ServicioActualizarEstadoVacuna servicioActualizarVacuna;

    public ManejadorActualizarVacuna(FabricaVacuna fabricaUsuario, ServicioActualizarEstadoVacuna servicioActualizarUsuario) {
        this.fabricaVacuna = fabricaUsuario;
        this.servicioActualizarVacuna = servicioActualizarUsuario;
    }

    public void ejecutar(ComandoVacuna comandoUsuario) {
        Vacuna vacuna = this.fabricaVacuna.crear(comandoUsuario);
        this.servicioActualizarVacuna.ejecutar(vacuna);
    }
}
