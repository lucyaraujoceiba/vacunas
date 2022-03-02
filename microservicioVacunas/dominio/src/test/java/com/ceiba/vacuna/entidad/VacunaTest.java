package com.ceiba.vacuna.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.servicio.testdatabuilder.VacunaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacunaTest {

    @Test
    @DisplayName("Deberia crear correctamente la vacuna")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        LocalDateTime fechaAplicacion = LocalDateTime.now();
        //act
        Vacuna vacuna = new VacunaTestDataBuilder().conFechaAplicacion(fechaAplicacion).conId(1L).build();
        //assert
        assertEquals(1, vacuna.getId());
        assertEquals("tetano", vacuna.getNombre());
        assertEquals("aplicada", vacuna.getEstado());
        assertEquals(fechaAplicacion, vacuna.getFechaAplicacion());
    }

    @Test
    void deberiaFallarSinNombreDeVacuna() {

        //Arrange
        VacunaTestDataBuilder vacunaTestDataBuilder = new VacunaTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vacunaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de la vacuna");
    }

    @Test
    void deberiaFallarSinEstado() {

        //Arrange
        VacunaTestDataBuilder vacunaTestDataBuilder = new VacunaTestDataBuilder().conEstado(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vacunaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el estado");
    }

    @Test
    void deberiaFallarSinFechaAplicacion() {

        //Arrange
        VacunaTestDataBuilder vacunaTestDataBuilder = new VacunaTestDataBuilder().conFechaAplicacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vacunaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de aplicacion");
    }

    @Test
    void deberiaFallarSinIdUsuario() {

        //Arrange
        VacunaTestDataBuilder vacunaTestDataBuilder = new VacunaTestDataBuilder().conIdUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vacunaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el identificador del usuario");
    }

    @Test
    void deberiaFallarSinTiempoEntreDosis() {

        //Arrange
        VacunaTestDataBuilder vacunaTestDataBuilder = new VacunaTestDataBuilder().conTiempoEntreDosis(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vacunaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tiempo entre dosis");
    }


}
