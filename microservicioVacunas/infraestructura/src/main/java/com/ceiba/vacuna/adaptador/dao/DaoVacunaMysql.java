package com.ceiba.vacuna.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vacuna.puerto.dao.DaoVacuna;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.vacuna.modelo.dto.DtoVacuna;

@Component
public class DaoVacunaMysql implements DaoVacuna {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String TIPO_DOCUMENTO = "tipoDocumento";
    private static final String DOCUMENTO = "documento";

    @SqlStatement(namespace="vacuna", value="listarAplicadas")
    private static String sqlListarAplicadas;

    @SqlStatement(namespace="vacuna", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="vacuna", value="listarPorUsuario")
    private static String sqlListarPorUsuario;

    @SqlStatement(namespace="vacuna", value="valorPorUsuario")
    private static String sqlValorPorUsuario;

    public DaoVacunaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVacuna> listarAplicadas(String tipoDocumento, String documento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(TIPO_DOCUMENTO, tipoDocumento);
        paramSource.addValue(DOCUMENTO, documento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarAplicadas, paramSource, new MapeoVacuna());
    }

    @Override
    public List<DtoVacuna> listarTodas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoVacuna());
    }

    @Override
    public List<DtoVacuna> listarPorUsuario(String tipoDocumento, String documento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(TIPO_DOCUMENTO, tipoDocumento);
        paramSource.addValue(DOCUMENTO, documento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorUsuario, paramSource, new MapeoVacuna());
    }

    @Override
    public Long valorApagarPorusuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
      //  paramSource.addValue(ID_USUARIO, idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlValorPorUsuario, paramSource, Long.class);
    }

}
