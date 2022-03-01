package com.ceiba.configuracion;

import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;
import com.ceiba.vacuna.servicio.ServicioActualizarVacuna;
import com.ceiba.vacuna.servicio.ServicioCrearVacuna;
import com.ceiba.vacuna.servicio.ServicioEliminarVacuna;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioVacuna {

    @Bean
    public ServicioCrearVacuna servicioCrearVacuna(RepositorioVacuna repositorioVacuna) {
        return new ServicioCrearVacuna(repositorioVacuna);
    }

    @Bean
    public ServicioEliminarVacuna servicioEliminarVacuna(RepositorioVacuna repositorioVacuna) {
        return new ServicioEliminarVacuna(repositorioVacuna);
    }

    @Bean
    public ServicioActualizarVacuna servicioActualizarVacuna(RepositorioVacuna repositorioVacuna) {
        return new ServicioActualizarVacuna(repositorioVacuna);
    }
	

}
