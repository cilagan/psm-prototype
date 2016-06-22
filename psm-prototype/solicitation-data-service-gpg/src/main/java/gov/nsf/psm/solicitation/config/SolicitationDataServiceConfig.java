package gov.nsf.psm.solicitation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAO;
import gov.nsf.psm.solicitation.dao.SolicitationDataServiceDAOImpl;
import gov.nsf.psm.solicitation.service.SolicitationDataService;
import gov.nsf.psm.solicitation.service.SolicitationDataServiceImpl;

@Configuration
@EnableConfigurationProperties(SybaseConnectionSettings.class)
public class SolicitationDataServiceConfig {
    
    @Autowired
    private SybaseConnectionSettings databaseSettings;
    
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseSettings.getDriver());
        dataSource.setUrl(databaseSettings.getUrl());
        dataSource.setUsername(databaseSettings.getUsername());
        dataSource.setPassword(databaseSettings.getPassword());
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate psmFLJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
    
    @Bean
    public SolicitationDataServiceDAO solicitationDao(){
        return new SolicitationDataServiceDAOImpl();
    }
    
    @Bean
    public SolicitationDataService solicitationDataService(){
        return new SolicitationDataServiceImpl();
    }

}
