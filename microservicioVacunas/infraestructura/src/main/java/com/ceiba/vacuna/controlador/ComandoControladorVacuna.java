package com.ceiba.vacuna.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.vacuna.comando.ComandoVacuna;
import com.ceiba.vacuna.comando.manejador.ManejadorActualizarVacuna;
import com.ceiba.vacuna.comando.manejador.ManejadorCrearVacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vacunas")
@Api(tags = { "Controlador comando vacuna"})
public class ComandoControladorVacuna {

    private final ManejadorCrearVacuna manejadorCrearVacuna;

	private final ManejadorActualizarVacuna manejadorActualizarVacuna;

    @Autowired
    public ComandoControladorVacuna(ManejadorCrearVacuna manejadorCrearVacuna,
									ManejadorActualizarVacuna manejadorActualizarVacuna) {
        this.manejadorCrearVacuna = manejadorCrearVacuna;
		this.manejadorActualizarVacuna = manejadorActualizarVacuna;
    }

    @PostMapping
    @ApiOperation("Crear Vacuna")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVacuna comandoVacuna) {
        return manejadorCrearVacuna.ejecutar(comandoVacuna);
    }

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Vacuna")
	public void actualizar(@RequestBody ComandoVacuna comandoVacuna, @PathVariable Long id) {
		comandoVacuna.setId(id);
		manejadorActualizarVacuna.ejecutar(comandoVacuna);
	}
}
