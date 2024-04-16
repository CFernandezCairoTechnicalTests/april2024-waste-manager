package dev.cfernandezcairo.wastemanager.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
@Transactional
@PropertySource("classpath:persistence-h2.properties")
public class PersistenceJPAConfig {

    @Autowired
    private Environment env;

}