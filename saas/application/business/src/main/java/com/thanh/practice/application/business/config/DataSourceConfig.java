package com.thanh.practice.application.business.config;

import com.thanh.practice.application.base.config.AbstractBaseDataSourceConfig;
import com.thanh.practice.saas.infrastructure.common.config.SqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EntityScan("com.thanh.practice.saas.infrastructure.storage.jpa.entity")
@EnableJpaRepositories(basePackages = "com.thanh.practice.saas.infrastructure.storage.jpa.repository",
        entityManagerFactoryRef = "saasEntityManager",
        transactionManagerRef = "saasTransactionManager")
public class DataSourceConfig extends AbstractBaseDataSourceConfig {

    private final SaasConfig saasConfig;

    @Autowired
    public DataSourceConfig(SaasConfig saasConfig) {
        this.saasConfig = saasConfig;
        PACKAGE_TO_SCAN = "com.thanh.practice.saas.infrastructure.storage.jpa.entity";
    }

    @Bean
//    @Primary
    public LocalContainerEntityManagerFactoryBean saasEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(saasDataSource());
        em.setPackagesToScan(this.PACKAGE_TO_SCAN);
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//        properties.put("hibernate.format_sql", true);
//        properties.put("hibernate.generate_statistics", true);
//        properties.put("hibernate.jdbc.batch_size", 5);
//        properties.put("hibernate.order_inserts", true);
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean
    public PlatformTransactionManager saasTransactionManager() {
        return new JpaTransactionManager(saasEntityManager().getObject());
    }

    @Bean
//    @Primary
    public DataSource saasDataSource() {
        SqlConfig sqlConfig = this.saasConfig.getSystem().getDataBase().getSql();
        DataSource dataSource = buildDataSource(sqlConfig);
        return dataSource;
    }


}
