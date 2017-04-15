package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Configures Items Datasource, with prefix spring.ds_items in application.properties.
 * 
 * @author s.tsourdos
 */
@Configuration
public class DatabaseItemsConfig {

    @Bean(name = "dsItems")
    @ConfigurationProperties(prefix = "spring.ds_items")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcItems")
    @Autowired
    public JdbcTemplate jdbcTemplate(@Qualifier("dsItems") DataSource dsItems) {
        return new JdbcTemplate(dsItems);
    }
}
