package com.ceiba.vacuna.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;
import com.ceiba.vacuna.servicio.testdatabuilder.VacunaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarVacunaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la vacuna")
    void deberiaValidarLaExistenciaPreviaDelaVacuna() {
        // arrange
        Vacuna vacuna = new VacunaTestDataBuilder().conId(1L).build();
        RepositorioVacuna repositorioVacuna = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioVacuna.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarVacuna servicioActualizarVacuna = new ServicioActualizarVacuna(repositorioVacuna);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarVacuna.ejecutar(vacuna), ExcepcionDuplicidad.class,"La vacuna no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Vacuna vacuna = new VacunaTestDataBuilder().conId(1L).build();
        RepositorioVacuna repositorioVacuna = Mockito.mock(RepositorioVacuna.class);
        Mockito.when(repositorioVacuna.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarVacuna servicioActualizarVacuna = new ServicioActualizarVacuna(repositorioVacuna);
        // act
        servicioActualizarVacuna.ejecutar(vacuna);
        //assert
        Mockito.verify(repositorioVacuna,Mockito.times(1)).actualizar(vacuna);
    }
}
