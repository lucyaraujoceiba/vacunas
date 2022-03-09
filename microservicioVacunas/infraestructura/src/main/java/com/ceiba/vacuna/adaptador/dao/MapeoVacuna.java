package com.ceiba.vacuna.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vacuna.modelo.dto.DtoVacuna;
import org.springframework.jdbc.core.RowMapper;

public class MapeoVacuna implements RowMapper<DtoVacuna>, MapperResult {

    @Override
    public DtoVacuna mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String estado = resultSet.getString("estado");
        LocalDate fechaAplicacion = extraerLocalDate(resultSet, "fecha_aplicacion");
        String subsidiada = resultSet.getString("subsidiada");
        Long valor = resultSet.getLong("valor");
        Long dosis = resultSet.getLong("dosis");
        Long idUsuario = resultSet.getLong("id_usuario");
        String dosisPendiente = resultSet.getString("dosis_pendiente");
        Long tiempoEntreDosis = resultSet.getLong("tiempo_entre_dosis");
        return new DtoVacuna(id,nombre,estado,fechaAplicacion, subsidiada, valor, dosis, idUsuario,dosisPendiente,tiempoEntreDosis);
    }

}
