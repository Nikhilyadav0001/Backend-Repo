package nikhil.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class PersistanceConfig {
	
	String location ="D:\\java files\\MySpringBootProjects\\Springjdbc-JdbcTemplate-App\\src\\main\\java\\nikhil\\config\\application.properties";
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource(new HikariConfig(location));
		return dataSource;}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource) ;}
}
