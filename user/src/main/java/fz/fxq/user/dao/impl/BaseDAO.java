package fz.fxq.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
}
