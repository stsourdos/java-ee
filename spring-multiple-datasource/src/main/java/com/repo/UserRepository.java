package com.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("jdbcUsers")
    protected JdbcTemplate jdbc;

    public User getUser(long id) {
        return jdbc.queryForObject("SELECT * FROM sb_user WHERE id=?", userMapper, id);
    }

    private static final RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getLong("id"), rs.getString("name"));
            user.setAlias(rs.getString("alias"));
            return user;
        }
    };
}
