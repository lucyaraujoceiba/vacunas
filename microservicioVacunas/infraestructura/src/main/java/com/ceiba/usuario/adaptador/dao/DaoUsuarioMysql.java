package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import com.ceiba.vacuna.adaptador.dao.MapeoVacuna;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class DaoUsuarioMysql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String TIPO_DOCUMENTO = "tipoDocumento";
    private static final String DOCUMENTO = "documento";

    @SqlStatement(namespace="usuario", value="listar")
    private static String sqlListar;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoUsuario> listar(String tipoDoc, String documento) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(TIPO_DOCUMENTO, tipoDoc);
        paramSource.addValue(DOCUMENTO, documento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,paramSource, new MapeoUsuario());
    }
}
