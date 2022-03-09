package com.ceiba.vacuna.controlador;

import java.util.List;

import com.ceiba.vacuna.consulta.ManejadorListarVacunas;
import com.ceiba.vacuna.consulta.ManejadorListarVacunasPorUsuario;
import com.ceiba.vacuna.modelo.dto.DtoListaVacunas;
import com.ceiba.vacuna.modelo.dto.DtoVacuna;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vacunas")
@Api(tags={"Controlador consulta vacunas"})
public class ConsultaControladorVacuna {

    private final ManejadorListarVacunas manejadorListarVacunas;
    private final ManejadorListarVacunasPorUsuario manejadorListarVacunasporUsuario;
    public ConsultaControladorVacuna(ManejadorListarVacunas manejadorListarVacunas,
                                     ManejadorListarVacunasPorUsuario manejadorListarVacunasporUsuario) {
        this.manejadorListarVacunas = manejadorListarVacunas;
        this.manejadorListarVacunasporUsuario = manejadorListarVacunasporUsuario;
    }

    @GetMapping(value="/pendientes/{tipoDoc}/{documento}")
    @ApiOperation("Listar Vacunas")
    public DtoListaVacunas listarPorUsuario(@PathVariable String tipoDoc, @PathVariable String documento) {

        return this.manejadorListarVacunasporUsuario.ejecutar(tipoDoc,documento );
    }
    @GetMapping(value="/aplicadas/{tipoDoc}/{documento}")
    @ApiOperation("Listar Vacunas")
    public List<DtoVacuna> listarVacunasAplicadas(@PathVariable String tipoDoc, @PathVariable String documento) {
        return this.manejadorListarVacunas.ejecutar(tipoDoc,documento);
    }

    @GetMapping
    @ApiOperation("Listar Vacunas")
    public List<DtoVacuna> listarVacunas() {
        return this.manejadorListarVacunas.litarTodas();
    }

}
