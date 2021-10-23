package com.thanh.practice.application.base.config;

import com.thanh.practice.saas.infrastructure.common.config.SqlConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public abstract class AbstractBaseDataSourceConfig {

//    public LocalContainerEntityManagerFactoryBean entityManager() {
//
//    }

    protected String PACKAGE_TO_SCAN;

    protected DataSource buildDataSource(SqlConfig sqlConfig) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(sqlConfig.getDriverClassName());
        hikariConfig.setJdbcUrl(sqlConfig.getUrl());
        hikariConfig.setUsername(sqlConfig.getUsername());
        hikariConfig.setPassword(sqlConfig.getPassword());
        hikariConfig.setMaximumPoolSize(sqlConfig.getMaximumPoolSize());
        hikariConfig.setConnectionTestQuery(sqlConfig.getConnectionTestQuery());
        return new HikariDataSource(hikariConfig);
    }

}
