package com.ceiba.vacuna.servicio;

import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;
import com.ceiba.vacuna.servicio.testdatabuilder.VacunaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearVacunaTest {

   /* @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Vacuna usuario = new VacunaTestDataBuilder().build();
        RepositorioVacuna repositorioUsuario = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearVacuna servicioCrearUsuario = new ServicioCrearVacuna(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }*/

    @Test
    @DisplayName("Deberia Crear la vacuna de manera correcta")
    void deberiaCrearLaVacunaDeManeraCorrecta() {
        // arrange
        Vacuna vacuna = new VacunaTestDataBuilder().build();
        RepositorioVacuna repositorioVacuna = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioVacuna.existe(vacuna.getNombre(), vacuna.getIdUsuario(), vacuna.getDosis())).thenReturn(false);
        Mockito.when(repositorioVacuna.crear(vacuna)).thenReturn(10L);
        ServicioRegistrarVacunaUsuario servicioCrearVacuna = new ServicioRegistrarVacunaUsuario(repositorioVacuna);
        // act
        Long idUsuario = servicioCrearVacuna.ejecutar(vacuna);
        //- assert
        assertEquals(10L,idUsuario);
        Mockito.verify(repositorioVacuna, Mockito.times(1)).crear(vacuna);
    }
}
