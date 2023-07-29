import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan({"org.lessons.java.dao", "org.lessons.java.service", "org.lessons.java.controller" })
public class AppConfig {
	
	
	//SEZIONE CONFIGURAZIONE
	
			//non funziona
    @Value("classpath:import.sql")
    private Resource importSqlScript;
    
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/idm15");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
	
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.lessons.java.bean");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        // Altre proprietà di Hibernate...
        properties.setProperty(Environment.HBM2DDL_AUTO, "create");
        properties.setProperty(Environment.HBM2DDL_IMPORT_FILES, importSqlScript.getFilename());
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    
    //SEZIONE VAGONI
    
    
    
    
	
}
 
