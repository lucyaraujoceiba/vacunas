package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExiste;


    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Usuario usuario) {
        return this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrear);
    }

    @Override
    public boolean existe(String tipoIdentificacion, String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoDoc", tipoIdentificacion);
        paramSource.addValue("documento", numeroIdentificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }
}
