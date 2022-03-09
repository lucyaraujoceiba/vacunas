package com.ceiba.configuracion;

import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;
import com.ceiba.vacuna.servicio.ServicioActualizarEstadoVacuna;
import com.ceiba.vacuna.servicio.ServicioRegistrarVacunaUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioVacuna {

    @Bean
    public ServicioRegistrarVacunaUsuario servicioCrearVacuna(RepositorioVacuna repositorioVacuna) {
        return new ServicioRegistrarVacunaUsuario(repositorioVacuna);
    }

    @Bean
    public ServicioActualizarEstadoVacuna servicioActualizarVacuna(RepositorioVacuna repositorioVacuna) {
        return new ServicioActualizarEstadoVacuna(repositorioVacuna);
    }
	

}
