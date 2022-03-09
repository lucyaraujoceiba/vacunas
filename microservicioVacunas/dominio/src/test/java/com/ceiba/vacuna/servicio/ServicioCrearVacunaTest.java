package com.ceiba.vacuna.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;
import com.ceiba.vacuna.servicio.testdatabuilder.VacunaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearVacunaTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la vacuna")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Vacuna usuario = new VacunaTestDataBuilder().build();
        RepositorioVacuna repositorioUsuario = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString(), Mockito.anyLong(),Mockito.anyLong())).thenReturn(true);
        ServicioRegistrarVacunaUsuario servicioCrearUsuario = new ServicioRegistrarVacunaUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"La vacuna ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la vacuna aplicada de manera correcta")
    void deberiaCrearLaVacunaDeManeraCorrecta() {
        // arrange
        Vacuna vacuna = new VacunaTestDataBuilder().conEstado("aplicada").build();
        RepositorioVacuna repositorioVacuna = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioVacuna.existe(vacuna.getNombre(), vacuna.getIdUsuario(), vacuna.getDosis())).thenReturn(false);
        Mockito.when(repositorioVacuna.crear(vacuna)).thenReturn(10L);
        ServicioRegistrarVacunaUsuario servicioCrearVacuna = new ServicioRegistrarVacunaUsuario(repositorioVacuna);
        // act
        Long idUsuario = servicioCrearVacuna.ejecutar(vacuna);
        //- assert
        assertEquals(10L,idUsuario);
        assertEquals(vacuna.getFechaAplicacion(), LocalDate.now());
        Mockito.verify(repositorioVacuna, Mockito.times(1)).crear(vacuna);
    }



    @Test
    @DisplayName("Deberia Crear la vacuna en estado pendiente de manera correcta")
    void deberiaCrearLaVacunaEnEstadoPendienteDeManeraCorrecta() {
        // arrange
        Vacuna vacuna = new VacunaTestDataBuilder().conEstado("pendiente").build();

        RepositorioVacuna repositorioVacuna = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioVacuna.existe(vacuna.getNombre(), vacuna.getIdUsuario(), vacuna.getDosis())).thenReturn(false);
        Mockito.when(repositorioVacuna.crear(vacuna)).thenReturn(10L);
        ServicioRegistrarVacunaUsuario servicioCrearVacuna = new ServicioRegistrarVacunaUsuario(repositorioVacuna);
        // act
        Long idUsuario = servicioCrearVacuna.ejecutar(vacuna);
        LocalDate fechaAplicacion = vacuna.getFechaAplicacion();
        //- assert
        assertEquals(10L,idUsuario);
        assertEquals(fechaAplicacion,calcularFecha());
        Mockito.verify(repositorioVacuna, Mockito.times(1)).crear(vacuna);
    }

    private LocalDate calcularFecha(){
        LocalDate fechaVacuna = LocalDate.now().plusMonths(1);
        if(fechaVacuna.getDayOfWeek() == DayOfWeek.SUNDAY){
            fechaVacuna = fechaVacuna.plusDays(1);
        }
        return fechaVacuna;
    }
}
