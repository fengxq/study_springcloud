package fz.fxq.user.dao.impl;

import fz.fxq.user.dao.LoginDAO;
import fz.fxq.user.po.UserPO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDAOImpl extends BaseDAO implements LoginDAO {

    @Override
    public List<UserPO> getUserPOList() {
        String sql = "select t.id userId,t.cust_name userName from customer_info t";

        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserPO>(UserPO.class));
    }

    @Override
    public UserPO getUserPO(String userId) {
        String sql = "select t.id userId,t.cust_name userName from customer_info t where t.id = ?";
        Object[] param = {
                userId
        };

        try {
            return this.jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<UserPO>(UserPO.class));
        } catch (EmptyResultDataAccessException e) {
            return new UserPO();
        }
    }

}
