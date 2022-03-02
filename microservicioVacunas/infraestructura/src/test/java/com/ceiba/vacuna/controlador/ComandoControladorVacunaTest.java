package com.ceiba.vacuna.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.vacuna.comando.ComandoVacuna;
import com.ceiba.vacuna.servicio.testdatabuilder.ComandoVacunaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorVacuna.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorVacunaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una vacuna")
    void deberiaCrearUnaVacuna() throws Exception{
        // arrange
        ComandoVacuna vacuna = new ComandoVacunaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/vacunas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vacuna)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    @DisplayName("Deberia crear una vacuna con estado pendiente")
    void deberiaCrearUnaVacunaEnEstadoPendiente() throws Exception{
        // arrange
        ComandoVacuna vacuna = new ComandoVacunaTestDataBuilder().conEstado("pendiente").build();
        // act - assert
        mocMvc.perform(post("/vacunas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vacuna)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    @DisplayName("Deberia actualizar una vacuna")
    void deberiaActualizarUnaVacuna() throws Exception{
        // arrange
        Long idUsuario = 1L;
        ComandoVacuna vacuna = new ComandoVacunaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/vacunas/{idUsuario}",idUsuario)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vacuna)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una vacuna")
    void deberiaEliminarUnaVacuna() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/vacunas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/vacunas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
