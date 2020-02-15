package server.app.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public abstract class Dao<T> implements IDao<T> {

    protected final NamedParameterJdbcTemplate jdbcTemplate;

    public Dao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
