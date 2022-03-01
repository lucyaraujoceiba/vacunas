package com.ceiba.vacuna.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vacuna.servicio.ServicioEliminarVacuna;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarVacuna implements ManejadorComando<Long> {

    private final ServicioEliminarVacuna servicioEliminarVacuna;

    public ManejadorEliminarVacuna(ServicioEliminarVacuna servicioEliminarVacuna) {
        this.servicioEliminarVacuna = servicioEliminarVacuna;
    }

    public void ejecutar(Long idVacuna) {
        this.servicioEliminarVacuna.ejecutar(idVacuna);
    }
}
