package com.example.demo.using.dao;


import com.example.demo.using.entity.UserAndC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserAndCDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Integer> findCollegeByuid(int uid){
        String sql = "SELECT admin_cid FROM UserAndC WHERE uid=?";
        return jdbcTemplate.query(sql, new Object[]{uid}, new RowMapper<Integer>() {

            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(1);
            }
        });
    }

    public int insertUandC(UserAndC userAndC){
        String sql = "INSERT INTO UserAndC (uid,admin_cid) VALUES (?,?)";
        return jdbcTemplate.update(sql,userAndC.getUid(),userAndC.getAdmin_cid());
    }



}
