package br.com.jeancarlos.spring_batch_v5.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class DatSourceConfig {
    
    @Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource springDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "app.datasource")
	public DataSource appDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
