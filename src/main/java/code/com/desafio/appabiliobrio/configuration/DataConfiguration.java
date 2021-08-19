package code.com.desafio.appabiliobrio.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("dev")
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("abiliobrio#");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbDesafio?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=GMT");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}

	@Bean
	public Properties aditionalProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		props.put("hibernate.show_sql", false);
		props.put("hibernate.format_sql", true);
		props.put("hibernate.hbm2ddl.auto", "update");

		return props;
	}
		
}


