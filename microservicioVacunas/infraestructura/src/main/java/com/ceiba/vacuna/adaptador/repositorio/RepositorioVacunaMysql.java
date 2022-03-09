package com.ceiba.vacuna.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vacuna.modelo.entidad.Vacuna;
import com.ceiba.vacuna.puerto.repositorio.RepositorioVacuna;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVacunaMysql implements RepositorioVacuna {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="vacuna", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="vacuna", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="vacuna", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="vacuna", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="vacuna", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioVacunaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Vacuna vacuna) {
        return this.customNamedParameterJdbcTemplate.crear(vacuna, sqlCrear);
    }

    @Override
    public boolean existe(String nombre, Long idUsuario, Long dosis) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        paramSource.addValue("id_usuario", idUsuario);
        paramSource.addValue("dosis", dosis);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Vacuna vacuna) {
        this.customNamedParameterJdbcTemplate.actualizar(vacuna, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
