package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String tipoSangre = resultSet.getString("tipo_sangre");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        String numeroident = resultSet.getString("numeroIdentificacion");
        String tipoDoc = resultSet.getString("tipoIdentificacion");
        String fechaNac = resultSet.getString("fechaNacimiento");
        return new DtoUsuario(id,nombre,tipoSangre,fecha, numeroident, tipoDoc, fechaNac);
    }

}
