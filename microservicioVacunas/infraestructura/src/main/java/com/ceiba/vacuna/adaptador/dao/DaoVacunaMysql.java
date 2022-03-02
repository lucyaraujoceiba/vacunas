package com.ceiba.vacuna.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vacuna.modelo.dto.DtoListaVacunas;
import com.ceiba.vacuna.puerto.dao.DaoVacuna;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.vacuna.modelo.dto.DtoVacuna;

@Component
public class DaoVacunaMysql implements DaoVacuna {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

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
    public List<DtoVacuna> listar(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource, new MapeoVacuna());
    }

    @Override
    public List<DtoVacuna> listarPorUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorUsuario, paramSource, new MapeoVacuna());
    }

    @Override
    public Long valorApagarPorusuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlValorPorUsuario, paramSource, Long.class);
    }

}
