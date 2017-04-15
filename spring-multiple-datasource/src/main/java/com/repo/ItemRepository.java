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
public class ItemRepository {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("jdbcItems")
    protected JdbcTemplate jdbc;

    public Item getItem(long id) {
        return jdbc.queryForObject("SELECT * FROM sb_item WHERE id=?", itemMapper, id);
    }

    private static final RowMapper<Item> itemMapper = new RowMapper<Item>() {
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item(rs.getLong("id"), rs.getString("title"));
            item.setPrice(rs.getDouble("price"));
            return item;
        }
    };
}
